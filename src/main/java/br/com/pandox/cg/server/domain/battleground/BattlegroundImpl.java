package br.com.pandox.cg.server.domain.battleground;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;
import br.com.pandox.cg.server.domain.battleground.playerground.PlayerGround;
import br.com.pandox.cg.server.domain.battleground.playerground.PlayerGroundImpl;
import br.com.pandox.cg.server.domain.battleground.playerground.phase.BattlegroundPhase;
import br.com.pandox.cg.server.domain.battleground.playerground.phase.BattlegroundPhaseImpl;
import br.com.pandox.cg.server.domain.cards.BasicCard;
import br.com.pandox.cg.server.domain.cards.deck.DeckBuilder;
import br.com.pandox.cg.server.domain.player.Player;
import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.EventBus;

import java.util.Set;

public class BattlegroundImpl implements Battleground, Battleground.Round, Battleground.Round.Turn {

    private final BattlegroundPhase phase;
    private PlayerGround red;
    private PlayerGround blue;

    private final long id;

    public BattlegroundImpl(Long id, Set<Player> players) {
        this.id = id;
        Player first = players.iterator().next();
        Player second = players.iterator().next();

        //shuffle cards
        red = new PlayerGroundImpl(first, DeckBuilder.instantiate());
        blue = new PlayerGroundImpl(second, DeckBuilder.instantiate());

        this.phase = new BattlegroundPhaseImpl(this);
    }

    @Override
    public Long identifier() {
        return id;
    }

    @Override public PlayerGround red() {
        return red;
    }

    @Override public PlayerGround blue() {
        return blue;
    }

    @Override public Status status() {
        return Status.STARTED;
    }

    @Override public short firstPlayer() {
        return 0;
    }

    @Override
    public BasicCard drawCard() {
        return player().drawCard();
    }

    @Override
    public void setCard(BasicCard card) {
        player().setCard(card);
    }

    @Override
    public void attack(BasicCard card, Destroyable target, EventBus eventBus) {
        ImmutableList<BasicCard> fieldCards = round().turn().player().field().cards();
        for (BasicCard fieldCard : fieldCards) {
            if(card.equals(fieldCard)) {
                eventBus.post(new AttackEvent());
            }
        }
    }

    public class AttackEvent {

    }

    @Override
    public PlayerGround player() {
        return phase.actual();
    }

    @Override
    public Round round() {
        return this;
    }

    @Override
    public PlayerGround enemy() {
        return phase.enemy();
    }

    @Override
    public Turn turn() {
        return this;
    }
}
