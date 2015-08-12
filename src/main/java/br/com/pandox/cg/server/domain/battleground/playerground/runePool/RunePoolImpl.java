package br.com.pandox.cg.server.domain.battleground.playerground.runePool;

import br.com.pandox.cg.server.domain.battleground.playerground.exception.OutOfRunes;
import br.com.pandox.cg.server.domain.cards.BasicCard;

public class RunePoolImpl implements RunePool {

    private Integer runes;
    private Integer consumed;

    public RunePoolImpl() {
        runes = 1;
        consumed = 0;
    }

    @Override public Integer remaining() {
        return (runes - consumed);
    }

    @Override public Integer size() {
        return runes;
    }

    @Override public void consume(BasicCard card) throws OutOfRunes {
        if(remaining() < card.runes()) {
            throw new OutOfRunes();
        }
        consumed += card.runes();
    }
}
