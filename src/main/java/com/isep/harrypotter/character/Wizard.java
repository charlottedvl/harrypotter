package com.isep.harrypotter.character;

import com.isep.harrypotter.knowledge.*;
import com.isep.harrypotter.character.particularities.*;
import com.isep.harrypotter.scholarship.*;
import com.isep.harrypotter.Utiles;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Getter @Setter
public class Wizard extends Character{

    private Pet pet;
    private Wand wand;
    private House house;
    private List<Potion> potions;
    private List<Spell> spells;
    private List<Spell> defenseKnownSpells;
    private List<ForbiddenSpell> forbiddenSpells;
    private List<Potion> allPotions;
    private float percentPotion = 0.80F;
    private float percentFireworks = 0.30F;
    private Utiles utiles;

    public Wizard(Utiles utiles, String name, float hp, int maxHP, float damage){
        super(name, hp, maxHP, damage);
        this.pet = Pet.values()[new Random().nextInt(Pet.values().length)];
        this.wand = new Wand();
        this.house = new House();
        this.potions = new ArrayList<>();
        setStatus("OK");
        this.spells = new ArrayList<>();
        this.forbiddenSpells = new ArrayList<>();
        this.defenseKnownSpells = new ArrayList<>();
        this.allPotions = new ArrayList<>();
        this.utiles = utiles;
    }


    public void attendSpellClass(Year year){
        System.out.println("You have chosen to attend the sorcery class");
        System.out.println("This year, you can learn one of the many spells below. Please enter the number of the spell you want to learn");
        int i=1;
        i = showSpells(this.spells, year, "", i);
        int choice = this.utiles.choice(this.spells.size());
        learnSpell(this.spells.get(choice-1), year);
    }

