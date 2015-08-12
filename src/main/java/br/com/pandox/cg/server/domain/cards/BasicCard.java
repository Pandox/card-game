package br.com.pandox.cg.server.domain.cards;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;

public interface BasicCard extends Damager, Destroyable {

    Integer power();

    Integer life();

    Integer runes();
}
