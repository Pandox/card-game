package br.com.pandox.cg.server.domain.damageProcessor;

import br.com.pandox.cg.server.domain.battleground.gameMechanics.Damager;
import br.com.pandox.cg.server.domain.battleground.gameMechanics.Destroyable;
import br.com.pandox.cg.server.domain.event.DamageEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleDamageProcessor implements DamageProcessor {

    @Override
    public List<DamageEvent> process(Damager source, Destroyable destroyable) {
        return null;
    }
}
