package teste.desenvolvedor.backend.java.santander.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Date dataNascimento;

    private Long id;

    private String nome;

    private String numeroConta;

    private boolean planoExclusivo;

    private BigDecimal saldo;

    private BigDecimal saldoAnterior;

    private List<TransacaoDTO> transacoes;

    public void addTransacao(TransacaoDTO pTransacaoDTO) {
	if (transacoes == null) {
	    transacoes = new ArrayList<>();
	}

	transacoes.add(pTransacaoDTO);
    }

    public List<TransacaoDTO> getTransacoes() {

	return transacoes;

    }

    public void setTransacoes(final List<TransacaoDTO> pTransacoes) {

	transacoes = pTransacoes;

    }

}
