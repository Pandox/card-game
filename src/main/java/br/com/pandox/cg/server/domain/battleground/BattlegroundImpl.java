package br.com.pandox.cg.server.domain.battleground;

import br.com.pandox.cg.server.domain.player.Player;

import java.util.Set;

public class BattlegroundImpl implements Battleground {

    private Player red;
    private Player blue;

    private final long id;

    public BattlegroundImpl(Long id, Set<Player> players) {
        this.id = id;
        Player first = players.iterator().next();
        Player second = players.iterator().next();

        red = first;
        blue = second;
    }

    @Override
    public Long identifier() {
        return id;
    }
}
