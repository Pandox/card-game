package br.com.pandox.cg.server.service.matchmaking;

import br.com.pandox.cg.server.domain.matchmaking.MatchMaking;
import br.com.pandox.cg.server.domain.player.Player;
import br.com.pandox.cg.server.infrastructure.repository.matchmaking.MatchmakingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchmakingServiceImpl implements MatchmakingService {

    @Autowired
    private MatchmakingRepository repository;

    @Override
    public MatchMaking enqueue(Player player) {
        MatchMaking matchMaking = repository.next();
        matchMaking.add(player);

        return matchMaking;
    }

    @Override
    public MatchMaking find(Long id) {
        return repository.next();
    }
}
