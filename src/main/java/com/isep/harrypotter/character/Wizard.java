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
public class Wizard extends Character {

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

    public Wizard(String name, float hp, int maxHP, float damage) {
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
        this.utiles = new Utiles();
    }

    //How a spell class pass by
    public void attendSpellClass(Year year) {
        System.out.println("You have chosen to attend the sorcery class");
        System.out.println("This year, you can learn one of the many spells below. Please enter the number of the spell you want to learn");
        int i=1;
        i = showSpells(this.spells, year, "", i);
        int choice = this.utiles.choice(this.spells.size());
        System.out.println("Are you sur you want to learn " + this.spells.get(choice-1).getName() + " ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        learnSpell(this.spells.get(choice-1), year);
    }

    //How spells are displayed for the player
    public int showSpells(List<Spell> spells, Year year, String type, int i) {
        for (int y = 1; y<=7; y++) { // So that the spells are displayed in the same order as in the list
            for (Spell spell : spells) {
                if (spell.getYear() <= year.getNumberYear() && spell.getType().equalsIgnoreCase(type)) {
                    if (spell.getYear() == y) {
                        System.out.println(i + ". " + spell.getName() + " : " + spell.getDescription());
                        i++;
                    }
                }
            }
        } return i;
    }

    //How a spell is learned
    public void learnSpell(Spell spell, Year year) {
        int validate = this.utiles.choice(2);
        switch (validate) {
            case 1 -> { //You want to learn this spell
                if (spell.getType().equalsIgnoreCase("defense")) { //A defense spell
                    this.getDefenseKnownSpells().add(spell);
                } else {
                    this.getKnownSpells().add(spell); // An attack spell
                }
                this.spells.remove(spell); // Remove the spell from the list so that it isn't displayed the next time
                System.out.println("You have successfully learn " + spell.getName());
            }
            case 2 -> { //You don't want to learn this spell
                System.out.println("Please choose another spell from the list");
                attendSpellClass(year);
            }
            default -> {
                System.out.println("Please enter a valid number");
                learnSpell(spell, year);
            }
        }
    }

    //How a potion class pass by
    public void attendPotionClass(Year year) {
        System.out.println("You have chosen to attend the potion class");
        System.out.println("This year, you can learn one of the many potions below. Please enter the number of the potion you want to learn");
        int i = 1;
        i = showPotions(this.allPotions, year, "", i);
        int choice = this.utiles.choice(this.allPotions.size());
        System.out.println("Are you sur you want to learn " + this.allPotions.get(choice-1).getName() + " ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        this.learnPotion(this.allPotions.get(choice-1), year);
    }

    //How potions are displayed
    public int showPotions(List<Potion> allPotions, Year year, String type, int i) {
        for (Potion potion : allPotions) {
            if (potion.getYear() <= year.getNumberYear() && potion.getType().equalsIgnoreCase(type)){
                System.out.println(i + ". " + potion.getName() + " : " + potion.getDescription());
                i++;
            }
        } return i;
    }

    //How a potion is learned
    public void learnPotion(Potion potion, Year year) {
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

    //The wizard chooses his enemy at the beginning of his turn
    public void choiceEnemy(ArrayList<AbstractEnemy> enemies, Year year) {
        System.out.println("Which enemy do you want to target ?");
        int i = 1;
        if (!enemies.get(0).getStatus().equalsIgnoreCase("dead")) { //First enemy of the list is displayed if he isn't dead
            System.out.println(i + ". " + enemies.get(0).getName());
            i++;
        }
        if (enemies.size() > 1 && !enemies.get(1).getStatus().equals("dead")) { //Second enemy of the list is displayed if he isn't dead
            System.out.println(i + ". " + enemies.get(1).getName());
        }
        int choice = this.utiles.choice(i);
        if (enemies.get(0).getStatus().equalsIgnoreCase("dead")) { //If the first enemy is dead, it isn't displayed so the number is correct
            this.chooseAttackDefense(year, enemies.get(choice));
        } else { //If the first enemy isn't dead, it is displayed so the number is choice-1
            this.chooseAttackDefense(year, enemies.get(choice-1));
        }
    }

    //The wizard chooses to play a spell
    public void chooseSpell(Year year, AbstractEnemy enemy, String type){
        int j = 2;
        System.out.println("1. I changed my mind");
        if (type.equalsIgnoreCase("attack")) { //An attack spell
            j = this.showSpells(this.getKnownSpells(), year,"attack", j);
        } else { // A defense spell
            j = this.showSpells(this.getDefenseKnownSpells(), year, "defense", j);
        }
        int spell = this.utiles.choice(j);
        float randomFloat = random();
        if (spell == 1) {
            this.chooseWhatUse(year, enemy, type);
        } else if (spell >= j) { //Not a valid number
            System.out.println("Please enter a number between 1 and " + (j-1));
            this.chooseSpell(year, enemy, type);
        } else if (type.equals("attack")) { //Attack spell
            this.getKnownSpells().get(spell-2).useSpellAttack(this, enemy, randomFloat);
        } else { // Defense spell
            this.getKnownSpells().get(spell-2).useSpellDefense(this, enemy, randomFloat);
        }
    }

    //If the wizard chooses to use a forbidden spell
    public void chooseForbiddenSpell(Year year, AbstractEnemy enemy, String type) {
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
        if (spell == 1) { //Change his mind
            this.chooseWhatUse(year, enemy, type);
        } else if (spell >= j) { //Not a valid number
            System.out.println("Please enter a number between 1 and " + (j-1));
            this.chooseForbiddenSpell(year, enemy, type);
        } else {
            this.getForbiddenSpells().get(spell-2).useSpellAttack(this, enemy, randomFloat);
            float testExpell = random();
            this.testExpell(testExpell); //Test if the wizard is expelled or not
        }
    }

    //Test if the wizard is expelled or not
    public void testExpell(float testExpell) {
        if (testExpell <= 65F) { //The wizard is expelled
            this.setStatus("Expelled");
            System.out.println("Someone saw you ! You are expelled from Hogwarts and are sent to Azkaban.\nYou should have been more careful...");
            System.out.println("The Game is over.");
            System.exit(0);
        } else { //The wizard isn't expelled
            System.out.println("The forbidden spell has been use without anyone noticing... this time. Be careful with those spells !");
        }
    }

    //If the wizard chooses to use a potion
    public void choosePotion(Year year, AbstractEnemy enemy, String type) {
        int j = 2;
        System.out.println("1. I changed my mind");
        j = this.showPotions(this.getPotions(), year, type, j);
        int potion = this.utiles.choice(j);
        float randomFloat = random();
        if (potion == 1) { //Change his mind
            this.chooseAttackDefense(year, enemy);
        } else if (potion >= j) { //Not a valid number
            System.out.println("Please enter a number between 1 and " + (j-1));
            this.choosePotion(year, enemy, type);
        } else if (type.equals("attack")) { //An attack potion
            this.getPotions().get(potion-2).usePotionAttack(this, enemy, randomFloat);
        } else { //A defense potion
            this.getPotions().get(potion-2).usePotionDefense(this, enemy, randomFloat);
        }
    }

    //Choose to attack or defend
    public void chooseAttackDefense(Year year, AbstractEnemy enemy){
        System.out.println("Do you want to use defense or attack ? \n1. Attack\n2. Defense");
        int choose = this.utiles.choice(2);
        switch (choose) {
            case 1 -> this.chooseWhatUse(year, enemy, "attack");
            case 2 -> this.defend(year, enemy);
            default -> System.out.println("An error occurred, please restart the game !");
        }
    }

    public void defend(Year year, AbstractEnemy enemyOne){
        this.chooseWhatUse(year, enemyOne, "defense");
    }

    //Make the wizard choose what he wants to use
    public void chooseWhatUse(Year year, AbstractEnemy enemy, String type){
        System.out.println("Do you want to use potions or spells ? \n1. Potions\n2. Spells\n3. Forbidden Spells");
        int choice = this.utiles.choice(3);
        switch (choice) {
            case 1 -> this.choosePotion(year, enemy, type);
            case 2 -> this.chooseSpell(year, enemy, type);
            case 3 -> this.chooseForbiddenSpell(year, enemy, type);
            default -> System.out.println("An error occurred, please restart the game !");
        }
    }

    public void reward() {
        System.out.println("Congrats ! You have finished your year of scholarship. We are looking forward seeing you !");
        // Every year, you increase a little your damages and your health. You can choose one to increase more
        this.setHp(this.getHp()+50);
        this.setMaxHP(this.getMaxHP()+50);
        this.setDamage(this.getDamage()+0.5F);
        System.out.println("As a reward, you can choose to increase your health or your damages. What do you want to do ? \n1. Increase health\n2. Increase damages");
        int choice = this.utiles.choice(2);
        switch (choice) {
            case 1 -> { //Increase health
                this.setHp(this.getHp() + 50);
                this.setMaxHP(this.getMaxHP() + 50);
                System.out.println("Your HP have been increased !");
            }
            case 2 -> { //Increase damages
                this.setDamage(this.getDamage() + 0.5F);
                System.out.println("Your damages have been increased !");
            }
            default -> { //Not a valid number
                System.out.println("Please enter a valid number");
                this.reward();
            }
        }
    }

}
