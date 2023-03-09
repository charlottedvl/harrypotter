package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Wizard extends Character{

    private String name;
    private Pet pet;
    private Wand wand;
    private House.Houses house;
    private List<Spell> knownSpells;
    private List<Potion> potions;
    private float percentSpells = 0.75F;
    private float percentPotion = 0.75F;
    private float percentFireworks = 0.35F;
    private int hp = 100;
    private int defensePoint = 100;
    private float damage = 1F;

    public Wizard(String name, Pet pet, Wand wand, House.Houses house, List<Spell> knownSpells, List<Potion> potions){
        this.name = name;
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knownSpells = knownSpells;
        this.potions = potions;
    }

}
