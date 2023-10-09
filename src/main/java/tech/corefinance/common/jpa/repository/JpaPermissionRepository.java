package tech.corefinance.common.jpa.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.corefinance.common.jpa.model.Permission;
import tech.corefinance.common.repository.PermissionRepository;

import java.util.List;
import java.util.Optional;

/**
 * JPA repository for Permission.
 */
@Repository
public interface JpaPermissionRepository extends JpaRepository<Permission, String>, PermissionRepository<Permission> {

    Optional<Permission> findFirstByRoleIdAndResourceTypeAndActionAndUrlAndRequestMethod(String roleId, String resourceType, String action, String url, RequestMethod requestMethod);

    List<Permission> findAllByRoleIdAndResourceType(String roleId, String resourceType, Sort sort);

}
