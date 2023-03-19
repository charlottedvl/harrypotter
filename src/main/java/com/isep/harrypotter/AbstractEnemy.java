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
    public AbstractEnemy(String name, float hp, int maxHP, Year year, String advice) {

        super(name, hp, maxHP);
        this.year = year;
        this.advice = advice;
        setStatus("OK");
    }

    public void attack(Wizard player){
        int lengthSpells = this.getKnownSpells().size();
        Random rand = new Random();
        int randomNumber = rand.nextInt(lengthSpells);
        this.getKnownSpells().get(randomNumber).useSpellAttack(this, player);
    }
}
