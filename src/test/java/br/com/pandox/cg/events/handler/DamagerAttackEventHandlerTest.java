package br.com.pandox.cg.events.handler;

import br.com.pandox.cg.commons.MockEventPublisher;
import br.com.pandox.cg.events.Event;
import br.com.pandox.cg.events.EventPublisher;
import br.com.pandox.cg.events.event.AttackEvent;
import br.com.pandox.cg.server.domain.battleground.playerground.hero.HeroImpl;
import br.com.pandox.cg.server.domain.cards.SoldierCard;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DamagerAttackEventHandlerTest {

    @InjectMocks
    private DamagerAttackEventHandler handler;

    private MockEventPublisher eventPublisher;

    @BeforeMethod
    public void init() {
        eventPublisher = new MockEventPublisher();
        handler = new DamagerAttackEventHandler(eventPublisher);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void generate_damageData_when_normal_attack() {
        handler.listen(new AttackEvent(new SoldierCard(), new HeroImpl()));

        List<Event> events = eventPublisher.getEvents();
        assertTrue(events.get(0) instanceof DamagerAttackEventHandler.DamageDataEvent);
    }

}