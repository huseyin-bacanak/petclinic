package petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import petclinic.model.Owner;
import petclinic.model.Pet;
import petclinic.model.PetType;
import petclinic.model.Vet;
import petclinic.model.Visit;
import petclinic.repository.OwnerRepository;
import petclinic.repository.PetRepository;
import petclinic.repository.VetRepository;
import petclinic.repository.VisitRepository;

import java.util.Collection;

/**
 * Mostly used as a facade for all PetClinic controllers.
 * Also placeholder for @Transactional and @Cachable annotations.
 */
@Service
public class ClinicServiceImpl implements ClinicService {

  private PetRepository petRepository;
  private VetRepository vetRepository;
  private OwnerRepository ownerRepository;
  private VisitRepository visitRepository;

  /**
   * Initialize repositories.
   */
  @Autowired
  public ClinicServiceImpl(PetRepository petRepository,
                           VetRepository vetRepository,
                           OwnerRepository ownerRepository,
                           VisitRepository visitRepository) {
    this.petRepository = petRepository;
    this.vetRepository = vetRepository;
    this.ownerRepository = ownerRepository;
    this.visitRepository = visitRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<PetType> findPetTypes() throws DataAccessException {
    return petRepository.findPetTypes();
  }

  @Override
  @Transactional(readOnly = true)
  public Owner findOwnerById(int id) throws DataAccessException {
    return ownerRepository.findById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public Pet findPetById(int id) throws DataAccessException {
    return petRepository.findById(id);
  }

  @Override
  public void savePet(Pet pet) throws DataAccessException {
    petRepository.save(pet);
  }

  @Override
  public void saveVisit(Visit visit) throws DataAccessException {
    visitRepository.save(visit);
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(value = "vets")
  public Collection<Vet> findVets() throws DataAccessException {
    return vetRepository.findAll();
  }

  @Override
  @Transactional
  public void saveOwner(Owner owner) throws DataAccessException {
    ownerRepository.save(owner);
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException {
    return ownerRepository.findByLastName(lastName);
  }
}
