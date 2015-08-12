package br.com.pandox.cg.server.domain.battleground;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.GameMechanics;
import br.com.pandox.cg.server.domain.player.Player;
import br.com.pandox.cg.server.domain.player.PlayerImpl;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class BattlegroundImplTest {

    @Test
    public void should_have_two_players_upon_creation() {
        Battleground battleground = getBattleground();

        assertNotNull(battleground.red());
        assertNotNull(battleground.blue());
    }

    @Test
    public void should_return_first_player_to_play() {
        Battleground battleground = getBattleground();
        assertEquals(battleground.firstPlayer(), 0);
    }

    @Test
    public void when_round_start_first_player_must_draw_a_card() {
        Battleground battleground = getBattleground();
        battleground.actual().drawCard();
        int cardsHand = battleground.actual().hand().cards().size();
        assertEquals(cardsHand, GameMechanics.FIRST_HAND_SIZE+1);
    }

    private Battleground getBattleground() {
        Set<Player> players = new HashSet<>();
        players.add(new PlayerImpl(1L));
        players.add(new PlayerImpl(2L));
        return new BattlegroundImpl(1L, players);
    }

}
