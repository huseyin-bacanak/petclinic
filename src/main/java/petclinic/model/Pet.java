package petclinic.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Simple business object representing pet.
 */

@Entity
@Table(name = "pets")
public class Pet extends NamedEntity{
  @Column(name = "birth_date")
  @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private DateTime birthDate;

  @ManyToOne
  @JoinColumn(name = "type_id")
  private PetType type;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
  private Set<Visit> visits;

  public DateTime getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(DateTime birthDate) {
    this.birthDate = birthDate;
  }

  public PetType getType() {
    return type;
  }

  public void setType(PetType type) {
    this.type = type;
  }

  protected Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  protected void setVisitsInternal(Set<Visit> visits) {
    this.visits = visits;
  }

  protected Set<Visit> getVisitsInternal() {
    if (this.visits == null) {
      this.visits = new HashSet<>();
    }
    return this.visits;
  }

  /**
   * Get all visits.
   */
  public List<Visit> getVisits() {
    List<Visit> sortedVisits = new ArrayList<>(getVisitsInternal());
    PropertyComparator.sort(sortedVisits, new MutableSortDefinition("date", false, false));
    return Collections.unmodifiableList(sortedVisits);
  }

  /**
   * Add new visit.
   */
  public void addVisit(Visit visit) {
    getVisitsInternal().add(visit);
    visit.setPet(this);
  }
}
