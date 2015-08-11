package br.com.pandox.cg.server.domain;

import br.com.pandox.cg.server.domain.player.Player;
import br.com.pandox.cg.server.infrastructure.repository.MatchmakingRepository;

import java.util.HashSet;
import java.util.Set;

public class MatchMakingImpl implements MatchMaking {

    private Status status;
    private Long identifier;
    private MatchmakingRepository matchmakingRepository;
    private Set<Player> players;

    public enum Status {
        MATCHED, WAITING
    }

    public MatchMakingImpl(Long identifier, MatchmakingRepository matchmakingRepository) {
        this.identifier = identifier;
        this.matchmakingRepository = matchmakingRepository;
        this.status = Status.WAITING;
        this.players = new HashSet<>();
    }

    @Override
    public Long identifier() {
        return identifier;
    }

    @Override
    public void add(Player player) {
        this.players.add(player);
        if(players.size() == 2) {
            status = Status.MATCHED;
        }
        matchmakingRepository.persist(this);
    }

    @Override
    public Status status() {
        return status;
    }

    @Override
    public Set<Player> players() {
        return players;
    }
}
