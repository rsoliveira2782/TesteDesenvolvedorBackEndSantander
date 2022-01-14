package teste.desenvolvedor.backend.java.santander.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teste.desenvolvedor.backend.java.santander.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
