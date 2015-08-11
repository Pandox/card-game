package br.com.pandox.cg.server.domain.player;

public class PlayerImpl implements Player {

    private Long id;
    private String name;

    public PlayerImpl(Long id) {
        this.id = id;
    }

    @Override public String name() {
        return name;
    }

    @Override public Long identifier() {
        return id;
    }
}
