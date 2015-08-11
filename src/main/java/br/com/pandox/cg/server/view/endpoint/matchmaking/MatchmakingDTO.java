package br.com.pandox.cg.server.view.endpoint.matchmaking;

import br.com.pandox.cg.server.domain.matchmaking.MatchMaking;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchmakingDTO {

    private Long id;
    private Long player;
    private Long battleground_id;

    public MatchmakingDTO() {}

    public MatchmakingDTO(MatchMaking matchMaking) {
        this.id = matchMaking.identifier();
        if(matchMaking.battleground() != null){
            this.battleground_id = matchMaking.battleground().identifier();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayer() {
        return player;
    }

    public void setPlayer(Long player) {
        this.player = player;
    }

    @JsonProperty(value = "battleground_id")
    public Long getBattleground_id() {
        return battleground_id;
    }

    public void setBattleground_id(Long battleground_id) {
        this.battleground_id = battleground_id;
    }
}
