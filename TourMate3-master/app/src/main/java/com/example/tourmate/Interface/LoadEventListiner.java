package com.example.tourmate.Interface;

import com.example.tourmate.PojoClass.Event;

import java.util.List;

public interface LoadEventListiner {
    void onComplete(List<Event> eventList);
    void onError(String log);
}
