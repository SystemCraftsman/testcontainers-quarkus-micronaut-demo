package com.systemcraftsman.demo;

import io.micronaut.test.support.TestPropertyProvider;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.Collections;
import java.util.Map;

public abstract class AbstractKafkaTest implements TestPropertyProvider {

    static protected final KafkaContainer MY_KAFKA = new KafkaContainer(
        DockerImageName.parse("confluentinc/cp-kafka:7.5.0")
    );

    @Override
    public Map<String, String> getProperties() {
        if (!MY_KAFKA.isRunning()) {
            MY_KAFKA.start();
        }
        return Collections.singletonMap(
            "kafka.bootstrap.servers", MY_KAFKA.getBootstrapServers()
        );
    }
}