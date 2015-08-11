package br.com.pandox.cg.server.domain.battleground.playerground.playerHand;

import br.com.pandox.cg.server.domain.cards.BasicCard;
import com.google.common.collect.ImmutableList;

public interface PlayerHand {

    ImmutableList<BasicCard> cards();

    void append(BasicCard card);

    void remove(BasicCard card);
}
