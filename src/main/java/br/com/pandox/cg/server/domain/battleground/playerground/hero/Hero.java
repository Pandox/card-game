package br.com.pandox.cg.server.domain.battleground.playerground.hero;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;

public interface Hero extends Destroyable, Damager {

    Integer life();

}
