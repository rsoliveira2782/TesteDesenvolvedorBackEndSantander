package teste.desenvolvedor.backend.java.santander.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import teste.desenvolvedor.backend.java.santander.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private LocalDate dataNascimento;

    private String nome;

    private String numeroConta;

    private boolean planoExclusivo;

    private BigDecimal saldo;

    private BigDecimal saldoAnterior;

    private Set<Transacao> transacoes = new HashSet<>();

}
