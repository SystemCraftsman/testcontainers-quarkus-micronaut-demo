package com.systemcraftsman.demo;

import com.systemcraftsman.demo.model.Signal;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.junit.jupiter.api.*;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IotReceiverTest {

    @Inject
    @Channel("signals-out")
    Emitter<Signal> signalEmitter;

    @Test
    @Order(1)
    public void testReceive() throws InterruptedException {
        Signal signal = new Signal();
        signal.setDate(Calendar.getInstance().getTime());
        signal.setTemperature("35 C");
        signalEmitter.send(signal);

        Signal consumedSignal = SignalKeeper.getSignals().poll(5, TimeUnit.SECONDS);
        Assertions.assertEquals(signal.toString(), consumedSignal.toString());
    }
}
