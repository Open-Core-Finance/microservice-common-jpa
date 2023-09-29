package tech.corefinance.common.jpa.service;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.corefinance.common.jpa.model.InternalServiceConfig;
import tech.corefinance.common.jpa.model.Permission;
import tech.corefinance.common.jpa.model.ResourceAction;
import tech.corefinance.common.service.AbstractPermissionService;

@Service
@Transactional
@Getter
public class JpaPermissionService extends AbstractPermissionService<Permission, InternalServiceConfig, ResourceAction> {

    @Override
    public @NotNull Permission createEntityObject() {
        return new Permission();
    }

    @Override
    public @NotNull ResourceAction newResourceAction(String resourceType, String action, String url,
                                                     RequestMethod requestMethod) {
        return new ResourceAction(resourceType, action, url, requestMethod);
    }
}
