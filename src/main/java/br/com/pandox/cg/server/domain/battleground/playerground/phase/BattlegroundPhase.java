package br.com.pandox.cg.server.domain.battleground.playerground.phase;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Targetable;
import br.com.pandox.cg.server.domain.battleground.playerground.PlayerGround;
import br.com.pandox.cg.server.domain.cards.BasicCard;

public interface BattlegroundPhase {

    BasicCard drawCard();

    void setCard(BasicCard card);

    void attack(BasicCard card, Targetable target);

    PlayerGround actual();



}
