package com.isep.harrypotter;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class Enemy extends AbstractEnemy{
    public Enemy(String name, List<Spell> knownSpells, float hp, int maxHP, Year year) {

        super(name, knownSpells, hp, maxHP, year);

    }

    public static Enemy createEnemyFightOne(String name, float hp, int maxHP, Year year){
        List<Spell> knownSpellsEnemy = new ArrayList<>();
        Spell attackShadows = new Spell("Shadows", 15, "The fear it provokes make damages", 1, "attack", "damages", "none");
        knownSpellsEnemy.add(attackShadows);
        Enemy shadow = new Enemy(name, knownSpellsEnemy, hp, maxHP, year);
        return shadow;
    }
}
