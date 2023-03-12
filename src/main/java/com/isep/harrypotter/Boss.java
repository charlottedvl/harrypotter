package com.isep.harrypotter;

import java.util.List;

public class Boss extends AbstractEnemy{
    private Year year;
    public Boss(String name, List<Spell> knownSpells, int hp) {

        super(name, knownSpells, hp);
    }
}
