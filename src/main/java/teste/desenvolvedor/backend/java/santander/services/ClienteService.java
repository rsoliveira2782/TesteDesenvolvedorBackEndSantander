package teste.desenvolvedor.backend.java.santander.services;

import teste.desenvolvedor.backend.java.santander.api.v1.dto.ClienteDTO;
import teste.desenvolvedor.backend.java.santander.exceptions.ValorNegativoOuZeroException;
import teste.desenvolvedor.backend.java.santander.model.Cliente;

import java.math.BigDecimal;
import java.util.List;

public interface ClienteService extends CrudService<Cliente, Long> {

    public ClienteDTO criarCliente(final ClienteDTO pClienteDTO);

    public void depositar(final Cliente pCliente, final BigDecimal pValor) throws ValorNegativoOuZeroException;

    public ClienteDTO getClienteById(final Long pId);

    public List<ClienteDTO> getClientes(final int pNumeroPagina);

    public void sacar(final Cliente pCliente, final BigDecimal pValor) throws ValorNegativoOuZeroException;

}
