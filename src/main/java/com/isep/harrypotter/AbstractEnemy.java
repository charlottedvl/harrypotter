package com.isep.harrypotter;

import java.util.List;

public abstract class AbstractEnemy extends Character {
    public AbstractEnemy(String name, List<Spell> knownSpells, int hp) {

        super(name, knownSpells, hp);
    }

    public static void attack(){

    }
}
