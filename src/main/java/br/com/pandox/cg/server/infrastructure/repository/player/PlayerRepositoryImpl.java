package br.com.pandox.cg.server.infrastructure.repository.player;

import br.com.pandox.cg.server.domain.player.Player;
import br.com.pandox.cg.server.domain.player.PlayerImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerRepositoryImpl implements PlayerRepository {

    private List<Player> players;

    public PlayerRepositoryImpl() {
        players = new ArrayList<>();
        players.add(new PlayerImpl(1L));
        players.add(new PlayerImpl(2L));
    }

    @Override
    public Player find(Long id) {
        for (Player player : players) {
            if(player.identifier().equals(id)) {
                return player;
            }
        }
        return null;
    }
}
