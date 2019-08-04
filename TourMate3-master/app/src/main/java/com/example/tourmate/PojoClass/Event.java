package com.example.tourmate.PojoClass;

import java.io.Serializable;
import java.util.List;

public class Event implements Serializable {
    private EventDetails Details;


    public Event(EventDetails details) {
        Details = details;

    }

    public Event() {

    }

    public EventDetails getDetails() {
        return Details;
    }

    public void setDetails(EventDetails details) {
        Details = details;
    }


    @Override
    public String toString() {
        return "Event{" +
                "Details=" + Details +
                '}';
    }
}
