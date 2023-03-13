package com.isep.harrypotter;

import java.util.List;

public abstract class AbstractEnemy extends Character {

    private Year year;
    public AbstractEnemy(String name, List<Spell> knownSpells, int hp, int maxHP, Year year) {

        super(name, knownSpells, hp, maxHP);
        this.year = year;
    }

    public static void attack(){

    }
}
