package teste.desenvolvedor.backend.java.santander.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teste.desenvolvedor.backend.java.santander.model.Cliente;

@Repository
public interface ClienteRepository  extends CrudRepository<Cliente, Long> {
}
