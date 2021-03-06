package br.com.pandox.cg.server.domain.matchmaking;

import br.com.pandox.cg.server.domain.battleground.Battleground;
import br.com.pandox.cg.server.domain.player.Player;
import br.com.pandox.cg.server.domain.shared.Domain;

import java.util.Set;

public interface MatchMaking extends Domain {

    void add(Player player);

    MatchMakingImpl.Status status();

    Set<Player> players();

    Battleground battleground();
}
