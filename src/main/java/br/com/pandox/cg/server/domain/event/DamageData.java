package br.com.pandox.cg.server.domain.event;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;

public interface DamageData {

    Damager source();

    Destroyable target();

    int previousLife();

    int afterLife();
}
