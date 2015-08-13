package br.com.pandox.cg.server.domain.battleground.gameMechanics;

/**
 * Qualquer objeto que possa ser destruido por outro
 */
public interface Destroyable {

    int life();

    boolean isDestroyed();

    void damage(Damager power);
}
