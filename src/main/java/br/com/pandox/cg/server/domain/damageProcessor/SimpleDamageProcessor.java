package br.com.pandox.cg.server.domain.damageProcessor;

import br.com.pandox.cg.server.domain.battleground.Battleground;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;
import br.com.pandox.cg.server.domain.data.DamageData;
import br.com.pandox.cg.server.domain.data.DamageDataImpl;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleDamageProcessor implements DamageProcessor {

    @Override
    public List<DamageData> process(Damager source, Destroyable destroyable) {
        DamageData damageData = processTarget(source, destroyable);
        ArrayList<DamageData> data = Lists.newArrayList(damageData);

        if(isCounterAttack(source, destroyable)){
            DamageData damageData2 = processTarget((Damager) destroyable, (Destroyable) source);
            data.add(damageData2);
        }

        return data;
    }

    @Override
    public void process(Battleground battleground, List<DamageData> damageDatas) {

    }

    private boolean isCounterAttack(Damager source, Destroyable destroyable) {
        return source instanceof Destroyable && destroyable instanceof Damager;
    }

    private DamageData processTarget(Damager source, Destroyable destroyable) {
        int previousLife = destroyable.life();
        destroyable.damage(source);
        return new DamageDataImpl(source, destroyable, previousLife, destroyable.life());
    }
}
