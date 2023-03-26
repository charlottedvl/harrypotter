package com.isep.harrypotter.scholarship;

import com.isep.harrypotter.Setup;
import com.isep.harrypotter.knowledge.Potion;
import com.isep.harrypotter.knowledge.Spell;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import com.isep.harrypotter.character.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Getter @Setter
public class Year {
    private int numberYear;
    private String number;// first, second, third...
    private String name;
    private String lieu;
    private String advice;


    public void yearProgress(Wizard player, ArrayList<Spell> spells, ArrayList<Potion> allPotions){
        System.out.println(this.name);
        System.out.println("Welcome to your " + this.number + " year at Hogwarts School !");
        System.out.println(this.advice);
        for (int trimester = 1; trimester < 4; trimester++){
            trimester(player, trimester);
        }
    }

    public void trimester(Wizard player, int trimester){
        int action = ChoiceAction(trimester);
        switch (action) {
            case 1 -> {
                player.attendSpellClass(this);
            }
            case 2 -> {
                player.attendPotionClass(this);
            }
            case 3 -> {
                player.setPercentSpells(SkipClass(player.getPercentSpells()));
                player.setPercentPotion(SkipClass(player.getPercentPotion()));
                player.setPercentFireworks(SkipClassFireworks(player.getPercentFireworks()));
            }
            default -> {
                System.out.println("Please enter a valid number");
                trimester(player, trimester);
            }
        }
    }
    public int ChoiceAction(int trimester){
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

    public float SkipClass(float percentSuccess){
        percentSuccess = (float) (percentSuccess - 0.05);
        return percentSuccess;
    }

    public float SkipClassFireworks(float percentFireworks){
        percentFireworks = (float) (percentFireworks + 0.05);
        return percentFireworks;
    }


    public void StartFights(Wizard player, List<Fight> fights){
        Fight firstFight = fights.get(0);
        Fight secondFight = fights.get(1);
        Fight bossFight = fights.get(2);
        System.out.println(firstFight.getDescription());
        firstFight.fight(player, this);
        System.out.println(secondFight.getDescription());
        secondFight.fight(player, this);
        System.out.println(bossFight.getDescription());
        bossFight.fight(player, this);
    }



}
