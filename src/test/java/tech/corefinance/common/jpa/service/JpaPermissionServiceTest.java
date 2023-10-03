package tech.corefinance.common.jpa.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public class JpaPermissionServiceTest {

    private static final PostgreSQLContainer<?> postgresqlContainer =
            new PostgreSQLContainer<>(DockerImageName.parse("postgres:16"))
                    .withDatabaseName("coffee_shop_order_test")
                    .withUsername("testuser")
                    .withPassword("testpassword");

    @BeforeAll
    public static void setUp() {
        // Start the PostgreSQL container before running tests
        postgresqlContainer.start();
    }

    @AfterAll
    public static void tearDown() {
        // Stop the PostgreSQL container after running tests
        postgresqlContainer.stop();
    }

}
