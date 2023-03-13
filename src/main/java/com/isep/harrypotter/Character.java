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
    private int hp;
    private int maxHP;
    private float percentSpells = 0.75F;
    public Character(String name, List<Spell> knownSpells, int hp, int maxHP){
        this.name = name;
        this.knownSpells = knownSpells;
        this.hp = hp;
        this.maxHP = maxHP;
    }

    public static void attack(Character character, Year year) {
        if (character instanceof Wizard) {
            Wizard.attack((Wizard) character, year);
        } else if (character instanceof AbstractEnemy) {
            AbstractEnemy.attack();
        }
    }

}
