package teste.desenvolvedor.backend.java.santander.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import teste.desenvolvedor.backend.java.santander.model.Cliente;
import teste.desenvolvedor.backend.java.santander.model.Transacao;
import teste.desenvolvedor.backend.java.santander.repositories.ClienteRepository;
import teste.desenvolvedor.backend.java.santander.repositories.TransacaoRepository;
import teste.desenvolvedor.backend.java.santander.util.DadosAleatoriosUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Component
public class BootStrapData implements CommandLineRunner {

    private final ClienteRepository clienteRepository;

    private final TransacaoRepository transacaoRepository;

    public BootStrapData(final ClienteRepository pClienteRepository, final TransacaoRepository pTransacaoRepository) {

	clienteRepository = pClienteRepository;
	transacaoRepository = pTransacaoRepository;

    }

    @Override
    public void run(final String... args) throws Exception {

	Cliente cliente;
	Transacao transacao;

	String operacao;

	for (int i = 1; i <= 50; i++) {

	    cliente = Cliente.builder().pDataNascimento(DadosAleatoriosUtil.getDataAleatoria()).pNome("TESTE " + i).pNumeroConta(i + "-0").pPlanoExclusivo(true)
			    .pSaldo(DadosAleatoriosUtil.getValorAleatorio()).build();

	    clienteRepository.save(cliente);

	    for (int j = 1; j <= 5.; j++) {

		operacao = j % 2 == 0 ? "saque" : "deposito";

		transacao = Transacao.builder().pTipo(operacao).pData(LocalDate.now()).pCliente(cliente).pValor(DadosAleatoriosUtil.getValorAleatorio()).build();

		transacaoRepository.save(transacao);

		cliente.getTransacoes().add(transacao);

	    }

	    clienteRepository.save(cliente);

	}

    }
}
