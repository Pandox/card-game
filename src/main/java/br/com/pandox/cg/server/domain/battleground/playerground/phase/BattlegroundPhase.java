package br.com.pandox.cg.server.domain.battleground.playerground.phase;

import br.com.pandox.cg.server.domain.battleground.playerground.PlayerGround;

public interface BattlegroundPhase {

    PlayerGround actual();

    PlayerGround enemy();

}
