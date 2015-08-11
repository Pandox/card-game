package br.com.pandox.cg.server.service.player;

import br.com.pandox.cg.server.domain.player.Player;
import br.com.pandox.cg.server.infrastructure.repository.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Override
    public Player find(Long id) {
        return repository.find(id);
    }
}
