package com.isep.harrypotter;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class Enemy extends AbstractEnemy{
    public Enemy(String name, float hp, int maxHP, Year year, String advice) {

        super(name, hp, maxHP, year, advice);
        setStatus("OK");

    }

    public void createEnemyShadow(Year year){
        List<Spell> knownSpellsEnemy = new ArrayList<>();
        Spell attackShadows = new Spell("Increase of Fear", 15, "The fear it provokes make damages", 1, "attack", "damages", "none", 1);
        knownSpellsEnemy.add(attackShadows);
        this.setKnownSpells(knownSpellsEnemy);
    }

    public void createEnemyLock(Year year){
        List<Spell> knownSpellsEnemy = new ArrayList<>();
        Spell attackLock = new Spell("Celled", 0, "You can't pass unless you destroy or open the lock", 1, "none", "none", "none", 1);
        knownSpellsEnemy.add(attackLock);
        this.setKnownSpells(knownSpellsEnemy);
    }
    public void createEnemyRock(Year year){
        List<Spell> knownSpellsEnemy = new ArrayList<>();
        Spell attackRock = new Spell("Rock", 0, "You can't pass unless you destroy the rock or clear the way", 1, "none", "none", "none", 1);
        knownSpellsEnemy.add(attackRock);
        this.setKnownSpells(knownSpellsEnemy);
    }

}
