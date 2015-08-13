package br.com.pandox.cg.server.domain.damageProcessor;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;
import br.com.pandox.cg.server.domain.event.DamageData;
import br.com.pandox.cg.server.domain.event.DamageDataImpl;
import com.google.common.collect.Lists;

import java.util.List;

public class NullDamageProcessor extends SimpleDamageProcessor implements DamageProcessor {


    @Override public List<DamageData> process(Damager source, Destroyable destroyable) {

        DamageData damageData = new DamageDataImpl(source, destroyable, 1, 1);
        return Lists.newArrayList(damageData);
    }
}
