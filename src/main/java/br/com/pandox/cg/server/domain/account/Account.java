package br.com.pandox.cg.server.domain.account;

import br.com.pandox.cg.server.domain.player.Player;
import br.com.pandox.cg.server.domain.shared.Domain;

public interface Account extends Domain {

    Player player();
}
