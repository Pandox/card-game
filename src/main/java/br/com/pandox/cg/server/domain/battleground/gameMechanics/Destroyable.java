package br.com.pandox.cg.server.domain.battleground.gameMechanics;

import br.com.pandox.cg.server.domain.cards.BasicCard;
import br.com.pandox.cg.server.domain.event.DamageEvent;

/**
 * Qualquer objeto que possa ser destruido por outro
 */
public interface Destroyable {

    Integer life();

    boolean isDestroied();

    DamageEvent damage(Damager damager);
}
