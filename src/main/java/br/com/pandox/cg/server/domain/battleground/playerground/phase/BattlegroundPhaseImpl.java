package br.com.pandox.cg.server.domain.battleground.playerground.phase;

import br.com.pandox.cg.server.domain.battleground.Battleground;
import br.com.pandox.cg.server.domain.battleground.playerground.PlayerGround;

public class BattlegroundPhaseImpl implements BattlegroundPhase {

    private Battleground battleground;
    private short playerTurn;

    public BattlegroundPhaseImpl(Battleground battleground) {
        this.battleground = battleground;
        this.playerTurn = battleground.firstPlayer();
    }

    public PlayerGround actual(){
        if(playerTurn == 0) {
            return battleground.red();
        }
        return battleground.blue();
    }

    public PlayerGround enemy(){
        if(actual().equals(battleground.red())) {
            return battleground.blue();
        }
        return battleground.red();
    }
}
