package br.com.pandox.cg.server.domain.battleground;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Targetable;
import br.com.pandox.cg.server.domain.battleground.playerground.PlayerGround;
import br.com.pandox.cg.server.domain.battleground.playerground.PlayerGroundImpl;
import br.com.pandox.cg.server.domain.battleground.playerground.phase.BattlegroundPhase;
import br.com.pandox.cg.server.domain.battleground.playerground.phase.BattlegroundPhaseImpl;
import br.com.pandox.cg.server.domain.cards.BasicCard;
import br.com.pandox.cg.server.domain.cards.deck.DeckBuilder;
import br.com.pandox.cg.server.domain.player.Player;

import java.util.Set;

public class BattlegroundImpl implements Battleground {

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
    public BattlegroundPhase phase() {
        return phase;
    }

    @Override
    public BasicCard drawCard() {
        return phase.drawCard();
    }

    @Override
    public void setCard(BasicCard card) {
        phase.setCard(card);
    }

    @Override
    public void attack(BasicCard card, Targetable target) {

    }

    @Override
    public PlayerGround actual() {
        return phase.actual();
    }
}
