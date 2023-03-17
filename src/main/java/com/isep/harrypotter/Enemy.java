package com.isep.harrypotter;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class Enemy extends AbstractEnemy{
    public Enemy(String name, List<Spell> knownSpells, float hp, int maxHP, Year year, String advice) {

        super(name, knownSpells, hp, maxHP, year, advice);
        setStatus("OK");

    }

    public static Enemy createEnemyShadow(Year year){
        List<Spell> knownSpellsEnemy = new ArrayList<>();
        Spell attackShadows = new Spell("Increase of Fear", 15, "The fear it provokes make damages", 1, "attack", "damages", "none", 1);
        knownSpellsEnemy.add(attackShadows);
        Enemy shadow = new Enemy("Shadow", knownSpellsEnemy, 1000, 1000, year, "Use something that create light to destroy it");
        return shadow;
    }

    public static Enemy createEnemyLock(Year year){
        List<Spell> knownSpellsEnemy = new ArrayList<>();
        Spell attackLock = new Spell("Celled", 0, "You can't pass unless you destroy or open the lock", 1, "none", "none", "none", 1);
        knownSpellsEnemy.add(attackLock);
        Enemy lock = new Enemy("Lock", knownSpellsEnemy, 70, 70, year, "Use a spell that can open lock to pass this adventure");
        return lock;
    }
    public static Enemy createEnemyRock(Year year){
        List<Spell> knownSpellsEnemy = new ArrayList<>();
        Spell attackRock = new Spell("Rock", 0, "You can't pass unless you destroy the rock or clear the way", 1, "none", "none", "none", 1);
        knownSpellsEnemy.add(attackRock);
        Enemy rock = new Enemy("Rock", knownSpellsEnemy, 30, 30, year, "Make damages to destroy it");
        return rock;
    }

}
