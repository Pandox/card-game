package br.com.pandox.cg.server.domain.battleground.playerground.field;

import br.com.pandox.cg.server.domain.cards.BasicCard;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class FieldImpl implements Field {

    List<BasicCard> cards;

    public FieldImpl() {
        cards = new ArrayList<>();
    }

    @Override public ImmutableList<BasicCard> cards() {
        return ImmutableList.<BasicCard>builder().addAll(cards).build();
    }

    @Override public void append(BasicCard card) {
        cards.add(card);
    }
}
