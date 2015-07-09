package petclinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Simple domain object representing a list of veterinarians.
 * Mostly here to be used for 'vets'
 *  {@link org.springframework.web.servlet.view.xml.MarshallingView}.
 */

@XmlRootElement
public class Vets {
  private List<Vet> vets;

  /**
   * Get vet list.
   */
  @XmlElement
  public List<Vet> getVetList() {
    if (vets == null) {
      vets = new ArrayList<>();
    }
    return vets;
  }
}
