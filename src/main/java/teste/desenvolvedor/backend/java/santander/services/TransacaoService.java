package teste.desenvolvedor.backend.java.santander.services;

import org.springframework.stereotype.Service;
import teste.desenvolvedor.backend.java.santander.model.Transacao;

@Service
public interface TransacaoService extends CrudService<Transacao, Long> {
}
