package com.isep.harrypotter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter @Setter
public abstract class AbstractEnemy extends Character {

    private Year year;
    private String status;
    private String advice;
    public AbstractEnemy(String name, List<Spell> knownSpells, float hp, int maxHP, Year year, String advice) {

        super(name, knownSpells, hp, maxHP);
        this.year = year;
        this.advice = advice;
        setStatus("OK");
    }

    public static void attack(AbstractEnemy enemy, Wizard player){
        int lengthSpells = enemy.getKnownSpells().size();
        Random rand = new Random();
        int randomNumber = rand.nextInt(lengthSpells);
        Spell.useSpellAttack(enemy, enemy.getKnownSpells().get(randomNumber), player);
    }
}
