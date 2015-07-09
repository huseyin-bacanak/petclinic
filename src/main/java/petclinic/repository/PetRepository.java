package petclinic.repository;

import org.springframework.dao.DataAccessException;
import petclinic.model.Pet;
import petclinic.model.PetType;

import java.util.List;

/**
 * Repository class for <code>Pet</code> domain objects. All method names are compliant with
 * Spring Data naming conventions so this interface can easily be extended for Spring Data.
 */
public interface PetRepository {

  /**
   * Retrieve all <code>PetType</code> from the data source.
   *
   * @return a <code>Collection</code> of <code>PetType</code>s
   */
  List<PetType> findPetTypes() throws DataAccessException;

  /**
   * Retrieve a <code>Pet</code> from the data store by id.
   * @param id the id to search for
   * @return the <code>Pet</code> if found.
   */
  Pet findById(int id) throws DataAccessException;

  /**
   * Save a <code>Pet</code> to the data store, either by inserting it or updating it.
   * @param pet the <code>Pet</code> to save
   */
  void save(Pet pet) throws DataAccessException;
}
