package com.ctw.workstation.testconfig;

import io.quarkus.test.junit.QuarkusTestProfile;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

public class CommonProfile implements QuarkusTestProfile {

    @Override
    public List<TestResourceEntry> testResources() {
        return List.of(
                new TestResourceEntry(TestConfig.class),
                new TestResourceEntry(WireMockResourceConfig.class)
        );
    }
}
