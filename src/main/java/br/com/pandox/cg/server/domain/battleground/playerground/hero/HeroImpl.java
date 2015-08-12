package br.com.pandox.cg.server.domain.battleground.playerground.hero;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.GameMechanics;
import br.com.pandox.cg.server.domain.event.DamageEvent;

public class HeroImpl implements Hero {

    private Integer life;

    public HeroImpl() {
        life = GameMechanics.INITIAL_LIFE_POINTS;
    }

    @Override public Integer life() {
        return life;
    }

    @Override
    public boolean isDestroied() {
        return false;
    }

    @Override
    public DamageEvent damage(Damager damager) {
        return null;
    }

    @Override
    public Integer power() {
        return null;
    }
}
