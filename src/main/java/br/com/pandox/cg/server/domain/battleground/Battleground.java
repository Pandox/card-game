package br.com.pandox.cg.server.domain.battleground;

import br.com.pandox.cg.events.EventPublisher;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;
import br.com.pandox.cg.server.domain.battleground.playerground.PlayerGround;
import br.com.pandox.cg.server.domain.cards.BasicCard;
import br.com.pandox.cg.server.domain.shared.Domain;
import com.google.common.eventbus.EventBus;

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


    Round round();

    interface Round {

        Turn turn();

        interface Turn {
            BasicCard drawCard();

            void setCard(BasicCard card);

            void attack(BasicCard card, Destroyable target, EventPublisher publisher);

            PlayerGround player();

            PlayerGround enemy();
        }
    }




    enum Status {
        STARTED
    }
}
