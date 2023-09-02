package com.systemcraftsman.demo.serde;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.systemcraftsman.demo.model.Signal;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class SignalDeserializer implements Deserializer<Signal> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public SignalDeserializer() {
        //Nothing to do
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        //Nothing to do
    }

    @Override
    public Signal deserialize(String s, byte[] bytes) {
        if (bytes.length == 0) {
            return null;
        }

        try {
            return objectMapper.readValue(bytes, new TypeReference<>() {});
        } catch (IOException e) {
            throw new SerializationException("Error deserializing JSON message", e);
        }

    }

    @Override
    public Signal deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}