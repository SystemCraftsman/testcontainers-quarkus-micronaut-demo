package com.systemcraftsman.demo;

import com.systemcraftsman.demo.model.Signal;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface SignalProducerClient {

    @Topic("signals")
    void sendSignal(Signal signal);
}