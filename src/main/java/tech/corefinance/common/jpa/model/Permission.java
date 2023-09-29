package tech.corefinance.common.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import tech.corefinance.common.model.AbstractPermission;

@Table(name = "permission")
@Entity
public class Permission extends AbstractPermission {
}
