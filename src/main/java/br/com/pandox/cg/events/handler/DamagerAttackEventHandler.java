package br.com.pandox.cg.events.handler;

import br.com.pandox.cg.events.Event;
import br.com.pandox.cg.events.EventPublisher;
import br.com.pandox.cg.events.event.AttackEvent;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;
import br.com.pandox.cg.server.domain.data.DamageData;
import br.com.pandox.cg.server.domain.data.DamageDataImpl;
import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DamagerAttackEventHandler {

    public DamagerAttackEventHandler(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    private EventPublisher eventPublisher;

    @Subscribe
    public void listen(AttackEvent event){

        System.out.println("event = " + event);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Damager source = event.damager();
        Destroyable destroyable = event.target();

        DamageData damageData = processDamage(source, destroyable);
//        eventPublisher.publish(new DamageDataEvent());


//        ArrayList<DamageData> data = Lists.newArrayList(damageData);
//        if(isCounterAttack(source, destroyable)){
//            DamageData damageData2 = processDamage((Damager) destroyable, (Destroyable) source);
//            data.add(damageData2);
//        }
    }

    public class DamageDataEvent implements Event {

    }


    private boolean isCounterAttack(Damager source, Destroyable destroyable) {
        return source instanceof Destroyable && destroyable instanceof Damager;
    }

    private DamageData processDamage(Damager source, Destroyable destroyable) {
        int previousLife = destroyable.life();
        destroyable.damage(source);
        return new DamageDataImpl(source, destroyable, previousLife, destroyable.life());
    }
}
