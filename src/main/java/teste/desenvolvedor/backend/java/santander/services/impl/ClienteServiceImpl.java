package teste.desenvolvedor.backend.java.santander.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import teste.desenvolvedor.backend.java.santander.api.v1.dto.ClienteDTO;
import teste.desenvolvedor.backend.java.santander.exceptions.ValorNegativoOuZeroException;
import teste.desenvolvedor.backend.java.santander.api.v1.mapper.ClienteMapper;
import teste.desenvolvedor.backend.java.santander.model.Cliente;
import teste.desenvolvedor.backend.java.santander.model.Transacao;
import teste.desenvolvedor.backend.java.santander.repositories.ClienteRepository;
import teste.desenvolvedor.backend.java.santander.repositories.TransacaoRepository;
import teste.desenvolvedor.backend.java.santander.services.ClienteService;
import teste.desenvolvedor.backend.java.santander.util.BigDecimalUtil;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteMapper clienteMapper;

    private final ClienteRepository clienteRepository;

    private final TransacaoRepository transacaoRepository;

    private MathContext mc = new MathContext(2); // Precisão duas casas decimais

    @Value("${teste.desenvolvedor.backend.java.santander.tamanhoPagina}")
    private int tamanhoPagina;

    public ClienteServiceImpl(final ClienteRepository pClienteRepository, final TransacaoRepository pTransacaoRepository, final ClienteMapper pClienteMapper) {

	clienteRepository = pClienteRepository;
	transacaoRepository = pTransacaoRepository;
	clienteMapper = pClienteMapper;

    }

    @Override
    public ClienteDTO criarCliente(final ClienteDTO pClienteDTO) {

	pClienteDTO.setSaldoAnterior(pClienteDTO.getSaldo());

	return saveAndReturnDTO(clienteMapper.clienteDtoTOCliente(pClienteDTO));

    }

    @Override
    public void delete(final Cliente object) {

	clienteRepository.delete(object);

    }

    @Override
    public void deleteById(final Long pLong) {

	clienteRepository.deleteById(pLong);

    }

    @Override
    public void depositar(final Cliente pCliente, final BigDecimal pValor) throws ValorNegativoOuZeroException {

	validarValor(pValor);

	pCliente.setSaldoAnterior(pCliente.getSaldo());

	pCliente.setSaldo(pCliente.getSaldo().add(pValor));

	Transacao transacao = Transacao.builder().pTipo("deposito").pData(LocalDate.now()).pCliente(pCliente).pValor(pValor).build();

	transacaoRepository.save(transacao);

	pCliente.getTransacoes().add(transacao);

	clienteRepository.save(pCliente);

    }

    @Override
    public Set<Cliente> findAll() {

	Set<Cliente> clientes = new HashSet<>();

	clienteRepository.findAll().forEach(clientes::add);

	return clientes;

    }

    @Override
    public Cliente findById(final Long pLong) {

	return clienteRepository.findById(pLong).orElse(null);

    }

    @Override public ClienteDTO getClienteById(final Long pId) {

	return clienteMapper.clienteToClienteDTO(clienteRepository.findById(pId).orElse(null));

    }

    @Override
    public List<ClienteDTO> getClientes(final int pNumeroPagina) {

	Pageable paginacao = PageRequest.of(pNumeroPagina, tamanhoPagina);

	Page<Cliente> resultadoPaginado = clienteRepository.findAll(paginacao);

	if (resultadoPaginado.hasContent()) {
	    return resultadoPaginado.getContent().stream()
			    .map(pCliente -> {
				ClienteDTO clienteDTO = clienteMapper.clienteToClienteDTO(pCliente);
				return clienteDTO;
			    })
			    .collect(Collectors.toList());
	} else {

	    return new ArrayList<>();

	}

    }

    @Override
    public void sacar(final Cliente pCliente, final BigDecimal pValor) throws ValorNegativoOuZeroException {

	BigDecimal valorTaxado;

	validarValor(pValor);

	pCliente.setSaldoAnterior(pCliente.getSaldo());

	if (pCliente.isPlanoExclusivo() || BigDecimalUtil.ehMenorOuIgualA(pValor, new BigDecimal(100, mc))) {

	    // isento de taxa

	    pCliente.setSaldo(pCliente.getSaldo().subtract(pValor));

	} else {

	    if (BigDecimalUtil.ehMaiorQue(pValor, new BigDecimal(300, mc))) {

		// taxa de 1%
		valorTaxado = BigDecimalUtil.valorPercentual(pCliente.getSaldo(), new BigDecimal(1, mc));

	    } else {

		// taxa de 0.4 %
		valorTaxado = BigDecimalUtil.valorPercentual(pCliente.getSaldo(), new BigDecimal(0.4, mc));

	    }

	    pCliente.setSaldo(pCliente.getSaldo().subtract(valorTaxado).subtract(pValor));

	}

	Transacao transacao = Transacao.builder().pTipo("saque").pData(LocalDate.now()).pCliente(pCliente).pValor(pValor).build();

	transacaoRepository.save(transacao);

	pCliente.getTransacoes().add(transacao);

	clienteRepository.save(pCliente);

    }

    @Override
    public Cliente save(final Cliente object) {

	return clienteRepository.save(object);

    }

    private ClienteDTO saveAndReturnDTO(Cliente pCliente) {

	Cliente cliente = clienteRepository.save(pCliente);

	ClienteDTO returnDto = clienteMapper.clienteToClienteDTO(cliente);

	return returnDto;

    }

    private void validarValor(final BigDecimal pValor) throws ValorNegativoOuZeroException {

	if (BigDecimalUtil.ehMenorOuIgualA(pValor, BigDecimal.ZERO)) {

	    throw new ValorNegativoOuZeroException("O valor da transação não pode ser menor ou igual a zero");

	}

    }

}
