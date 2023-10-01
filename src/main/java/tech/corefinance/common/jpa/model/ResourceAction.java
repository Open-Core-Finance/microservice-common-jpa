package tech.corefinance.common.jpa.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.corefinance.common.model.AbstractResourceAction;

/**
 * Resource action config for permission module.
 */
@Table(name = "resource_action")
@Entity
@NoArgsConstructor
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
    @GeneratedValue(strategy = GenerationType.UUID)
    public String getId() {
        return super.getId();
    }

    @Override
    public String getResourceType() {
        return super.getResourceType();
    }

    @Override
    public String getAction() {
        return super.getAction();
    }

    @Override
    public String getUrl() {
        return super.getUrl();
    }

    @Override
    public RequestMethod getRequestMethod() {
        return super.getRequestMethod();
    }
}
