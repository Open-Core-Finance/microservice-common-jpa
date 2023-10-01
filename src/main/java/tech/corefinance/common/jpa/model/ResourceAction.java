package tech.corefinance.common.jpa.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.corefinance.common.model.AbstractResourceAction;

/**
 * Resource action config for permission module.
 */
@Table(name = "resource_action")
public class ResourceAction extends AbstractResourceAction {
    /**
     * Constructor.
     * @param resourceType Resource type name.
     * @param action Action name.
     * @param url URL.
     * @param requestMethod Request Method.
     */
    public ResourceAction(String resourceType, String action, String url, RequestMethod requestMethod) {
        super(resourceType, action, url, requestMethod);
    }

    @Override
    @Id
    public String getId() {
        return super.getId();
    }
}
