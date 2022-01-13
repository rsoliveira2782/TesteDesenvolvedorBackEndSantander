package teste.desenvolvedor.backend.java.santander.repositories;

import org.springframework.data.repository.CrudRepository;
import teste.desenvolvedor.backend.java.santander.model.Cliente;

public interface ClienteRepository  extends CrudRepository<Cliente, Long> {
}
