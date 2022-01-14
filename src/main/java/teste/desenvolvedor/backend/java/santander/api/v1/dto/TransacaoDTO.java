package teste.desenvolvedor.backend.java.santander.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import teste.desenvolvedor.backend.java.santander.model.Cliente;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDTO {

    private Long clienteId;

    private LocalDate data;

    private Long id;

    private String tipo;

    private BigDecimal valor;
}
