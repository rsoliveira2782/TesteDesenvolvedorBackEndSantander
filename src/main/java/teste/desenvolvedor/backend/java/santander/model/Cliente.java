package teste.desenvolvedor.backend.java.santander.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente extends BaseEntity {

    private LocalDate dataNascimento;

    private String nome;

    private String numeroConta;

    private boolean planoExclusivo;

    private BigDecimal saldo;

    private BigDecimal saldoAnterior;

    @OneToMany
    @JoinColumn(name = "cliente_id")
    private Set<Transacao> transacoes = new HashSet<>();

}
