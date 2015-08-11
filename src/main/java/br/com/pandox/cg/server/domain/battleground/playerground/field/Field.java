package br.com.pandox.cg.server.domain.battleground.playerground.field;

import br.com.pandox.cg.server.domain.cards.BasicCard;
import com.google.common.collect.ImmutableList;

public interface Field {

    ImmutableList<BasicCard> cards();

    void append(BasicCard card);

}
