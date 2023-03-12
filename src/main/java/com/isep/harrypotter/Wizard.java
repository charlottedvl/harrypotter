package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;

@Getter @Setter
public class Wizard extends Character{

    private Pet pet;
    private Wand wand;
    private House.Houses house;
    private List<Spell> knownSpells;
    private List<Potion> potions;
    private float percentPotion = 0.75F;
    private float percentFireworks = 0.35F;
    private int defensePoint = 100;
    private float damage = 1F;

    public Wizard(String name, Pet pet, Wand wand, House.Houses house, List<Spell> knownSpells, List<Potion> potions, int hp){
        super(name, knownSpells, hp);
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knownSpells = knownSpells;
        this.potions = potions;

    }

    public static void attack(Wizard player, Year year){
        System.out.println("Do you want to use potions or spells ?");
        System.out.println("1. Potions");
        System.out.println("2. Spells");
        int choice = HelloApplication.choice(2, 1);
        int i =0 ;
        switch (choice) {
            case 1:
                System.out.println("0. I changed my mind");
                i = Potion.showPotions();
                if (i == 0) {
                    attack(player, year);
                } else {
                    Potion.usePotion();
                    break;
                }
            case 2:
                System.out.println("0. I changed my mind");
                i = Spell.showSpells(player.getKnownSpells(), year);
                if (i == 0) {
                    attack(player, year);
                } else {
                    Spell.useSpell();
                    break;
                }
            default:
                System.out.println("An error occurred, please restart the game");
                break;
        }
    }

}
