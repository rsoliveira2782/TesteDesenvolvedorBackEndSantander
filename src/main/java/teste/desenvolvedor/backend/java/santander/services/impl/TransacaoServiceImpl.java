package teste.desenvolvedor.backend.java.santander.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import teste.desenvolvedor.backend.java.santander.api.v1.dto.TransacaoDTO;
import teste.desenvolvedor.backend.java.santander.api.v1.mapper.TransacaoMapper;
import teste.desenvolvedor.backend.java.santander.model.Transacao;
import teste.desenvolvedor.backend.java.santander.repositories.TransacaoRepository;
import teste.desenvolvedor.backend.java.santander.services.TransacaoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    private final TransacaoMapper transacaoMapper;

    private final TransacaoRepository transacaoRepository;

    @Value("${teste.desenvolvedor.backend.java.santander.tamanhoPagina}")
    private int tamanhoPagina;

    public TransacaoServiceImpl(final TransacaoRepository pTransacaoRepository, final TransacaoMapper pTransacaoMapper) {

	transacaoRepository = pTransacaoRepository;
	transacaoMapper = pTransacaoMapper;

    }

    @Override
    public void delete(final Transacao object) {

	transacaoRepository.delete(object);

    }

    @Override
    public void deleteById(final Long pLong) {

	transacaoRepository.deleteById(pLong);

    }

    @Override
    public Set<Transacao> findAll() {

	Set<Transacao> transacoes = new HashSet<>();

	transacaoRepository.findAll().forEach(transacoes::add);

	return transacoes;

    }

    @Override
    public Transacao findById(final Long pLong) {

	return transacaoRepository.findById(pLong).orElse(null);

    }

    @Override
    public List<TransacaoDTO> getTransacoesPorTipoEData(final String pTipo, final LocalDate pData, final int pNumeroPagina) {

	Pageable paginacao = PageRequest.of(pNumeroPagina, tamanhoPagina);

	Transacao exemplo = Transacao.builder().pTipo(pTipo).pData(pData).build();

	Page<Transacao> resultadoPaginado = transacaoRepository.findAll(Example.of(exemplo), paginacao);

	if (resultadoPaginado.hasContent()) {
	    return resultadoPaginado.getContent().stream()
			    .map(pTransacao -> {
				TransacaoDTO transacaoDTO = transacaoMapper.transacaoToTransacaoDTO(pTransacao);
				return transacaoDTO;
			    })
			    .collect(Collectors.toList());
	} else {

	    return new ArrayList<>();

	}

    }

    @Override
    public Transacao save(final Transacao object) {

	return transacaoRepository.save(object);

    }

}
