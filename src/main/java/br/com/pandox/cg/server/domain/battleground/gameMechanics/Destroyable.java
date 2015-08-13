package br.com.pandox.cg.server.domain.battleground.gameMechanics;

import br.com.pandox.cg.server.domain.event.DamageData;

/**
 * Qualquer objeto que possa ser destruido por outro
 */
public interface Destroyable {

    Integer life();

    boolean isDestroyed();

    void damage(Damager power);
}