    public int showSpells(List<Spell> spells, Year year, String type, int i) {
        for (int y = 1; y<=7; y++){
            if (type.equals("")){
                for (Spell spell : spells) {
                    if (spell.getYear() <= year.getNumberYear()) {
                        if (spell.getYear() == y){
                            System.out.println(i + ". " + spell.getName() + " : " + spell.getDescription());
                            i++;
                        }
                    }
                }
            } else {
                for (Spell spell : spells) {
                    if (spell.getYear() <= year.getNumberYear() && spell.getType().equalsIgnoreCase(type)){
                        if (spell.getYear() == y) {
                            System.out.println(i + ". " + spell.getName() + " : " + spell.getDescription());
                            i++;
                        }
                    }
                }
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
                if (spell.getType().equalsIgnoreCase("defense")){
                    this.getDefenseKnownSpells().add(spell);
                } else {
                    this.getKnownSpells().add(spell);
                }
                this.spells.remove(spell);
                System.out.println("You have successfully learn " + spell.getName());
            }
            case 2 -> {
                System.out.println("Please choose another spell from the list");
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
        i = showPotions(this.allPotions, year, "", i);
        int choice = this.utiles.choice(this.allPotions.size());
        this.learnPotion(this.allPotions.get(choice-1), year);
    }

    public int showPotions(List<Potion> allPotions, Year year, String type, int i){
        if (type.equals("")){
            for (Potion potion : allPotions) {
                if (potion.getYear() <= year.getNumberYear()) {
                    System.out.println(i + ". " + potion.getName() + " : " + potion.getDescription());
                    i++;
                }
            }
        } else {
            for (Potion potion : allPotions) {
                if (potion.getYear() <= year.getNumberYear() && potion.getType().equalsIgnoreCase(type)){
                    System.out.println(i + ". " + potion.getName() + " : " + potion.getDescription());
                    i++;
                }
            }
        }return i;
    }
    public void learnPotion(Potion potion, Year year){
        System.out.println("Are you sur you want to learn " + potion.getName() + " ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int validate = this.utiles.choice(2);
        switch (validate) {
            case 1 -> {
                this.getPotions().add(potion);
                this.allPotions.remove(potion);
                System.out.println("You have successfully learn " + potion.getName());
            }
            case 2 -> {
                System.out.println("Please choose another spell from the list");
                this.attendPotionClass(year);
            }
            default -> {
                System.out.println("Please enter a valid number");
                this.learnPotion(potion, year);
            }
        }
    }




    public void choiceEnemy(Year year, ArrayList<AbstractEnemy> enemies){
        System.out.println("Which enemy do you want to target ?");
        int i = 1;
        if (!enemies.get(0).getStatus().equalsIgnoreCase("dead")){
            System.out.println(i + ". " + enemies.get(0).getName());
            i++;
        }
        if (enemies.size() > 1 && !enemies.get(1).getStatus().equals("dead")){
            System.out.println(i + ". " + enemies.get(1).getName());
        }
        int choice = this.utiles.choice(i);
        if (enemies.get(0).getStatus().equalsIgnoreCase("dead")){
            this.attack(year, enemies.get(choice));
        }else {
            this.attack(year, enemies.get(choice-1));
        }
    }




    public void chooseSpell(Year year, AbstractEnemy enemy, String type){
        int j = 2;
        System.out.println("1. I changed my mind");
        if (type.equalsIgnoreCase("attack")) {
            j = this.showSpells(this.getKnownSpells(), year,"attack", j);
        } else {
            j = this.showSpells(this.getDefenseKnownSpells(), year, "defense", j);
        }
        int spell = this.utiles.choice(j);
        float randomFloat = random();
        if (spell == 1) {
            this.attack(year, enemy);
        } else if (spell >= j) {
            System.out.println("Please enter a number between 1 and " + (j-1));
            this.chooseSpell(year, enemy, type);
        } else if (type.equals("attack")){
            this.getKnownSpells().get(spell-2).useSpellAttack(this, enemy, randomFloat);
        } else {
            this.getKnownSpells().get(spell-2).useSpellDefense(this, enemy, randomFloat);
        }
    }
    public void chooseForbiddenSpell(Year year, AbstractEnemy enemy, String type){
        System.out.println("Be careful : if you use those spells and you are noticed, you can be expelled from Hogwarts and finished at Azkaban !");
        int j = 2;
        System.out.println("1. I changed my mind");
        for (ForbiddenSpell forbiddenSpell : this.forbiddenSpells) {
            if (forbiddenSpell.getYear() <= year.getNumberYear()) {
                System.out.println(j + ". " + forbiddenSpell.getName() + " : " + forbiddenSpell.getDescription());
                j++;
            }
        }
        int spell = this.utiles.choice(j);
        float randomFloat = random();
        if (spell == 1) {
            this.attack(year, enemy);
        } else if (spell >= j) {
            System.out.println("Please enter a number between 1 and " + (j-1));
            this.chooseForbiddenSpell(year, enemy, type);
        } else {
            this.getForbiddenSpells().get(spell-2).useSpellAttack(this, enemy, randomFloat);
            this.testExpell();
        }
    }

    public void testExpell(){
        float test = random();
        if (test<= 35F){
            System.out.println("Someone saw you ! You are expelled from Hogwarts and are sent to Azkaban.\nYou should have been more careful...");
            System.out.println("The Game is over.");
            System.exit(0);
        } else {
            System.out.println("The forbidden spell has been use without anyone noticing... this time. Be careful with those spells !");
        }
    }


    public void choosePotion(Year year, AbstractEnemy enemy, String type){
        int j = 2;
        System.out.println("1. I changed my mind");
        j = this.showPotions(this.getPotions(), year, type, j);
        int potion = this.utiles.choice(j);
        float randomFloat = random();
        if (potion == 1) {
            this.attack(year, enemy);
        } else if (potion >= j) {
            System.out.println("Please enter a number between 1 and " + (j-1));
            this.choosePotion(year, enemy, type);
        } else if (type.equals("attack")){
            this.getPotions().get(potion-2).usePotionAttack(this, enemy, randomFloat);
        } else {
            this.getPotions().get(potion-2).usePotionDefense(this, enemy, randomFloat);
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
        System.out.println("Do you want to use potions or spells ? \n1. Potions\n2. Spells\n3. Forbidden Spells");
        int choice = this.utiles.choice(3);
        switch (choice) {
            case 1 -> this.choosePotion(year, enemy, type);
            case 2 -> this.chooseSpell(year, enemy, type);
            case 3 -> this.chooseForbiddenSpell(year, enemy, type);
            default -> System.out.println("An error occurred, please restart the game !");
        }
    }

    public void reward(){
        System.out.println("Congrats ! You have finished your year of scholarship. We are looking forward seeing you !");
        // Every year, you increase a little your damages and your health. You can choose one to increase more
        this.setHp(this.getHp()+50);
        this.setMaxHP(this.getMaxHP()+50);
        this.setDamage(this.getDamage()+0.5F);
        System.out.println("As a reward, you can choose to increase your health or your damages. What do you want to do ? \n1. Increase health\n2. Increase damages");
        int choice = this.utiles.choice(2);
        switch (choice) {
            case 1 -> {
                this.setHp(this.getHp() + 50);
                this.setMaxHP(this.getMaxHP() + 50);
                System.out.println("Your HP have been increased !");
            }
            case 2 -> {
                this.setDamage(this.getDamage() + 0.5F);
                System.out.println("Your damages have been increased !");
            }
            default -> {
                System.out.println("Please enter a valid number");
                this.reward();
            }
        }
    }

}
