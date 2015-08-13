package br.com.pandox.cg.server.domain.battleground.playerground.hero;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.GameMechanics;

public class HeroImpl implements Hero {

    private Integer life;

    public HeroImpl() {
        life = GameMechanics.INITIAL_LIFE_POINTS;
    }

    @Override public int life() {
        return life;
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public void damage(Damager damager) {
        this.life -= damager.power();
    }

    @Override
    public Integer power() {
        return 0;
    }
}
