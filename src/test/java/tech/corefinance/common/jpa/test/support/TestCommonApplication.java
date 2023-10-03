package tech.corefinance.common.jpa.test.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"tech.corefinance.product", "tech.corefinance.common"})
@EnableJpaRepositories(basePackages = {"tech.corefinance.product.repository", "tech.corefinance.common.jpa.repository"})
@EntityScan(basePackages = {"tech.corefinance.common.jpa.model", "tech.corefinance.product.model"})
public class TestCommonApplication {
}
