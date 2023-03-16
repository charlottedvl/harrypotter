package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Getter @Setter
public class Spell extends AbstractSpell{


    public Spell(String name, int damage, String description, int year, String type, String effectOne, String effectTwo) {

        super(name, damage, description, year, type, effectOne, effectTwo);
    }


    public static ArrayList<Spell> createSpells(){
        ArrayList<Spell> spells = new ArrayList<>();
        // We create the spells
        Spell lumos = new Spell("Lumos", 0, "Create a light at the end of your wand. Useful to see in the dark... and to reassure you", 1, "none", "light", "none");
        Spell allohomora = new Spell("Allohomora", 0, "Open any lock you want", 1, "none", "open", "none");
        Spell wingardium_Leviosa = new Spell("Wingardium Leviosa", 30, "Levitate any object, provided you pronounce the magic formula correctly", 1, "none", "damages", "none");
        // We add them to the list
        spells.add(lumos);
        spells.add(allohomora);
        spells.add(wingardium_Leviosa);
        return spells;
    }



    public static Spell attendSpellClass(Year year, ArrayList<Spell> spells, Wizard player){
        System.out.println("You have chosen to attend the sorcery class");
        System.out.println("This year, you can learn one of the many spells below. Please enter the number of the spell you want to learn");
        int i=1;
        i = showSpells(spells, year, "attack", i);
        i = showSpells(spells, year, "defense", i);
        i = showSpells(spells, year, "none", i);
        int choice = HelloApplication.choice(spells.size());
        return spells.get(choice-1);
    }

    public static Spell searchSpell(String nameSpell, ArrayList<Spell> spells, Year year, Wizard player){
        while (true) {
            for (Spell spell : spells) {
                if (spell.getName().equalsIgnoreCase(nameSpell)) {
                    return spell;
                }
            }
            System.out.println("Please enter a valid spell");
            Spell spell = attendSpellClass(year, spells, player);
        }
    }

    public static void learnSpell(Spell spell, Wizard player, Year year, ArrayList<Spell> spells){
        System.out.println("Are you sur you want to learn " + spell.getName() + " ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int validate = HelloApplication.choice(2);
        switch (validate){
            case 1 :
                player.getKnownSpells().add(spell);
                spells.remove(spell);
                System.out.println("You have successfully learn " + spell.getName());
                break;
            case 2:
                System.out.println("Please choose another spell from the list");;
                attendSpellClass(year, spells, player);
                break;
            default :
                System.out.println("Please enter a valid number");
                learnSpell(spell, player, year, spells);
                break;
        }
    }


    public static int showSpells(List<Spell> spells, Year year, String type, int i){
        for (Spell spell : spells) {
            if (spell.getYear() <= year.getNumberYear() && spell.getType().equalsIgnoreCase(type)){
                System.out.println(i + ". " + spell.getName() + " : " + spell.getDescription());
                i++;
            }
        } return i;
    }

    public static void chooseSpell(Wizard player, Year year, AbstractEnemy enemy){
        int j = 2;
        System.out.println("1. I changed my mind");
        j = Spell.showSpells(player.getKnownSpells(), year, "attack", j);
        j = Spell.showSpells(player.getKnownSpells(), year, "none", j);
        int spell = HelloApplication.choice(j);
        if (spell == 1) {
            Wizard.attack(player, year, enemy);
        } else if (spell >= j) {
            System.out.println("Please enter a number between 1 and " + j);
            chooseSpell(player, year, enemy);
        } else {
            Spell.useSpell(player, player.getKnownSpells().get(spell-2), enemy);
        }
    }
    public static void useSpell(Character characterOne, Spell spell, Character characterTwo){
        String effectOne = spell.getEffectOne();
        String effectTwo = spell.getEffectTwo();
        switch (effectOne){
            case "light"-> light(characterTwo);
            case "confusion"-> confusion(characterTwo);
            case "heal"-> heal(characterTwo);
            case "increase"-> increase(characterTwo);
            case "invulnerable" -> invulnerable(characterTwo);
            case "expecto" -> expecto(characterTwo);
            case "attire" -> attire(characterTwo);
            case "reduce" -> reduce(characterTwo);
            case "damages" -> damages(characterOne, spell, characterTwo);
        }
    }

    public static void damages(Character character, Spell spell, Character opponent){
        String nameCharacter;
        String opponentName;
        if (character instanceof Wizard){
            nameCharacter = "You have";
            opponentName = opponent.getName() + " has";
        } else {
            nameCharacter = character.getName() + " has";
            opponentName = "You have";
        }
        float percentSpells = character.getPercentSpells();
        Random random = new Random();
        float randomFloat = random.nextFloat();
        float damages = (character.getDamage()*spell.getDamage());
        if (randomFloat <= percentSpells){
            opponent.setHp(opponent.getHp()-damages);
            boolean isDead = Character.isDead(opponent);
            if (isDead == false){
                System.out.println(nameCharacter + " successfully use " + spell.getName() +". " + opponentName + " " + opponent.getHp() + " HP.");
            }
        } else if (randomFloat > 0.95F){
            character.setHp(character.getHp()-damages);
            boolean isDead = Character.isDead(character);
            if (isDead == false){
                System.out.println(nameCharacter +" miscast the spell ! " + nameCharacter + " now " + character.getHp() + " HP.");
            }
        } else {
            System.out.println(nameCharacter + " failed to cast your spell. No damages have been done to anyone.");
        }
    }

    public static void reduce(Character enemy){

    }

    public static void attire(Character enemy){

    }

    public static void expecto(Character enemy){

    }

    public static void light(Character enemy){

    }

    public static void heal(Character enemy){

    }

    public static void confusion(Character enemy){

    }

    public static void increase(Character enemy){

    }
    public static void invulnerable(Character enemy){

    }
}
