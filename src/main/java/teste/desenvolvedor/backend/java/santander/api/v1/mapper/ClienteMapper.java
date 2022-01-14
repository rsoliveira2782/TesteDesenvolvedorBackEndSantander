package teste.desenvolvedor.backend.java.santander.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import teste.desenvolvedor.backend.java.santander.api.v1.dto.ClienteDTO;
import teste.desenvolvedor.backend.java.santander.model.Cliente;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente clienteDtoTOCliente(final ClienteDTO pClienteDTO);

    ClienteDTO clienteToClienteDTO(final Cliente pCliente);

}
