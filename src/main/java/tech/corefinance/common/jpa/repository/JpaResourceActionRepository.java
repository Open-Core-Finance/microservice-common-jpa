package tech.corefinance.common.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.corefinance.common.jpa.model.ResourceAction;
import tech.corefinance.common.repository.ResourceActionRepository;

/**
 * JPA repository for ResourceAction.
 */
@Repository
public interface JpaResourceActionRepository extends ResourceActionRepository<ResourceAction>,
        JpaRepository<ResourceAction, String> {
}
