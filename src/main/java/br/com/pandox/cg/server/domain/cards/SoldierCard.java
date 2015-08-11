package br.com.pandox.cg.server.domain.cards;

public class SoldierCard implements BasicCard {

    @Override public Integer power() {
        return 1;
    }

    @Override public Integer life() {
        return 1;
    }

    @Override public Integer runes() {
        return 1;
    }
}
