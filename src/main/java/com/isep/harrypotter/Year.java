package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Scanner;

@AllArgsConstructor
@Getter @Setter
public class Year {
    private int numberYear;
    private String number;// first, second, third...
    private String name;
    private String lieu;


    public static ArrayList<Year> createYear(){
        ArrayList<Year> years = new ArrayList<Year>();
        Year yearOne = new Year(1, "first", "The Philosopher's Stone", "Dungeon's toilets" );
        years.add(yearOne);
        return years;
    }

    public static void yearProgress(Year year, Wizard player, ArrayList<Spell> spells){
        System.out.println(year.name);
        System.out.println("Welcome to your " + year.number + " year at Hogwarts School !");
        for (int trimester = 1; trimester < 4; trimester++){
            int action = ChoiceAction(trimester);
            switch (action){
                case 1:
                    String nameSpell = Spell.attendSpellClass(year, spells, player);
                    Spell spell = Spell.searchSpell(nameSpell, spells, year, player);
                    Spell.learnSpell(spell, player, year, spells);
                    break;
                case 2:
                    break;
                case 3:
                    player.setPercentSpells(SkipClass(player.getPercentSpells()));
                    player.setPercentPotion(SkipClass(player.getPercentPotion()));
                    player.setPercentFireworks(SkipClassFireworks(player.getPercentFireworks()));
                    break;
                default:
                    System.out.println("Please enter a valid number");
                    break;
            }
        }
    }

    public static int ChoiceAction(int trimester){
        String number ="";
        switch (trimester){
            case 1->number = "first";
            case 2->number = "second";
            case 3->number = "third";
            default-> System.out.println("An error occured, please restart the game");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do of your " + number + " trimester at Hogwarts ? (Please enter the number of the action)");
        System.out.println("1. Follow the sorcery lesson");
        System.out.println("2. Follow the potion lesson");
        System.out.println("3. Skip class and have fun");
        int action = scanner.nextInt();
        return action;
    }

    public static float SkipClass(float percentSuccess){
        percentSuccess = (float) (percentSuccess - 0.05);
        return percentSuccess;
    }

    public static float SkipClassFireworks(float percentFireworks){
        percentFireworks = (float) (percentFireworks + 0.05);
        return percentFireworks;
    }
}
