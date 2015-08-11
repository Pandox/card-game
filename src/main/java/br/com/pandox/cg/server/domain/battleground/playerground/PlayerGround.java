package br.com.pandox.cg.server.domain.battleground.playerground;

import br.com.pandox.cg.server.domain.battleground.playerground.field.Field;
import br.com.pandox.cg.server.domain.battleground.playerground.playerHand.PlayerHand;
import br.com.pandox.cg.server.domain.cards.BasicCard;
import br.com.pandox.cg.server.domain.cards.deck.Deck;

public interface PlayerGround {

//    Hero hero();

    Deck deck();

    PlayerHand hand();

    BasicCard drawCard();

    void setCard(BasicCard card);

    Field field();

    int runes();
}
