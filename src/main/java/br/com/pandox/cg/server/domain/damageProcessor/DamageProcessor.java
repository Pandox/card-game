package br.com.pandox.cg.server.domain.damageProcessor;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;
import br.com.pandox.cg.server.domain.event.DamageEvent;

import java.util.List;

public interface DamageProcessor {

    List<DamageEvent> process(Damager source, Destroyable destroyable);
}
