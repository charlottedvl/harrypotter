package com.isep.harrypotter;

import java.util.List;

public class Enemy extends AbstractEnemy{
    public Enemy(String name, List<Spell> knownSpells, int hp) {

        super(name, knownSpells, hp);
    }
}
