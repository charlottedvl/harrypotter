package com.isep.harrypotter.character;

import com.isep.harrypotter.knowledge.Spell;
import com.isep.harrypotter.scholarship.Year;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class Enemy extends AbstractEnemy {

    public Enemy(String name, float hp, int maxHP, Year year, String advice, float damage) {

        super(name, hp, maxHP, year, advice, damage);
        setStatus("OK");


    }

    //Create the attack of the lock (no damages, just the wizard can't pass)
    public void createEnemyLock() {
        List<Spell> knownSpellsEnemy = new ArrayList<>();
        Spell attackLock = new Spell("Celled", 0, "You can't pass unless you destroy or open the lock", 1, "attack", "none", "none");
        knownSpellsEnemy.add(attackLock);
        this.setKnownSpells(knownSpellsEnemy);
    }
    //Create the attack of the rock (no damages, just the wizard can't pass)
    public void createEnemyRock() {
        List<Spell> knownSpellsEnemy = new ArrayList<>();
        Spell attackRock = new Spell("Rock", 0, "You can't pass unless you destroy the rock or clear the way", 1, "attack", "none", "none");
        knownSpellsEnemy.add(attackRock);
        this.setKnownSpells(knownSpellsEnemy);
    }

    //All enemies that make damages have this attack
    public void createEnemyAttack() {
        List<Spell> knownSpellsEnemy = new ArrayList<>();
        Spell attack = new Spell("Attack", 15, "You can't pass unless you destroy the rock or clear the way", 1, "attack", "damages", "none");
        knownSpellsEnemy.add(attack);
        this.setKnownSpells(knownSpellsEnemy);
    }
}
