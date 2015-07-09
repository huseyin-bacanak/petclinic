package petclinic.service;

import org.springframework.dao.DataAccessException;
import petclinic.model.Owner;
import petclinic.model.Pet;
import petclinic.model.PetType;
import petclinic.model.Vet;
import petclinic.model.Visit;

import java.util.Collection;

/**
 * Mostly used as a facade so all controllers have a single point of entry.
 */
public interface ClinicService {

  Collection<PetType> findPetTypes() throws DataAccessException;

  Owner findOwnerById(int id) throws DataAccessException;

  Pet findPetById(int id) throws DataAccessException;

  void savePet(Pet pet) throws DataAccessException;

  void saveVisit(Visit visit) throws DataAccessException;

  Collection<Vet> findVets() throws DataAccessException;

  void saveOwner(Owner owner) throws DataAccessException;

  Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException;

}
