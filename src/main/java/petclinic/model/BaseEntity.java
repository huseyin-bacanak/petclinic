package petclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Simple JavaBean domain object with an id property.
 */
@MappedSuperclass
public class BaseEntity {
  @Id
  @GeneratedValue
  protected Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean isNew() {
    return this.id == null;
  }
}
