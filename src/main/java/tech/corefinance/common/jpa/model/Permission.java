package tech.corefinance.common.jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import tech.corefinance.common.enums.AccessControl;
import tech.corefinance.common.model.AbstractPermission;

/**
 * Permission record for permission module.
 */
@Table(name = "permission")
@Entity
public class Permission extends AbstractPermission {
    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String getId() {
        return super.getId();
    }

    @Override
    @NotNull
    public String getRoleId() {
        return super.getRoleId();
    }

    @Override
    @NotNull
    public String getResourceType() {
        return super.getResourceType();
    }

    @Override
    @NotNull
    public String getAction() {
        return super.getAction();
    }

    @Override
    @NotNull
    public AccessControl getControl() {
        return super.getControl();
    }

}
