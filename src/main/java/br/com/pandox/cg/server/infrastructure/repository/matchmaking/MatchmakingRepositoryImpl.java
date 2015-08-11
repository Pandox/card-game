package br.com.pandox.cg.server.infrastructure.repository.matchmaking;

import br.com.pandox.cg.server.domain.matchmaking.MatchMaking;
import br.com.pandox.cg.server.domain.matchmaking.MatchMakingImpl;
import org.springframework.stereotype.Repository;

@Repository
public class MatchmakingRepositoryImpl implements MatchmakingRepository {

    private static MatchMaking matchMaking;

    @Override
    public MatchMaking next() {
        if(matchMaking == null) {
            matchMaking = new MatchMakingImpl(1l, this);
        }

        return matchMaking;
    }

    @Override
    public void persist(MatchMaking matchMaking) {
        MatchmakingRepositoryImpl.matchMaking = matchMaking;
    }
}
