package com.isep.harrypotter;

import java.util.List;

public class Boss extends AbstractEnemy{
    private Year year;
    public Boss(String name, List<Spell> knownSpells, int hp, int maxHP, Year year) {

        super(name, knownSpells, hp, maxHP, year);
    }
}
