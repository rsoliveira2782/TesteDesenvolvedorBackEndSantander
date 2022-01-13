package teste.desenvolvedor.backend.java.santander.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import teste.desenvolvedor.backend.java.santander.repositories.TransacaoRepository;
import teste.desenvolvedor.backend.java.santander.services.TransacaoService;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoServiceImplTest {

    @Mock
    TransacaoRepository transacaoRepository;

    TransacaoService transacaoService;

    @BeforeEach
    void setUp() {

	MockitoAnnotations.openMocks(this);
	transacaoService = new TransacaoServiceImpl(transacaoRepository);

    }
}