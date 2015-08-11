package br.com.pandox.cg.server.view.endpoint.matchmaking;

import br.com.pandox.cg.server.domain.MatchMaking;

public class MatchmakingDTO {

    private Long id;
    private String name;

    public MatchmakingDTO() {}

    public MatchmakingDTO(MatchMaking matchMaking) {
        this.id = matchMaking.identifier();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
