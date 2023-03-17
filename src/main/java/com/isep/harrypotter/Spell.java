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

    private int level;
    public Spell(String name, float value, String description, int year, String type, String effectOne, String effectTwo, int level) {

        super(name, value, description, year, type, effectOne, effectTwo);
        this.level = level;
    }


    public static ArrayList<Spell> createSpells(){
        ArrayList<Spell> spells = new ArrayList<>();
        // We create the spells
        Spell lumos = new Spell("Lumos", 0F, "Create a light at the end of your wand. Useful to see in the dark... and to reassure you", 1, "none", "light", "none", 1);
        Spell allohomora = new Spell("Allohomora", 0F, "Open any lock you want", 1, "none", "light", "none", 1);
        Spell wingardium_Leviosa = new Spell("Wingardium Leviosa", 30F, "Levitate any object, provided you pronounce the magic formula correctly", 1, "none", "damages", "none", 1);
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
        int choice = Utiles.choice(spells.size());
        return spells.get(choice-1);
    }


    public static void learnSpell(Spell spell, Wizard player, Year year, ArrayList<Spell> spells){
        System.out.println("Are you sur you want to learn " + spell.getName() + " ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int validate = Utiles.choice(2);
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

    public static void chooseSpell(Wizard player, Year year, AbstractEnemy enemy, String type){
        int j = 2;
        System.out.println("1. I changed my mind");
        j = Spell.showSpells(player.getKnownSpells(), year, type, j);
        j = Spell.showSpells(player.getKnownSpells(), year, "none", j);
        int spell = Utiles.choice(j);
        if (spell == 1) {
            Wizard.attack(player, year, enemy);
        } else if (spell >= j) {
            System.out.println("Please enter a number between 1 and " + j);
            chooseSpell(player, year, enemy, type);
        } else {
            Spell.useSpellAttack(player, player.getKnownSpells().get(spell-2), enemy);
        }
    }
    public static void useSpellAttack(Character characterOne, Spell spell, Character characterTwo){
        String effectOne = spell.getEffectOne();
        String effectTwo = spell.getEffectTwo();
        float percent = characterOne.getPercentSpells();
        int level = spell.getLevel();
        String name = spell.getName();
        float value = spell.getValue();
        Fight.effectAttack(characterOne, characterTwo, name, level, value, effectOne, percent);
        Fight.effectAttack(characterOne, characterTwo, name, level, value, effectTwo, percent);
    }
    public static void useSpellDefense(Character characterOne, Character characterTwo, Spell spell){
        String effectOne = spell.getEffectOne();
        String effectTwo = spell.getEffectTwo();
        float percent = characterOne.getPercentSpells();
        float value = spell.getValue();
        String name = spell.getName();
        Fight.effectDefense(characterOne, characterTwo, name, value, effectOne, percent);
        Fight.effectDefense(characterOne, characterTwo, name, value, effectTwo, percent);
    }


}
