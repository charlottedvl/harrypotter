package com.isep.harrypotter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter @Setter
public class Potion {
    private String name;
    private float value;
    private String description;
    private int year;
    private String type;
    private String effectOne;
    private String effectTwo;
    private int level;

    public static ArrayList<Potion> createPotions(){
        ArrayList<Potion> allPotions = new ArrayList<>();
        //We create the potions
        Potion forgetfulness = new Potion ("Forgetfulness Potion", 0F, "Make your opponent lose memory. it increase confusion, useful when you don't want your enemy to attack !", 1, "attack", "confusion", "none", 1);
        Potion wiggenweld = new Potion ("Wiggenweld Potion", 0F, "A potion that help you heal from your injuries", 1, "defense", "heal", "none", 1);
        Potion fire  = new Potion ("Fire Potion", 30F, "Create a huge fire that burn enemies and light up the place", 1, "attack", "light", "damages", 1);
        //We add them to the list
        allPotions.add(forgetfulness);
        allPotions.add(wiggenweld);
        allPotions.add(fire);
        return allPotions;
    }



    public static Potion attendPotionClass(Year year, ArrayList<Potion> allPotions, Wizard player){
        System.out.println("You have chosen to attend the potion class");
        System.out.println("This year, you can learn one of the many potions below. Please enter the number of the potion you want to learn");
        int i = 1;
        for (Potion potion : allPotions) {
            if (potion.getYear() == year.getNumberYear()) {
                System.out.println(i + ". " + potion.getName() + " : " + potion.getDescription());
                i++;
            }
        }
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= i - 1) {
                    break;
                } else {
                    System.out.println("Please enter a valid number between 1 and " + (i-1));
                }
            } else {
                System.out.println("Please enter a valid integer");
                scanner.next();
            }
        }
        return allPotions.get(choice-1);
    }

    public static void learnPotion(Potion potion, Wizard player, Year year, ArrayList<Potion> potions){
        System.out.println("Are you sur you want to learn " + potion.getName() + " ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int validate = Utiles.choice(2);
        switch (validate){
            case 1 :
                player.getPotions().add(potion);
                potions.remove(potion);
                System.out.println("You have successfully learn " + potion.getName());
                break;
            case 2:
                System.out.println("Please choose another spell from the list");;
                attendPotionClass(year, potions, player);
                break;
            default :
                System.out.println("Please enter a valid number");
                learnPotion(potion, player, year, potions);
                break;
        }
    }


    public static int showPotions(List<Potion> potions, Year year, String type, int i){
        for (Potion potion : potions) {
            if (potion.getYear() <= year.getNumberYear() && potion.getType().equalsIgnoreCase(type)){
                System.out.println(i + ". " + potion.getName() + " : " + potion.getDescription());
                i++;
            }
        } return i;
    }
    public static void choosePotion(Wizard player, Year year, AbstractEnemy enemy, String type){
        int j = 2;
        System.out.println("1. I changed my mind");
        j = Potion.showPotions(player.getPotions(), year, type, j);
        j = Potion.showPotions(player.getPotions(), year, "none", j);
        int potion = Utiles.choice(j);
        if (potion == 1) {
            Wizard.attack(player, year, enemy);
        } else if (potion >= j) {
            System.out.println("Please enter a number between 1 and " + j);
            choosePotion(player, year, enemy, type);
        } else if (type.equals("attack")){
            usePotionAttack(player, enemy, player.getPotions().get(potion-2));
        } else {
            usePotionDefense(player, enemy, player.getPotions().get(potion-2));
        }
    }
    public static void usePotionAttack(Wizard player, Character characterTwo, Potion potion){
        String effectOne = potion.getEffectOne();
        String effectTwo = potion.getEffectTwo();
        float percent;
        percent = player.getPercentPotion();
        int level = potion.getLevel();
        String name = potion.getName();
        float value = potion.getValue();
        Fight.effectAttack(player, characterTwo, name, level, value, effectOne, percent);
        Fight.effectAttack(player, characterTwo, name, level, value, effectTwo, percent);
    }
    public static void usePotionDefense(Wizard player, Character characterTwo, Potion potion){
        String effectOne = potion.getEffectOne();
        String effectTwo = potion.getEffectTwo();
        float percent = player.getPercentSpells();
        String name = potion.getName();
        float value = potion.getValue();
        Fight.effectDefense(player, characterTwo, name, value, effectOne, percent);
        Fight.effectDefense(player, characterTwo, name, value, effectTwo, percent);
    }
}
