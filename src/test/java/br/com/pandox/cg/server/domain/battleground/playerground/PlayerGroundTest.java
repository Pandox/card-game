package br.com.pandox.cg.server.domain.battleground.playerground;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.GameMechanics;
import br.com.pandox.cg.server.domain.battleground.playerground.exception.AlreadyDrawCard;
import br.com.pandox.cg.server.domain.battleground.playerground.exception.OutOfRunes;
import br.com.pandox.cg.server.domain.cards.BasicCard;
import br.com.pandox.cg.server.domain.cards.deck.DeckBuilder;
import br.com.pandox.cg.server.domain.player.PlayerImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PlayerGroundTest {


    @Test
    public void player_should_draw_a_card(){
        PlayerGround playerGround = new PlayerGroundImpl(new PlayerImpl(1L), DeckBuilder.instantiate());

        BasicCard basicCard = playerGround.drawCard();
        assertNotNull(basicCard);
        assertEquals(playerGround.hand().cards().size(), GameMechanics.FIRST_HAND_SIZE+1);
        assertEquals(playerGround.deck().size(), GameMechanics.DECK_SIZE-GameMechanics.FIRST_HAND_SIZE-1);
    }

    @Test(expectedExceptions = AlreadyDrawCard.class)
    public void should_be_unable_to_draw_more_than_one_card_per_round(){
        PlayerGround playerGround = new PlayerGroundImpl(new PlayerImpl(1L), DeckBuilder.instantiate());

        playerGround.drawCard();
        playerGround.drawCard();
    }

    @Test
    public void player_should_set_a_card_on_ground_slot(){
        PlayerGround playerGround = new PlayerGroundImpl(new PlayerImpl(1L), DeckBuilder.instantiate());

        BasicCard firstCard = playerGround.hand().cards().get(0);
        playerGround.setCard(firstCard);

        assertEquals(playerGround.hand().cards().size(), GameMechanics.FIRST_HAND_SIZE-1);
        assertEquals(playerGround.field().cards().size(), 1);
        assertEquals(playerGround.field().cards().get(0), firstCard);
        assertEquals(playerGround.runes(), 0);
    }

    @Test(expectedExceptions = OutOfRunes.class)
    public void player_should_not_be_able_to_set_a_card_when_run_out_of_runes(){
        PlayerGround playerGround = new PlayerGroundImpl(new PlayerImpl(1L), DeckBuilder.instantiate());

        BasicCard firstCard = playerGround.hand().cards().get(0);
        playerGround.setCard(firstCard);
        playerGround.setCard(firstCard);
    }


}
