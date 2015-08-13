package br.com.pandox.cg.commons;

import br.com.pandox.cg.events.Event;
import br.com.pandox.cg.events.EventPublisher;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class MockEventPublisher implements EventPublisher {

    private List<Event> event;

    public MockEventPublisher() {
        event = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return event;
    }


    @Override
    public void publish(Event event) {
        this.event.add(event);
    }
}
