package tech.corefinance.common.jpa.service;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.corefinance.common.jpa.model.Permission;
import tech.corefinance.common.jpa.model.ResourceAction;
import tech.corefinance.common.jpa.repository.JpaPermissionRepository;
import tech.corefinance.common.repository.PermissionRepository;
import tech.corefinance.common.service.PermissionService;

/**
 * JPA permission service.
 */
@Service
@Transactional
@Getter
public class JpaPermissionService implements PermissionService<Permission, ResourceAction> {

    @Autowired
    private JpaPermissionRepository permissionRepository;

    @Override
    public PermissionRepository<Permission> getRepository() {
        return permissionRepository;
    }

    /**
     * Create Permission.
     * @return New Permission object.
     */
    @Override
    public @NotNull Permission createEntityObject() {
        return new Permission();
    }

    /**
     * Create ResourceAction.
     * @param resourceType Resource type name.
     * @param action Action name.
     * @param url URL.
     * @param requestMethod Request Method.
     * @return New ResourceAction object.
     */
    @Override
    public @NotNull ResourceAction newResourceAction(String resourceType, String action, String url,
                                                     RequestMethod requestMethod) {
        return new ResourceAction(resourceType, action, url, requestMethod);
    }
}
