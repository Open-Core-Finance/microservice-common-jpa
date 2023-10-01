package tech.corefinance.common.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.corefinance.common.model.AbstractInternalServiceConfig;

/**
 * Internal API config for permission module.
 */
@Data
@Table(name = "internal_service_config")
@Entity
@EqualsAndHashCode(callSuper = true)
public class InternalServiceConfig extends AbstractInternalServiceConfig {

    @Override
    @Id
    public String getId() {
        return super.getId();
    }
}
