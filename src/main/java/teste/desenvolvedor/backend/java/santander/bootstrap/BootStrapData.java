package teste.desenvolvedor.backend.java.santander.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import teste.desenvolvedor.backend.java.santander.model.Cliente;
import teste.desenvolvedor.backend.java.santander.model.Transacao;
import teste.desenvolvedor.backend.java.santander.repositories.ClienteRepository;
import teste.desenvolvedor.backend.java.santander.repositories.TransacaoRepository;
import teste.desenvolvedor.backend.java.santander.services.ClienteService;
import teste.desenvolvedor.backend.java.santander.services.TransacaoService;

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

	Cliente cliente1 = Cliente.builder().pDataNascimento(LocalDate.of(1982, Month.FEBRUARY, 27)).pNome("Rodrigo")
			.pNumeroConta("111111-1").pPlanoExclusivo(true).pSaldo(new BigDecimal(100)).build();

	clienteRepository.save(cliente1);

	Transacao transacao1 = Transacao.builder().pTipo("saque").pData(LocalDate.now()).pCliente(cliente1).pValor(new BigDecimal(10)).build();
	Transacao transacao2 = Transacao.builder().pTipo("deposito").pData(LocalDate.now()).pCliente(cliente1).pValor(new BigDecimal(15)).build();

	transacaoRepository.save(transacao1);
	transacaoRepository.save(transacao2);

	cliente1.getTransacoes().add(transacao1);
	cliente1.getTransacoes().add(transacao2);

	clienteRepository.save(cliente1);

	System.out.println("Populando dados no BootStrap");
	System.out.println("Quantidade de clientes cadastrados: " + clienteRepository.count());
	System.out.println("Quantidade de transações cadastradas: " + transacaoRepository.count());

    }
}
