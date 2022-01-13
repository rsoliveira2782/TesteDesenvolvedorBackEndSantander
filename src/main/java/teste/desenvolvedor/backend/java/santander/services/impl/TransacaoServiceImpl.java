package teste.desenvolvedor.backend.java.santander.services.impl;

import teste.desenvolvedor.backend.java.santander.model.Transacao;
import teste.desenvolvedor.backend.java.santander.repositories.TransacaoRepository;
import teste.desenvolvedor.backend.java.santander.services.TransacaoService;

import java.util.HashSet;
import java.util.Set;

public class TransacaoServiceImpl implements TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public TransacaoServiceImpl(final TransacaoRepository pTransacaoRepository) {

	transacaoRepository = pTransacaoRepository;

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
    public Transacao save(final Transacao object) {

	return transacaoRepository.save(object);

    }

}
