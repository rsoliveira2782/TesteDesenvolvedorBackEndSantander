package teste.desenvolvedor.backend.java.santander.services;

import teste.desenvolvedor.backend.java.santander.api.v1.dto.ClienteDTO;
import teste.desenvolvedor.backend.java.santander.exceptions.ValorNegativoOuZeroException;
import teste.desenvolvedor.backend.java.santander.model.Cliente;

import java.math.BigDecimal;
import java.util.List;

public interface ClienteService extends CrudService<Cliente, Long> {

    public ClienteDTO criarCliente(final ClienteDTO pClienteDTO);

    public Cliente depositar(final Cliente pCliente, final BigDecimal pValor) throws ValorNegativoOuZeroException;

    public ClienteDTO depositarValor(final Long pIdCliente, final BigDecimal pValor);

    public ClienteDTO getClienteById(final Long pId);

    public List<ClienteDTO> getClientes(final int pNumeroPagina);

    public Cliente sacar(final Cliente pCliente, final BigDecimal pValor) throws ValorNegativoOuZeroException;

    public ClienteDTO sacarValor(final Long pIdCliente, final BigDecimal pValor);

}
