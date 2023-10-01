package tech.corefinance.common.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import tech.corefinance.common.model.AbstractPermission;

/**
 * Permission record for permission module.
 */
@Table(name = "permission")
@Entity
public class Permission extends AbstractPermission {
    @Override
    @Id
    public String getId() {
        return super.getId();
    }
}
