package br.com.pandox.cg.server.domain.battleground;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.GameMechanics;
import br.com.pandox.cg.server.domain.cards.BasicCard;
import br.com.pandox.cg.server.domain.damageProcessor.NullDamageProcessor;
import br.com.pandox.cg.server.domain.event.DamageData;
import br.com.pandox.cg.server.domain.player.Player;
import br.com.pandox.cg.server.domain.player.PlayerImpl;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
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
        Battleground.Round.Turn turn = getBattleground().round().turn();
        turn.drawCard();

        int cardsHand = turn.player().hand().cards().size();
        assertEquals(cardsHand, GameMechanics.FIRST_HAND_SIZE + 1);
    }

    @Test
    public void actual_player_should_set_a_card_on_field(){
        Battleground.Round.Turn turn = getBattleground().round().turn();
        BasicCard basicCard = turn.player().hand().cards().get(0);

        turn.setCard(basicCard);
        assertEquals(turn.player().field().cards().size(), 1);
    }

    @Test
    public void actual_player_should_attack_enemy_hero_with_card(){
        Battleground.Round.Turn turn = getBattleground().round().turn();

        BasicCard card = turn.player().hand().cards().get(0);
        turn.setCard(card);
        List<DamageData> damages = turn.attack(card, turn.enemy().hero(), new NullDamageProcessor());
        assertEquals(damages.size(), 1);
    }

    private Battleground getBattleground() {
        Set<Player> players = new HashSet<>();
        players.add(new PlayerImpl(1L));
        players.add(new PlayerImpl(2L));
        return new BattlegroundImpl(1L, players);
    }

}
