package br.com.pandox.cg.server.domain.battleground.playerground;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.GameMechanics;
import br.com.pandox.cg.server.domain.battleground.playerground.exception.AlreadyDrawCard;
import br.com.pandox.cg.server.domain.battleground.playerground.field.Field;
import br.com.pandox.cg.server.domain.battleground.playerground.field.FieldImpl;
import br.com.pandox.cg.server.domain.battleground.playerground.hero.Hero;
import br.com.pandox.cg.server.domain.battleground.playerground.playerHand.PlayerHand;
import br.com.pandox.cg.server.domain.battleground.playerground.playerHand.PlayerHandImpl;
import br.com.pandox.cg.server.domain.battleground.playerground.runeManager.RunePool;
import br.com.pandox.cg.server.domain.battleground.playerground.runeManager.RunePoolImpl;
import br.com.pandox.cg.server.domain.cards.BasicCard;
import br.com.pandox.cg.server.domain.cards.deck.Deck;
import br.com.pandox.cg.server.domain.player.Player;

public class PlayerGroundImpl implements PlayerGround {

    private final Player player;
    private final Deck deck;
    private final PlayerHand playerHand;
    private final Field field;
    private final RunePool runePool;

    boolean drawCard;

    public PlayerGroundImpl(Player player, Deck deck) {
        this.player = player;
        this.deck = deck;
        this.playerHand = new PlayerHandImpl();
        this.field = new FieldImpl();
        this.runePool = new RunePoolImpl();

        initializePlayerHand();
    }

    private void initializePlayerHand() {
        while(playerHand.cards().size() < GameMechanics.FIRST_HAND_SIZE){
            playerHand.append(this.deck.draw());
        }
    }

    @Override public Deck deck() {
        return deck;
    }

    @Override public PlayerHand hand() {
        return playerHand;
    }

    @Override public BasicCard drawCard() {
        if(drawCard) {
            throw new AlreadyDrawCard();
        }

        BasicCard card = deck.draw();
        playerHand.append(card);
        drawCard = true;
        return card;
    }

    @Override public void setCard(BasicCard card) {
        runePool.consume(card);

        hand().remove(card);
        field().append(card);

    }

    @Override public Field field() {
        return field;
    }

    @Override public int runes() {
        return runePool.remaining();
    }
}
