package com.systemcraftsman.demo;

import com.systemcraftsman.demo.model.Signal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class SignalConsumer {

    @Incoming("signals")
    public void consume(Signal signal) {
        SignalKeeper.getSignals().add(signal);
    }

}
