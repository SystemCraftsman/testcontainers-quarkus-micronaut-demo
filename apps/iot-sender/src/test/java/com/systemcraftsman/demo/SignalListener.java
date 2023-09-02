package com.systemcraftsman.demo;

import com.systemcraftsman.demo.model.Signal;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;


@KafkaListener(offsetReset = OffsetReset.EARLIEST, groupId = "signals")
public class SignalListener {

    @Topic("signals")
    public void receive(Signal signal) {
        SignalKeeper.getSignals().add(signal);
    }

}
