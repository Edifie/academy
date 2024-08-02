package com.ctw.workstation;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Map;

public class DatabaseTestResource implements QuarkusTestResourceLifecycleManager {

    PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>("postgres:latest");

    @Override
    public Map<String, String> start() {
        postgreSQLContainer.withUsername("postgres").withPassword("postgres").withDatabaseName("fs_academy").start();
        return Map.of("quarkus.datasource.username", postgreSQLContainer.getUsername(), "quarkus.datasource.password", postgreSQLContainer.getPassword(), "quarkus.datasource.jdbc.url", postgreSQLContainer.getJdbcUrl());
    }


    @Override
    public void stop() {

    }


}
