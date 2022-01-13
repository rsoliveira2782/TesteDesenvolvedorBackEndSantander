package teste.desenvolvedor.backend.java.santander.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import teste.desenvolvedor.backend.java.santander.model.Cliente;
import teste.desenvolvedor.backend.java.santander.repositories.ClienteRepository;
import teste.desenvolvedor.backend.java.santander.repositories.TransacaoRepository;
import teste.desenvolvedor.backend.java.santander.services.ClienteService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ClienteServiceImplTest {

    @Mock
    ClienteRepository clienteRepository;

    ClienteService clienteService;

    @Mock
    TransacaoRepository transacaoRepository;

    //    @Test
    //    void findAll() {
    //
    //	// given
    //	Cliente cliente1 = Cliente.builder().pDataNascimento(LocalDate.of(1982, Month.FEBRUARY, 27)).pNome("Rodrigo")
    //			.pNumeroConta("111111-1").pPlanoExclusivo(true).pSaldo(new BigDecimal(100)).build();
    //
    //	Cliente cliente2 = Cliente.builder().pDataNascimento(LocalDate.now()).pNome("Fulano").pNumeroConta("222222-2").pPlanoExclusivo(true)
    //			.pSaldo(new BigDecimal(100)).build();
    //
    //	when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));
    //
    //	//when
    //	Set<Cliente> clientes = clienteService.findAll();
    //
    //	//then
    //	assertEquals(2, clientes.size());
    //
    //    }

    @BeforeEach
    void setUp() {

	MockitoAnnotations.openMocks(this);

	clienteService = new ClienteServiceImpl(clienteRepository, transacaoRepository);

    }
}