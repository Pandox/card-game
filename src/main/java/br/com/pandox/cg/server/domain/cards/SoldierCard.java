package br.com.pandox.cg.server.domain.cards;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;

public class SoldierCard implements BasicCard {

    private int lifePoints;

    public SoldierCard() {
        lifePoints = 1;
    }

    @Override public Integer power() {
        return 1;
    }

    @Override public int life() {
        return lifePoints;
    }

    @Override
    public boolean isDestroyed() {
        return life() < 1;
    }

    @Override
    public void damage(Damager damager) {
        this.lifePoints -= damager.power();
    }


    @Override public Integer runes() {
        return 1;
    }
}
