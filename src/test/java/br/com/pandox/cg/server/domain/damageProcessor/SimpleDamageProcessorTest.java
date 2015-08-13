package br.com.pandox.cg.server.domain.damageProcessor;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.GameMechanics;
import br.com.pandox.cg.server.domain.battleground.playerground.hero.HeroImpl;
import br.com.pandox.cg.server.domain.cards.SoldierCard;
import br.com.pandox.cg.server.domain.data.DamageData;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class SimpleDamageProcessorTest {


    @Test
    public void should_generate_damageData_for_target_hero() {
        DamageProcessor damageProcessor = new SimpleDamageProcessor();

        Damager source = new SoldierCard();
        Destroyable destroyable = new HeroImpl();
        List<DamageData> damageDatas = damageProcessor.process(source, destroyable);
        assertEquals(damageDatas.get(0).source(), source);
        assertEquals(damageDatas.get(0).target(), destroyable);
        assertEquals(damageDatas.get(0).previousLife(), GameMechanics.INITIAL_LIFE_POINTS.intValue());
        assertEquals(damageDatas.get(0).afterLife(), GameMechanics.INITIAL_LIFE_POINTS.intValue()-1);
    }

    @Test
    public void should_generate_damageData_for_both_damager_and_target() {
        DamageProcessor damageProcessor = new SimpleDamageProcessor();

        Damager source = new SoldierCard();
        Destroyable destroyable = new SoldierCard();
        List<DamageData> damageDatas = damageProcessor.process(source, destroyable);
        assertEquals(damageDatas.get(1).source(), destroyable);
        assertEquals(damageDatas.get(1).target(), source);
        assertEquals(damageDatas.get(1).previousLife(), 1);
        assertEquals(damageDatas.get(1).afterLife(), 0);
    }

}