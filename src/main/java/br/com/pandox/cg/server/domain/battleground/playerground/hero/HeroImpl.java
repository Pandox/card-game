package br.com.pandox.cg.server.domain.battleground.playerground.hero;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.GameMechanics;

public class HeroImpl implements Hero {

    private Integer life;

    public HeroImpl() {
        life = GameMechanics.INITIAL_LIFE_POINTS;
    }

    @Override public Integer life() {
        return life;
    }
}