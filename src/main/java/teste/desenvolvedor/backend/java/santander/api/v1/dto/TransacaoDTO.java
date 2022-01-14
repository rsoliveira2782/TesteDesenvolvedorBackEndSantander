package teste.desenvolvedor.backend.java.santander.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDTO {

    private Long clienteId;

    private Date data;

    private Long id;

    private String tipo;

    private BigDecimal valor;
}
