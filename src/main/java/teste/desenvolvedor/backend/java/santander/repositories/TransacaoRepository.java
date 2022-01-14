package teste.desenvolvedor.backend.java.santander.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teste.desenvolvedor.backend.java.santander.model.Transacao;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
}
