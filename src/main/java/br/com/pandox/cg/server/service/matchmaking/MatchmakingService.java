package br.com.pandox.cg.server.service.matchmaking;

import br.com.pandox.cg.server.domain.matchmaking.MatchMaking;
import br.com.pandox.cg.server.domain.player.Player;

public interface MatchmakingService {

    MatchMaking enqueue(Player player);

    MatchMaking find(Long id);
}
