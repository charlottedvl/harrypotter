package com.isep.harrypotter;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Wizard extends Character{

    private Pet pet;
    private Wand wand;
    private House.Houses house;
    private List<Potion> potions;
    private float percentPotion = 0.80F;
    private float percentFireworks = 0.30F;
    private int defensePoint = 100;

    public Wizard(String name, Pet pet, Wand wand, House.Houses house, List<Spell> knownSpells, List<Potion> potions, float hp, int maxHP){
        super(name, knownSpells, hp, maxHP);
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.potions = potions;

    }

    public static void choiceEnemy(Wizard player, Year year, AbstractEnemy enemyOne, AbstractEnemy enemyTwo){
        List<AbstractEnemy> enemies = new ArrayList<>();
        if (enemyOne.getStatus() != "dead"){
            enemies.add(enemyOne);
        }
        if (enemyTwo.getStatus() != "dead"){
            enemies.add(enemyTwo);
        }
        System.out.println("Which enemy do you want to attack ?");
        System.out.println("1. " + enemies.get(0).getName());
        if (enemies.size() > 1){
            System.out.println("2. " + enemies.get(1).getName());
        }
        int choice = HelloApplication.choice(2);
        attack(player, year, enemies.get(choice-1));
    }

    public static void attack(Wizard player, Year year, AbstractEnemy enemy){
        System.out.println("Do you want to use potions or spells ? \n1. Potions\n2. Spells");
        int choice = HelloApplication.choice(2);
        switch (choice) {
            case 1:
                Potion.choosePotion(player, year, enemy);
                break;
            case 2:
                Spell.chooseSpell(player, year, enemy);
                break;
            default:
                System.out.println("An error occurred, please restart the game !");
                break;
        }
    }

}
