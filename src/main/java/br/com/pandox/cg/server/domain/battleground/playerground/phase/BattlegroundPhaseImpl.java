package br.com.pandox.cg.server.domain.battleground.playerground.phase;

import br.com.pandox.cg.server.domain.battleground.Battleground;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Targetable;
import br.com.pandox.cg.server.domain.battleground.playerground.PlayerGround;
import br.com.pandox.cg.server.domain.cards.BasicCard;

public class BattlegroundPhaseImpl implements BattlegroundPhase {

    private Battleground battleground;

    private short playerTurn;

    public BattlegroundPhaseImpl(Battleground battleground) {
        this.battleground = battleground;
        this.playerTurn = battleground.firstPlayer();
    }

    @Override
    public BasicCard drawCard() {
        return actual().drawCard();
    }

    @Override
    public void setCard(BasicCard card) {
        actual().setCard(card);
    }

    @Override
    public void attack(BasicCard card, Targetable target) {
//        actual().field().cards().get();

    }

    public PlayerGround actual(){
        if(playerTurn == 0) {
            return battleground.red();
        }
        return battleground.blue();
    }

    private PlayerGround enemy(){
        if(actual().equals(battleground.red())) {
            return battleground.blue();
        }
        return battleground.red();
    }
}
