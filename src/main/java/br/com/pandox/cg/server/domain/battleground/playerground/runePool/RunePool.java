package br.com.pandox.cg.server.domain.battleground.playerground.runePool;

import br.com.pandox.cg.server.domain.battleground.playerground.exception.OutOfRunes;
import br.com.pandox.cg.server.domain.cards.BasicCard;

public interface RunePool {

    /**
     * Retorna o poder de runa restante
     * @return
     */
    Integer remaining();

    /**
     * Retorna o poder total de runas atual
     * @return
     */
    Integer size();

    /**
     * Consome o poder de runa da carta informada.<br />
     * Lanca exception caso o poder da carta seja maior que as runas restantes
     * @param card
     * @throws OutOfRunes
     */
    void consume(BasicCard card) throws OutOfRunes;
}
