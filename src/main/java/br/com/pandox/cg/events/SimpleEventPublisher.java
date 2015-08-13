package br.com.pandox.cg.events;

import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleEventPublisher implements EventPublisher {

    @Autowired
    private EventBus eventBus;


    @Override
    public void publish(Event event) {
        eventBus.post(event);
    }
}
