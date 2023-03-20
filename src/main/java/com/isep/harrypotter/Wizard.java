package com.isep.harrypotter;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Getter @Setter
public class Wizard extends Character{

    private Pet pet;
    private Wand wand;
    private House house;
    private List<Potion> potions;
    private List<Spell> spells;
    private List<Potion> allPotions;
    private float percentPotion = 0.80F;
    private float percentFireworks = 0.30F;
    private Utiles utiles;

    public Wizard(Utiles utiles, String name, float hp, int maxHP){
        super(name, hp, maxHP);
        this.pet = Pet.values()[new Random().nextInt(Pet.values().length)];
        this.wand = new Wand();
        this.house = new House();
        this.potions = new ArrayList<Potion>();
        setStatus("OK");
        this.spells = new ArrayList<Spell>();
        this.allPotions = new ArrayList<Potion>();
        this.utiles = utiles;
    }


    public void attendSpellClass(Year year){
        System.out.println("You have chosen to attend the sorcery class");
        System.out.println("This year, you can learn one of the many spells below. Please enter the number of the spell you want to learn");
        int i=1;
        i = showSpells(this.spells, year, "attack", i);
        i = showSpells(this.spells, year, "defense", i);
        i = showSpells(this.spells, year, "none", i);
        int choice = this.utiles.choice(this.spells.size());
        learnSpell(this.spells.get(choice-1), year);
    }

    public int showSpells(List<Spell> spells, Year year, String type, int i) {
        for (Spell spell : spells) {
            if (spell.getYear() <= year.getNumberYear() && spell.getType().equalsIgnoreCase(type)){
                System.out.println(i + ". " + spell.getName() + " : " + spell.getDescription());
                i++;
            }
        }return i;
    }

    public void learnSpell(Spell spell, Year year){
        System.out.println("Are you sur you want to learn " + spell.getName() + " ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int validate = this.utiles.choice(2);
        switch (validate) {
            case 1 -> {
                this.getKnownSpells().add(spell);
                this.spells.remove(spell);
                System.out.println("You have successfully learn " + spell.getName());
            }
            case 2 -> {
                System.out.println("Please choose another spell from the list");
                ;
                attendSpellClass(year);
            }
            default -> {
                System.out.println("Please enter a valid number");
                learnSpell(spell, year);
            }
        }
    }



    public void attendPotionClass(Year year){
        System.out.println("You have chosen to attend the potion class");
        System.out.println("This year, you can learn one of the many potions below. Please enter the number of the potion you want to learn");
        int i = 1;
        i = showPotions(this.allPotions, year, "attack", i);
        i = showPotions(this.allPotions, year, "defense", i);
        i = showPotions(this.allPotions, year, "none", i);
        int choice = this.utiles.choice(this.allPotions.size());
        this.learnPotion(this.allPotions.get(choice-1), year);
    }

    public int showPotions(List<Potion> allPotions, Year year, String type, int i){
        for (Potion potion : allPotions) {
            if (potion.getYear() <= year.getNumberYear() && potion.getType().equalsIgnoreCase(type)){
                System.out.println(i + ". " + potion.getName() + " : " + potion.getDescription());
                i++;
            }
        }return i;
    }
    public void learnPotion(Potion potion, Year year){
        System.out.println("Are you sur you want to learn " + potion.getName() + " ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int validate = this.utiles.choice(2);
        switch (validate){
            case 1 :
                this.getPotions().add(potion);
                this.allPotions.remove(potion);
                System.out.println("You have successfully learn " + potion.getName());
                break;
            case 2:
                System.out.println("Please choose another spell from the list");;
                this.attendPotionClass(year);
                break;
            default :
                System.out.println("Please enter a valid number");
                this.learnPotion(potion, year);
                break;
        }
    }




    public void choiceEnemy(Year year, ArrayList<AbstractEnemy> enemies){
        System.out.println("Which enemy do you want to target ?");
        if (enemies.get(0).getStatus() != "dead"){
            System.out.println("1. " + enemies.get(0).getName());
        }
        if (enemies.size() > 1 && enemies.get(1).getStatus() != "dead"){
            System.out.println("2. " + enemies.get(1).getName());
        }
        int choice = this.utiles.choice(2);
        this.attack(year, enemies.get(choice-1));
    }




    public void chooseSpell(Year year, AbstractEnemy enemy, String type){
        int j = 2;
        System.out.println("1. I changed my mind");
        j = this.showSpells(this.getKnownSpells(), year, type, j);
        j = this.showSpells(this.getKnownSpells(), year, "none", j);
        int spell = this.utiles.choice(j);
        if (spell == 1) {
            this.attack(year, enemy);
        } else if (spell >= j) {
            System.out.println("Please enter a number between 1 and " + (j-1));
            this.chooseSpell(year, enemy, type);
        } else if (type.equals("attack")){
            this.getKnownSpells().get(spell-2).useSpellAttack(this, enemy);
        } else {
            this.getKnownSpells().get(spell-2).useSpellDefense(this, enemy);
        }
    }


    public void choosePotion(Year year, AbstractEnemy enemy, String type){
        int j = 2;
        System.out.println("1. I changed my mind");
        j = this.showPotions(this.getPotions(), year, type, j);
        j = this.showPotions(this.getPotions(), year, "none", j);
        int potion = this.utiles.choice(j);
        if (potion == 1) {
            this.attack(year, enemy);
        } else if (potion >= j) {
            System.out.println("Please enter a number between 1 and " + (j-1));
            this.choosePotion(year, enemy, type);
        } else if (type.equals("attack")){
            this.getPotions().get(potion-2).usePotionAttack(this, enemy);
        } else {
            this.getPotions().get(potion-2).usePotionDefense(this, enemy);
        }
    }




    public void attack(Year year, AbstractEnemy enemy){
        System.out.println("Do you want to use defense or attack ? \n1. Defense\n2. Attack");
        int choose = this.utiles.choice(2);
        String type = "";
        switch (choose) {
            case 1-> type = "defense";
            case 2 -> type = "attack";
            default -> System.out.println("An error occurred, please restart the game !");
        }
        System.out.println("Do you want to use potions or spells ? \n1. Potions\n2. Spells");
        int choice = this.utiles.choice(2);
        switch (choice) {
            case 1 -> this.choosePotion(year, enemy, type);
            case 2 -> this.chooseSpell(year, enemy, type);
            default -> System.out.println("An error occurred, please restart the game !");
        }
    }

}
