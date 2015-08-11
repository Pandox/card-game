package br.com.pandox.cg.server.domain.cards.deck;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.GameMechanics;
import br.com.pandox.cg.server.domain.cards.BasicCard;
import br.com.pandox.cg.server.domain.cards.SoldierCard;

import java.util.ArrayList;
import java.util.List;

public class DeckBuilder {


    public static Deck instantiate(){
        int size = GameMechanics.DECK_SIZE;
        List<BasicCard> cards = new ArrayList<>();
        while(size > 0){
            cards.add(new SoldierCard());
            size--;
        }
        return new DeckImpl(cards);
    }
}
