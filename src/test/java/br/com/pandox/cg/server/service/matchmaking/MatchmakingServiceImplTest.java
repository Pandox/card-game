package br.com.pandox.cg.server.service.matchmaking;

import br.com.pandox.cg.server.domain.MatchMaking;
import br.com.pandox.cg.server.domain.MatchMakingImpl;
import br.com.pandox.cg.server.domain.player.Player;
import br.com.pandox.cg.server.domain.player.PlayerImpl;
import br.com.pandox.cg.server.infrastructure.repository.MatchmakingRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class MatchmakingServiceImplTest {

    @InjectMocks
    private MatchmakingService service;

    @Mock
    private MatchmakingRepository repository;

    @BeforeClass
    public void init() {
        service = new MatchmakingServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_return_new_matchmaking_from_player() {
        when(repository.next()).thenReturn(new MatchMakingImpl(1L, repository));

        Player player = new PlayerImpl();
        MatchMaking matchMaking = service.enqueue(player);

        assertEquals(matchMaking.identifier().longValue(), 1L);
    }

    @Test
    public void new_matchmaking_should_has_correct_status_upon_creation() {
        when(repository.next()).thenReturn(new MatchMakingImpl(1L, repository));

        Player player = new PlayerImpl();
        MatchMaking matchMaking = service.enqueue(player);

        assertEquals(matchMaking.status(), MatchMakingImpl.Status.WAITING);
    }


    @Test
    public void should_return_matchmaking_with_both_players() {
        MatchMakingImpl matchMakingEntity = new MatchMakingImpl(1L, repository);
        when(repository.next())
            .thenReturn(matchMakingEntity)
            .thenReturn(matchMakingEntity);

        PlayerImpl player1 = new PlayerImpl();
        PlayerImpl player2 = new PlayerImpl();
        service.enqueue(player1);
        MatchMaking matchMaking = service.enqueue(player2);

        boolean foundOne = false;
        boolean foundTwo = false;
        for (Player player : matchMaking.players()) {
            if(player.equals(player1)){
                foundOne = true;
            }
            if(player.equals(player2)){
                foundTwo = true;
            }
        }
        if(!(foundOne || foundTwo)){
            fail();
        }
    }

    @Test
    public void should_change_status_when_matchmaking_matched() {
        MatchMakingImpl matchMakingEntity = new MatchMakingImpl(1L, repository);
        when(repository.next())
            .thenReturn(matchMakingEntity)
            .thenReturn(matchMakingEntity);

        service.enqueue(new PlayerImpl());
        MatchMaking matchMaking = service.enqueue(new PlayerImpl());

        assertEquals(matchMaking.status(), MatchMakingImpl.Status.MATCHED);
    }




}
