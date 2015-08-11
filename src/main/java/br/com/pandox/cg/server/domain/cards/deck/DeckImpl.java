package br.com.pandox.cg.server.domain.cards.deck;

import br.com.pandox.cg.server.domain.cards.BasicCard;

import java.util.List;

public class DeckImpl implements Deck {

    private List<BasicCard> cards;

    public DeckImpl(List<BasicCard> cards) {
        this.cards = cards;
    }

    @Override
    public short size() {
        return (short) cards.size();
    }

    @Override
    public BasicCard draw() {
        return cards.remove(0);
    }
}
