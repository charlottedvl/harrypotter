package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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


    public void yearProgress(Year year, Wizard player, ArrayList<Spell> spells, ArrayList<Potion> allPotions){
        System.out.println(this.name);
        System.out.println("Welcome to your " + this.number + " year at Hogwarts School !");
        System.out.println(this.advice);
        for (int trimester = 1; trimester < 4; trimester++){
            int action = ChoiceAction(trimester);
            switch (action) {
                case 1 -> {
                    player.attendSpellClass(year);
                }
                case 2 -> {
                    player.attendPotionClass(year);
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

    public void StartFightsOne(Wizard player){
        ArrayList<Fight> fightsOne = createFightYearOne(this);
        Fight firstFight = fightsOne.get(0);
        Fight secondFight = fightsOne.get(1);
        Fight bossFight = fightsOne.get(2);
        System.out.println(firstFight.getDescription());
        firstFight.fight(player, this);
        System.out.println(secondFight.getDescription());
        secondFight.fight(player, this);
        System.out.println(bossFight.getDescription());
        bossFight.fight(player, this);
    }


    public ArrayList<Fight> createFightYearOne(Year year){
        //Enemies for first fight
        Enemy shadowOne = new Enemy("Shadow", 1000, 1000, year, "Use something that create light to destroy it");
        shadowOne.createEnemyShadow(year);
        Enemy shadowTwo = new Enemy("Shadow", 1000, 1000, year, "Use something that create light to destroy it");
        shadowTwo.createEnemyShadow(year);
        List<AbstractEnemy> enemiesOne = new ArrayList<>();
        enemiesOne.add(shadowOne);
        enemiesOne.add(shadowTwo);
        Fight FOneYOne = new Fight(year, enemiesOne, "Oh no ! It seems that you are in trouble. In the dungeon, the shadows scares you. You become to be paranoid and hurt yourself. \nTry to reassure yourself", 1);
        //Enemies for second fight
        Enemy lock = new Enemy("Lock",  70, 70, year, "Use a spell that can open lock to pass this adventure");
        lock.createEnemyLock(year);
        Enemy rock = new Enemy("Rock",  30, 30, year, "Make damages to destroy it");
        rock.createEnemyRock(year);
        List<AbstractEnemy> enemiesTwo = new ArrayList<>();
        enemiesTwo.add(lock);
        enemiesTwo.add(rock);
        Fight FTwoYOne = new Fight(year, enemiesTwo, "When you enter deeper in the Dungeon, you see that the way is blocked by a rock and a door closed by a lock. \nClear the way to pass", 2);
        //Enemies for the Boss fight
        Boss troll = new Boss("Troll", 1000, 1000, year, "Use Wingardium Leviosa to make damages on his head");
        troll.createTroll(year);
        List<AbstractEnemy> enemiesBoss = new ArrayList<>();
        enemiesBoss.add(troll);
        Fight FBoss = new Fight(year, enemiesBoss, "There is a HUUUUGE Troll on your way ! Make him inconscious. Be careful, he is insensible to potion", 3);
        //Create the list of fights for the first year
        ArrayList<Fight> fights = new ArrayList<>();
        fights.add(FOneYOne);
        fights.add(FTwoYOne);
        fights.add(FBoss);
        return fights;
    }


}
