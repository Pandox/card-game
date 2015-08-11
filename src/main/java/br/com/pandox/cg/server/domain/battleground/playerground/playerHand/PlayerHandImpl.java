package br.com.pandox.cg.server.domain.battleground.playerground.playerHand;

import br.com.pandox.cg.server.domain.cards.BasicCard;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class PlayerHandImpl implements PlayerHand {

    List<BasicCard> cards;

    public PlayerHandImpl() {
        cards = new ArrayList<>();
    }

    @Override public ImmutableList<BasicCard> cards() {
        return ImmutableList.<BasicCard>builder().addAll(cards).build();
    }

    @Override public void append(BasicCard card) {
        cards.add(card);
    }

    @Override public void remove(BasicCard card) {
        cards.remove(card);
    }
}
