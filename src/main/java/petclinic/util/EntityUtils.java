package petclinic.util;

import org.springframework.orm.ObjectRetrievalFailureException;
import petclinic.model.BaseEntity;

import java.util.Collection;

/**
 * Utility method for handling entities. Separate from the BaseEntity class mainly because of
 * dependency on the ORM-associated ObjectRetrievalFailureException.
 *
 * @see petclinic.model.BaseEntity
 */
public abstract class EntityUtils {

  /**
   * Get Id.
   */
  public static <T extends BaseEntity> T getById(Collection<T> entities, Class<T> entityClass,
                       int entityId)  throws ObjectRetrievalFailureException {
    for (T entity: entities) {
      if (entity.getId() == entityId && entityClass.isInstance(entity)) {
        return entity;
      }
    }
    throw new ObjectRetrievalFailureException(entityClass, entityId);
  }
}
