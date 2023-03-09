package com.isep.harrypotter;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Wizard extends Character{
    private String name;
    private Pet pet;
    private Wand wand;
    private House.Houses house;
    private List<Spell> knownSpells;
    private List<Potion> potions;
    float percentSpells;
    float percentPotion;
    float percentFireworks;
    int hp;
    int defensePoint;
    float damage;

















    public String getName() {
        return this.name;
    }

    public Pet getPet() {
        return this.pet;
    }

    public Wand getWand() {
        return this.wand;
    }

    public House.Houses getHouse() {
        return this.house;
    }

    public void defend(Wizard wizard){

    }
}
