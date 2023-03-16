package com.isep.harrypotter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter @Setter
public abstract class AbstractEnemy extends Character {

    private Year year;
    private String status;
    public AbstractEnemy(String name, List<Spell> knownSpells, float hp, int maxHP, Year year) {

        super(name, knownSpells, hp, maxHP);
        this.year = year;
    }

    public static void attack(AbstractEnemy enemy, Wizard player){
        int lengthSpells = enemy.getKnownSpells().size();
        Random rand = new Random();
        int randomNumber = rand.nextInt(lengthSpells);
        Spell.useSpell(enemy, enemy.getKnownSpells().get(randomNumber), player);
    }
}
