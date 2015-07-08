package petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Can be Cat, Dog, Hamster, etc.
 */
@Entity
@Table(name = "types")
public class PetType extends NamedEntity{

}
