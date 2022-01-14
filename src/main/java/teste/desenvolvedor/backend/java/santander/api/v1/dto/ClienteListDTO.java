package teste.desenvolvedor.backend.java.santander.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteListDTO {

    List<ClienteDTO> clientes;

}
