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

    public void defend(Wizard wizard){

    }
}
