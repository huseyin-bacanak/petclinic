package petclinic.repository;

import org.springframework.dao.DataAccessException;
import petclinic.model.Vet;

import java.util.Collection;

/**
 * Repository class for <code>Vet</code> domain objects.
 */
public interface VetRepository {

  /**
   * Retrieve all <code>Vet</code>s from the data source.
   * @return a <code>Collection</code> of <code>Vet</code>
   */
  Collection<Vet> findAll() throws DataAccessException;
}
