package com.github.lambda.playground.common;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;

/**
 * Make flyway migration happens after hibernate ddl manipulation.
 */
@Configuration
@Profile( {"test"})
public class FlywayConfig {
  /**
   * Override default flyway initializer to do nothing
   */
  @Bean
  FlywayMigrationInitializer flywayInitializer(Flyway flyway) {
    return new FlywayMigrationInitializer(flyway, (f) -> {
    });
  }

  /**
   * Create a second flyway initializer to run after jpa has created the schema
   */
  @Bean
  @DependsOn("entityManagerFactory")
  FlywayMigrationInitializer delayedFlywayInitializer(Flyway flyway) {
    return new FlywayMigrationInitializer(flyway, null);
  }
}
