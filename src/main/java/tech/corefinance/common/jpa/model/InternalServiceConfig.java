package tech.corefinance.common.jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import tech.corefinance.common.model.AbstractInternalServiceConfig;

import java.time.ZonedDateTime;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    public String getId() {
        return super.getId();
    }

    @Override
    @NotNull
    public String getServiceName() {
        return super.getServiceName();
    }

    @Override
    @NotNull
    public String getApiKey() {
        return super.getApiKey();
    }

    @Override
    @LastModifiedDate
    public ZonedDateTime getLastModifiedDate() {
        return super.getLastModifiedDate();
    }

    @Override
    @CreatedDate
    public ZonedDateTime getCreatedDate() {
        return super.getCreatedDate();
    }

    @Override
    public boolean isActivated() {
        return super.isActivated();
    }
}
