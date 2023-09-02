package com.systemcraftsman.demo;

import com.systemcraftsman.demo.model.Signal;
import jakarta.inject.Singleton;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@Singleton
public class SignalKeeper {
    private static BlockingQueue<Signal> signals = new LinkedBlockingDeque<>();

    public static BlockingQueue<Signal> getSignals() {
        return signals;
    }
}
