package petclinic.repository;

import org.springframework.dao.DataAccessException;
import petclinic.model.Owner;

import java.util.Collection;

/**
 * Repository class for <code>Owner</code> domain objects. All method names are compliant with
 * Spring Data naming conventions so this interface can easily be extended for Spring Data.
 */
public interface OwnerRepository {

  /**
   * Retrieve <code>Owner</code>s from the data store by last name, returning all owners whose
   * last name <i>starts</i> with the given name.
   *
   * @param lastName Value to search for.
   * @return <code>Collection</code> of matching <code>Owner</code>s (or an empty
   * <code>Collection</code>) if none found.
   */
  Collection<Owner> findByLastName(String lastName) throws DataAccessException;

  /**
   * Retrieve an <code>Owner</code> from the data store by id.
   *
   * @param id the id to search for
   * @return the <code>Owner</code> if found
   *
   * @throws org.springframework.dao.DataRetrievalFailureException
   *          if not found.
   */
  Owner findById(int id) throws DataAccessException;

  /**
   * Save an <code>Owner</code> to the data store, either inserting or updating it.
   *
   * @param owner the <code>Owner</code> to save
   * @see petclinic.model.BaseEntity#isNew()
   */
  void save(Owner owner) throws DataAccessException;

}
