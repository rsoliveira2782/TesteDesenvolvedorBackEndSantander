package teste.desenvolvedor.backend.java.santander.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import teste.desenvolvedor.backend.java.santander.repositories.TransacaoRepository;

@ExtendWith(MockitoExtension.class)
class TransacaoServiceImplTest {

    @Mock
    TransacaoRepository transacaoRepository;

    @Autowired
    @InjectMocks
    TransacaoServiceImpl transacaoServiceImpl;

    @BeforeEach
    void setUp() {

    }
}