package petclinic.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Simple JavaBean domain object representing a visit.
 */
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{

  @Column(name = "visit_date")
  @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private DateTime date;

  @NotEmpty
  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;

  /**
   * Creates a new instance of visit for the current date.
   */
  public Visit() {
    this.date = new DateTime();
  }

  public DateTime getDate() {
    return date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Pet getPet() {
    return pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }
}
