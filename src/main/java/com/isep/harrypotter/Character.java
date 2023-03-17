package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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
        boolean test = testStatus(character);
        if (character instanceof Wizard) {
            if (test == true) {
                ArrayList<AbstractEnemy> enemies = new ArrayList<AbstractEnemy>();
                enemies.add((AbstractEnemy) characterTwo);
                enemies.add((AbstractEnemy) characterThree);
                Wizard.choiceEnemy((Wizard) character, year, enemies);
            }
        } else if (character instanceof AbstractEnemy) {
            if (test == true){
                AbstractEnemy.attack((AbstractEnemy) character, (Wizard) characterTwo);
            }
        }
    }

    public static boolean testStatus(Character character){
        String status = character.getStatus();
        boolean test = true;
        switch (status){
            case "Confused1":
                character.setStatus("OK");
                test = false;
                break;
            case "Confused2":
                character.setStatus("Confused1");
                test = false;
                break;
            case "Reduced1" :
                character.setStatus("OK");
                character.setDamage(1F);
                if (character instanceof Wizard){
                    Wizard player = (Wizard) character;
                    if (player.getHouse().equals("Slytherin")){
                        character.setDamage(1.2F);
                    }
                }
                break;
        }
        return test;
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

    public static String[] findName(Character character, Character opponent){
        String[] names = new String[2];
        if (character instanceof Wizard){
            names[0] = "You have";
            names[1] = opponent.getName() + " has";
        } else {
            names[0] = character.getName() + " has";
            names[1] = "You have";
        }
        return names;
    }
}
