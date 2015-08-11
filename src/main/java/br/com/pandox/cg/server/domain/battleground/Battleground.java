package br.com.pandox.cg.server.domain.battleground;

import br.com.pandox.cg.server.domain.battleground.playerground.PlayerGround;
import br.com.pandox.cg.server.domain.shared.Domain;

public interface Battleground extends Domain {

    PlayerGround red();

    PlayerGround blue();

    Battleground.Status status();

    /**
     * Retorna o primeiro jogador a iniciar o jogo.<br />
     * 0 = RED<br />
     * 1 = BLUE<br />
     * @return
     */
    short firstPlayer();

    enum Status {
        STARTED
    }
}
