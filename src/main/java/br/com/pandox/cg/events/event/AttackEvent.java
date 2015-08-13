package br.com.pandox.cg.events.event;

import br.com.pandox.cg.events.Event;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;

public class AttackEvent implements Event {

    private final Damager damager;
    private final Destroyable target;

    public Destroyable target() {
        return target;
    }

    public Damager damager() {
        return damager;
    }

    public AttackEvent(Damager damager, Destroyable target) {
        this.damager = damager;
        this.target = target;
    }
}