package teste.desenvolvedor.backend.java.santander.services.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import teste.desenvolvedor.backend.java.santander.model.Cliente;
import teste.desenvolvedor.backend.java.santander.repositories.ClienteRepository;
import teste.desenvolvedor.backend.java.santander.repositories.TransacaoRepository;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceImplTest {

    private Cliente clienteDeposito;

    private Cliente clienteIsentoPorPlano;

    private Cliente clienteIsentoPorValor;

    @Autowired
    @InjectMocks
    private ClienteServiceImpl clienteServiceImpl;

    private Cliente clienteTaxa04Porcento;

    private Cliente clienteTaxa1Porcento;

    private MathContext mc = new MathContext(2); // Precisao duas casas decimais

    @Mock
    ClienteRepository clienteRepository;

    @Mock
    TransacaoRepository transacaoRepository;

    @Test
    void depositar() {

	clienteDeposito = Cliente.builder().pDataNascimento(LocalDate.now()).pNome("CLIENTE DEPOSITO")
			.pNumeroConta("111111-1").pPlanoExclusivo(true).pSaldo(new BigDecimal(100.00)).build();

	when(clienteRepository.save(any())).thenReturn(clienteDeposito);
	clienteServiceImpl.save(clienteDeposito);

	clienteServiceImpl.depositar(clienteDeposito, new BigDecimal(10.00));

	assertEquals(new BigDecimal(100.00), clienteDeposito.getSaldoAnterior());
	assertEquals(new BigDecimal(110.00), clienteDeposito.getSaldo());

    }

    @Test
    void sacarComIsencaoDeTaxaPorPlanoExclusivo() {

	clienteIsentoPorPlano = Cliente.builder().pDataNascimento(LocalDate.now()).pNome("CLIENTE ISENTO POR PLANO EXCLUSIVO")
			.pNumeroConta("111111-1").pPlanoExclusivo(true).pSaldo(new BigDecimal(100.00)).build();

	when(clienteRepository.save(any())).thenReturn(clienteIsentoPorPlano);
	clienteServiceImpl.save(clienteIsentoPorPlano);

	clienteServiceImpl.sacar(clienteIsentoPorPlano, new BigDecimal(400.00));

	assertEquals(new BigDecimal(100.00), clienteIsentoPorPlano.getSaldoAnterior());
	assertEquals(new BigDecimal(-300.00), clienteIsentoPorPlano.getSaldo());

    }

    @Test
    void sacarComIsencaoDeTaxaPorValor() {

	clienteIsentoPorValor = Cliente.builder().pDataNascimento(LocalDate.now()).pNome("CLIENTE ISENTO POR VALOR")
			.pNumeroConta("111111-1").pPlanoExclusivo(false).pSaldo(new BigDecimal(100.00)).build();

	when(clienteRepository.save(any())).thenReturn(clienteIsentoPorValor);
	clienteServiceImpl.save(clienteIsentoPorValor);

	clienteServiceImpl.sacar(clienteIsentoPorValor, new BigDecimal(10.00));

	assertEquals(new BigDecimal(100.00), clienteIsentoPorValor.getSaldoAnterior());
	assertEquals(new BigDecimal(90.00), clienteIsentoPorValor.getSaldo());

    }

    @Test
    void sacarComTaxa04Porcento() {

	clienteTaxa04Porcento = Cliente.builder().pDataNascimento(LocalDate.now()).pNome("CLIENTE TAXA DE 0.4 PORCENTO")
			.pNumeroConta("111111-1").pPlanoExclusivo(false).pSaldo(new BigDecimal(100.00, mc)).build();

	when(clienteRepository.save(any())).thenReturn(clienteTaxa04Porcento);
	clienteServiceImpl.save(clienteTaxa04Porcento);

	clienteServiceImpl.sacar(clienteTaxa04Porcento, new BigDecimal(200.00, mc));

	assertEquals(new BigDecimal(100.00, mc), clienteTaxa04Porcento.getSaldoAnterior().round(mc));
	assertEquals(new BigDecimal(-100.40, mc), clienteTaxa04Porcento.getSaldo().round(mc));

    }

    @Test
    void sacarComTaxa1Porcento() {

	clienteTaxa1Porcento = Cliente.builder().pDataNascimento(LocalDate.now()).pNome("CLIENTE TAXA DE 1 PORCENTO")
			.pNumeroConta("111111-1").pPlanoExclusivo(false).pSaldo(new BigDecimal(100.00, mc)).build();

	when(clienteRepository.save(any())).thenReturn(clienteTaxa1Porcento);
	clienteServiceImpl.save(clienteTaxa1Porcento);

	clienteServiceImpl.sacar(clienteTaxa1Porcento, new BigDecimal(400.00, mc));

	assertEquals(new BigDecimal(100.00, mc), clienteTaxa1Porcento.getSaldoAnterior().round(mc));
	assertEquals(new BigDecimal(-301.00, mc), clienteTaxa1Porcento.getSaldo().round(mc));

    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }
}