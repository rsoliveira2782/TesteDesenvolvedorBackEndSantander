package teste.desenvolvedor.backend.java.santander.repositories;

import org.springframework.data.repository.CrudRepository;
import teste.desenvolvedor.backend.java.santander.model.Transacao;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
}
