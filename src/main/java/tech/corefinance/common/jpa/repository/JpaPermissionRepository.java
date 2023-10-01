package tech.corefinance.common.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    /**
     * Search by SQL query.
     */
    String searchByQuery = """
        From Permission where lower(roleId) like lower(:search) or lower(resourceType) like lower(:search)
        or lower(url) like lower(:search) or lower(action) like lower(:search) or lower(control) like lower(:search)
        or lower(requestMethod) like lower(:search)
    """;

    /**
     * Search Permission by text.
     * @param searchText Search text.
     * @param pageable Page info
     * @return List Permissions matched search info.
     */
    @Query(searchByQuery)
    Page<Permission> searchBy(@Param("search") String searchText, Pageable pageable);

}
