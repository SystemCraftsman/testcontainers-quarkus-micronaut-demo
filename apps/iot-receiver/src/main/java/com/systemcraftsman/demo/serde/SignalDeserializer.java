package com.systemcraftsman.demo.serde;

import com.systemcraftsman.demo.model.Signal;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class SignalDeserializer extends ObjectMapperDeserializer<Signal> {
    public SignalDeserializer() {
        super(Signal.class);
    }
}