package com.systemcraftsman.demo;

import com.github.javafaker.Faker;
import com.systemcraftsman.demo.model.Signal;
import io.micronaut.context.annotation.Context;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

import java.util.concurrent.TimeUnit;

@Context
public class SignalProducer {

    @Inject
    private SignalProducerClient producerClient;

    @PostConstruct
    public void produce() throws InterruptedException {
        while (true) {
            producerClient.sendSignal(createSignal());
            Thread.sleep(5000);
        }
    }

    private Signal createSignal(){
        Faker faker = new Faker();

        Signal signal = new Signal();
        signal.setDate(faker.date().past(10, TimeUnit.SECONDS));
        signal.setTemperature(faker.weather().temperatureCelsius());

        return signal;
    }
}
