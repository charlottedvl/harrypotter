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
    private int damage;
    private String description;
    private int year;
    private String type;

    public static ArrayList<Potion> createPotions(){
        ArrayList<Potion> allPotions = new ArrayList<>();
        //We create the potions
        Potion forgetfulness = new Potion ("Forgetfulness Potion", 0, "Make your opponent lose memory. it increase confusion, useful when you don't want your enemy to attack !", 1, "attack");
        Potion wiggenweld = new Potion ("Wiggenweld Potion", 0, "A potion that help you heal from your injuries", 1, "defense");
        Potion antidote = new Potion ("Antidote to Common Poisons", 0, "Suppress common poisons from your body", 1, "defense");
        Potion fire  = new Potion ("Fire Potion", 30, "Create a huge fire that burn enemies and light up the place", 1, "attack");
        //We add them to the list
        allPotions.add(forgetfulness);
        allPotions.add(wiggenweld);
        allPotions.add(antidote);
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

    public static void learnPotion(Potion potion, Wizard player, Year year, ArrayList<Potion> allPotions){
        System.out.println("Are you sur you want to learn " + potion.getName() + " ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        Scanner scanner = new Scanner(System.in);
        int validate = scanner.nextInt();
        switch (validate){
            case 1 :
                player.getPotions().add(potion);
                allPotions.remove(potion);
                System.out.println("You have successfully learn " + potion.getName());
                break;
            case 2:
                System.out.println("Please choose another spell from the list");;
                attendPotionClass(year, allPotions, player);
                break;
            default :
                System.out.println("Please enter a valid number");
                learnPotion(potion, player, year, allPotions);
                break;
        }

    }


    public static int showPotions(List<Potion> potions, Year year, int i, String type){
        for (Potion potion : potions) {
            if (potion.getYear() <= year.getNumberYear() && potion.getType().equalsIgnoreCase(type)){
                System.out.println(i + ". " + potion.getName() + " : " + potion.getDescription());
                i++;
            }
        }
        return HelloApplication.choice(i);
    }
    public static void choosePotion(Wizard player, Year year, AbstractEnemy enemy){
        System.out.println("1. I changed my mind");
        int j = 2;
        int choice = Potion.showPotions(player.getPotions(), year, j, "attack");
        if (choice == 1) {
            Wizard.attack(player, year, enemy);
        } else {
            Potion.usePotion();
        }
    }
    public static void usePotion(){

    }
}
