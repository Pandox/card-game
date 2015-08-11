package br.com.pandox.cg.server.infrastructure.repository;

import br.com.pandox.cg.server.domain.MatchMaking;

public interface MatchmakingRepository {

    /**
     * Retrieve the next matchmaking from WAITING status
     * @return
     */
    MatchMaking next();

    void persist(MatchMaking matchMaking);
}
