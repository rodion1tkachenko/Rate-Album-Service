package ru.o0000q.ratealbumservice.integration;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.o0000q.ratealbumservice.integration.annotation.IT;

//@Sql({
//    "classpath:sql/fill_database.sql"
//})
@IT
@Sql({
        "classpath:sql/fill_database.sql"
})
public abstract class IntegrationTestBase {
    private static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres");
    @BeforeAll
    static void runContainer() {
        container.start();
    }
    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
    }
}
