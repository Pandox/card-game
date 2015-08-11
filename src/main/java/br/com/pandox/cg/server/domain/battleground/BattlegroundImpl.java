package br.com.pandox.cg.server.domain.battleground;

import br.com.pandox.cg.server.domain.battleground.playerground.PlayerGround;
import br.com.pandox.cg.server.domain.battleground.playerground.PlayerGroundImpl;
import br.com.pandox.cg.server.domain.cards.deck.DeckBuilder;
import br.com.pandox.cg.server.domain.player.Player;

import java.util.Set;

public class BattlegroundImpl implements Battleground {

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
}
