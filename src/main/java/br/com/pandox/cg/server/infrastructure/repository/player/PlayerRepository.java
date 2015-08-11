package br.com.pandox.cg.server.infrastructure.repository.player;

import br.com.pandox.cg.server.domain.player.Player;

public interface PlayerRepository {

    Player find(Long id);
}
