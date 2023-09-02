package com.systemcraftsman.demo;

import com.systemcraftsman.demo.model.Signal;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient(id = "signal-producer-client", acks = KafkaClient.Acknowledge.ALL)
public interface SignalProducerClient {

    @Topic("signals")
    void sendSignal(Signal signal);
}