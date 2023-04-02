package com.isep.harrypotter.scholarship;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import com.isep.harrypotter.character.*;
import java.util.List;

@AllArgsConstructor
@Getter @Setter
public class Year {
    private int numberYear;
    private String number;// first, second, third...
    private String name;
    private String lieu;
    private String advice;

    //The progress of a year
    public void yearProgress(Wizard player) {
        System.out.println(this.name);
        System.out.println("Welcome to your " + this.number + " year at Hogwarts School !");
        System.out.println(this.advice);
        for (int trimester = 1; trimester < 4; trimester++) { //3 trimesters
            trimester(player, trimester);
        }
    }

    //The progress of a trimester
    public void trimester(Wizard player, int trimester) {
        int action = ChoiceAction(trimester, player);
        switch (action) {
            case 1 -> player.attendSpellClass(this);
            case 2 -> player.attendPotionClass(this);
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

    //Choose to attend spell or potion class or skip classes
    public int ChoiceAction(int trimester, Wizard player) {
        String number ="";
        switch (trimester) {
            case 1->number = "first";
            case 2->number = "second";
            case 3->number = "third";
            default-> System.out.println("An error occured, please restart the game");
        }
        System.out.println("What do you want to do of your " + number + " trimester at Hogwarts ? (Please enter the number of the action)");
        System.out.println("1. Follow the sorcery lesson");
        System.out.println("2. Follow the potion lesson");
        System.out.println("3. Skip class and have fun");
        return player.getUtiles().choice(3);
    }

    //If you skip class, you reduce the percent of potion success and spell success
    public float SkipClass(float percentSuccess) {
        if (percentSuccess < 0.95 && percentSuccess > 0.30) {
            percentSuccess = (float) (percentSuccess - 0.05);
            }
        return percentSuccess;
    }

    //If you skip class, you increase the percent to have fireworks against Ombrage (year 5)
    public float SkipClassFireworks(float percentFireworks) {
        if (percentFireworks < 0.95 && percentFireworks > 0.30) {
            percentFireworks = (float) (percentFireworks + 0.05);
        }
        return percentFireworks;
    }

    //Fights progress (there are always 3 fights)
    public void StartFights(Wizard player, List<Fight> fights) {
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
