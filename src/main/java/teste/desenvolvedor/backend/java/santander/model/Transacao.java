package teste.desenvolvedor.backend.java.santander.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Transacao extends BaseEntity {

    @ManyToOne
    private Cliente cliente;

    private LocalDate data;

    private String tipo;

    private BigDecimal valor;

    @Builder
    public Transacao(Cliente pCliente, LocalDate pData, String pTipo, BigDecimal pValor) {

	cliente = pCliente;
	data = pData;
	tipo = pTipo;
	valor = pValor;

    }
}
