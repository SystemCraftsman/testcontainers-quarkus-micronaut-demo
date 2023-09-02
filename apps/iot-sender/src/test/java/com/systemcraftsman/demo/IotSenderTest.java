package com.systemcraftsman.demo;

import com.systemcraftsman.demo.model.Signal;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

import jakarta.inject.Inject;
import org.junit.jupiter.api.*;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

// TODO: Implement the test to verify the IoT signal sender works
@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IotSenderTest extends AbstractKafkaTest {

    @Inject
    private SignalProducerClient producerClient;

    @Inject
    public SignalListener signalListener;

    @Test
    public void testSend() throws InterruptedException {
        Signal signal = new Signal();
        signal.setDate(Calendar.getInstance().getTime());
        signal.setTemperature("35 C");
        producerClient.sendSignal(signal);

        Signal consumedSignal = SignalKeeper.getSignals().poll(5, TimeUnit.SECONDS);
        Assertions.assertEquals(signal.toString(), consumedSignal.toString());
    }

}
