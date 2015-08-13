package br.com.pandox.cg.server.domain.cards;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;
import br.com.pandox.cg.server.domain.event.DamageEvent;
import br.com.pandox.cg.server.domain.event.DamageEventImpl;

public class SoldierCard implements BasicCard {

    private int lifePoints;

    public SoldierCard() {
        lifePoints = 1;
    }

    @Override public Integer power() {
        return 1;
    }

    @Override public Integer life() {
        return lifePoints;
    }

    @Override
    public boolean isDestroyed() {
        return life() < 1;
    }

    @Override
    public DamageEvent damage(Damager damager) {
        int previousLife = this.lifePoints;
        this.lifePoints -= damager.power();
        return new DamageEventImpl(damager, this, previousLife, lifePoints);
    }

    @Override public Integer runes() {
        return 1;
    }
}
