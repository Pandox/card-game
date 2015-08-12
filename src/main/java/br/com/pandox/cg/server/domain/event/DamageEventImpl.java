package br.com.pandox.cg.server.domain.event;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;

public class DamageEventImpl implements DamageEvent {

    private final Damager source;
    private final Destroyable target;
    private final Integer previousLife;
    private final Integer afterLife;

    public DamageEventImpl(Damager source, Destroyable target, Integer previousLife, Integer afterLife) {
        this.source = source;
        this.target = target;
        this.previousLife = previousLife;
        this.afterLife = afterLife;
    }

    @Override
    public Damager source() {
        return source;
    }

    @Override
    public Destroyable target() {
        return target;
    }

    @Override
    public int previousLife() {
        return previousLife;
    }

    @Override
    public int afterLife() {
        return afterLife;
    }
}
