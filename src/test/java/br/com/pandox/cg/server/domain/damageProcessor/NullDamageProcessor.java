package br.com.pandox.cg.server.domain.damageProcessor;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;
import br.com.pandox.cg.server.domain.event.DamageEvent;
import br.com.pandox.cg.server.domain.event.DamageEventImpl;
import com.google.common.collect.Lists;

import java.util.List;

public class NullDamageProcessor implements DamageProcessor {


    @Override public List<DamageEvent> process(Damager source, Destroyable destroyable) {

        DamageEvent damageEvent = new DamageEventImpl(source, destroyable, 1, 1);
        return Lists.newArrayList(damageEvent);
    }
}
