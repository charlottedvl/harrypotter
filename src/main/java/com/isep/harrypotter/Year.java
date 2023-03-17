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
    private String advice;


    public static ArrayList<Year> createYear(){
        ArrayList<Year> years = new ArrayList<Year>();
        Year yearOne = new Year(1, "first", "The Philosopher's Stone", "Dungeon's toilets", "We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Wingardium Leviosa. ");
        years.add(yearOne);
        return years;
    }

    public static void yearProgress(Year year, Wizard player, ArrayList<Spell> spells, ArrayList<Potion> allPotions){
        System.out.println(year.name);
        System.out.println("Welcome to your " + year.number + " year at Hogwarts School !");
        System.out.println(year.advice);
        for (int trimester = 1; trimester < 4; trimester++){
            int action = ChoiceAction(trimester);
            switch (action) {
                case 1 -> {
                    Spell spell = Spell.attendSpellClass(year, spells, player);
                    Spell.learnSpell(spell, player, year, spells);
                }
                case 2 -> {
                    Potion potion = Potion.attendPotionClass(year, allPotions, player);
                    Potion.learnPotion(potion, player, year, allPotions);
                }
                case 3 -> {
                    player.setPercentSpells(SkipClass(player.getPercentSpells()));
                    player.setPercentPotion(SkipClass(player.getPercentPotion()));
                    player.setPercentFireworks(SkipClassFireworks(player.getPercentFireworks()));
                }
                default -> System.out.println("Please enter a valid number");
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
        return scanner.nextInt();
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
