package teste.desenvolvedor.backend.java.santander.services.impl;

import org.springframework.stereotype.Service;
import teste.desenvolvedor.backend.java.santander.model.Cliente;
import teste.desenvolvedor.backend.java.santander.repositories.ClienteRepository;
import teste.desenvolvedor.backend.java.santander.repositories.TransacaoRepository;
import teste.desenvolvedor.backend.java.santander.services.ClienteService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final TransacaoRepository transacaoRepository;

    public ClienteServiceImpl(final ClienteRepository pClienteRepository, final TransacaoRepository pTransacaoRepository) {

	clienteRepository = pClienteRepository;
	transacaoRepository = pTransacaoRepository;

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
    public Set<Cliente> findAll() {

	Set<Cliente> clientes = new HashSet<>();

	clienteRepository.findAll().forEach(clientes::add);

	return clientes;

    }

    @Override
    public Cliente findById(final Long pLong) {

	return clienteRepository.findById(pLong).orElse(null);

    }

    @Override
    public Cliente save(final Cliente object) {

	return clienteRepository.save(object);

    }

}
