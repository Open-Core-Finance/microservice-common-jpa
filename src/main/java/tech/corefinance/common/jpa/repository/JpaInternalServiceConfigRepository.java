package tech.corefinance.common.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.corefinance.common.jpa.model.InternalServiceConfig;
import tech.corefinance.common.repository.InternalServiceConfigRepository;

/**
 * JPA repository for InternalServiceConfig.
 */
@Repository
public interface JpaInternalServiceConfigRepository extends JpaRepository<InternalServiceConfig, String>,
        InternalServiceConfigRepository<InternalServiceConfig> {
}
