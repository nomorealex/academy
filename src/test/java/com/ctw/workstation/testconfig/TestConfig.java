package com.ctw.workstation.testconfig;

import io.quarkus.logging.Log;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Map;

public class TestConfig implements QuarkusTestResourceLifecycleManager {

    PostgreSQLContainer postgres;

    @Override
    public Map<String, String> start() {

        postgres = new PostgreSQLContainer("postgres")
                .withDatabaseName("integration-tests-db");

        postgres.start();
        String str = postgres.getJdbcUrl();
        String user = postgres.getUsername();
        String pass = postgres.getPassword();



        Log.infov("About to start", "TestConfig.start");
        return Map.of("quarkus.datasource.username",user,
                "quarkus.datasource.password",pass,
                "quarkus.datasource.jdbc.url",str);
        //return Map.of("%test.quarkus.log.console.json","false");
        //return Map.of("quarkus.log.console.json","false");
    }

    @Override
    public void stop() {
        postgres.stop();
        Log.infov("About to stop", "TestConfig.stop");
    }
}
