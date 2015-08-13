package br.com.pandox.cg.server.domain.damageProcessor;

import com.google.common.eventbus.EventBus;

public class NullEventBus extends EventBus {

    private Object event;

    @Override
    public void post(Object obj){
        this.event = obj;
    }

    public Object getEvent() {
        return event;
    }
}
