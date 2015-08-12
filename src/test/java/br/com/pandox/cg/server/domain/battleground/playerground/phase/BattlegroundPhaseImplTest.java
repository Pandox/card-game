package br.com.pandox.cg.server.domain.battleground.playerground.phase;

import br.com.pandox.cg.server.domain.battleground.Battleground;
import br.com.pandox.cg.server.domain.battleground.BattlegroundImpl;
import br.com.pandox.cg.server.domain.cards.BasicCard;
import br.com.pandox.cg.server.domain.player.Player;
import br.com.pandox.cg.server.domain.player.PlayerImpl;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class BattlegroundPhaseImplTest {


    @Test
    public void actual_player_should_draw_a_card(){
        BattlegroundPhase phase = getPhase();

        BasicCard basicCard = phase.drawCard();
        assertNotNull(basicCard);
    }

    @Test
    public void actual_player_should_set_a_card_on_field(){
        BattlegroundPhase phase = getPhase();

        phase.setCard(phase.actual().hand().cards().get(0));
        assertEquals(phase.actual().field().cards().size(), 1);
    }


    private Battleground getBattleground(){
        Set<Player> players = new HashSet<>();
        players.add(new PlayerImpl(1L));
        players.add(new PlayerImpl(2L));
        return new BattlegroundImpl(1L, players);
    }


    private BattlegroundPhase getPhase() {
        return getBattleground().phase();
    }
}