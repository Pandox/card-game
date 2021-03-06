package br.com.pandox.cg.server.domain.damageProcessor;

import br.com.pandox.cg.server.domain.battleground.Battleground;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;
import br.com.pandox.cg.server.domain.data.DamageData;

import java.util.List;

public interface DamageProcessor {

    List<DamageData> process(Damager source, Destroyable destroyable);

}
