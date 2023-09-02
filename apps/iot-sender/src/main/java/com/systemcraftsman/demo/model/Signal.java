package com.systemcraftsman.demo.model;

import io.micronaut.serde.annotation.Serdeable;

import java.io.Serializable;
import java.util.Date;

@Serdeable
public class Signal implements Serializable {

    private Date date;
    private String temperature;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Signal{" +
                "date=" + date +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
