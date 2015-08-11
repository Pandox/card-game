package br.com.pandox.cg.server.domain.cards.deck;

import br.com.pandox.cg.server.domain.cards.BasicCard;

public interface Deck {

    /**
     * ,Quantidade de cartas atuais no deck
     * @return
     */
    short size();

    BasicCard draw();

}
