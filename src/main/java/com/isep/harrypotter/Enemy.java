package com.isep.harrypotter;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends AbstractEnemy{
    public Enemy(String name, List<Spell> knownSpells, int hp, int maxHP, Year year) {

        super(name, knownSpells, hp, maxHP, year);

    }

    public static Enemy createEnemyFightOne(String name, int hp, int maxHP, Year year){
        List<Spell> knownSpellsEnemy = new ArrayList<>();
        Spell attackShadows = new Spell("Shadows", 15, "The fear it provokes make damages", 1, "attack");
        knownSpellsEnemy.add(attackShadows);
        Enemy shadow = new Enemy(name, knownSpellsEnemy, hp, maxHP, year);
        return shadow;
    }
}
