package tech.corefinance.common.jpa.model;

import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.corefinance.common.model.AbstractResourceAction;

@Table(name = "resource_action")
public class ResourceAction extends AbstractResourceAction {
    public ResourceAction(String resourceType, String action, String url, RequestMethod requestMethod) {
        super(resourceType, action, url, requestMethod);
    }
}
