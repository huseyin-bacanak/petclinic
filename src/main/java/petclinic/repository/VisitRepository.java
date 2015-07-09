package petclinic.repository;

import org.springframework.dao.DataAccessException;
import petclinic.model.Visit;

import java.util.List;

/**
 * Repository class for <code>Visit</code> domain objects.
 */
public interface VisitRepository {

  /**
   * Save a <code>Visit</code> to the data store.
   */
  void save(Visit visit) throws DataAccessException;

  List<Visit> findPetById(Integer petId);

}
