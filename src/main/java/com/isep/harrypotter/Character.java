package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;

@Getter @Setter
public abstract class Character {
    private String name;
    private List<Spell> knownSpells;
    private float hp;
    private int maxHP;
    private String status;
    private float percentSpells = 0.80F;
    private float damage = 1F;
    public Character(String name, List<Spell> knownSpells, float hp, int maxHP){
        this.name = name;
        this.knownSpells = knownSpells;
        this.hp = hp;
        this.maxHP = maxHP;
        this.status = "OK";
    }

    public static void attack(Character character, Year year, Character characterTwo, Character characterThree) {
        if (character instanceof Wizard) {
            Wizard.choiceEnemy((Wizard) character, year, (AbstractEnemy) characterTwo, (AbstractEnemy) characterThree);
        } else if (character instanceof AbstractEnemy) {
            AbstractEnemy.attack((AbstractEnemy) character, (Wizard) characterTwo);
        }
    }

    public static boolean isDead(Character character){
        if (character.getHp() < 0){
            character.setHp(0);
            if (character instanceof AbstractEnemy){
                ((AbstractEnemy) character).setStatus("dead");
                System.out.println(character.getName() + " is dead.");
            } else {
                System.out.println("Oh no ! You are dead. You can't stop Voldemort anymore.\nYou can try again if you dare to !");
            }
            return true;
        } else {
            return false;
        }
    }
}
