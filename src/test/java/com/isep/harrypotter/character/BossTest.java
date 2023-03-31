package com.isep.harrypotter.character;


import com.isep.harrypotter.Utiles;
import com.isep.harrypotter.knowledge.Spell;
import com.isep.harrypotter.scholarship.Year;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BossTest {

    @Test
    public void testCreateAttackBoss() {
        Year year = new Year(7, "seventh", "name", "lieu", "advice");
        Boss boss = new Boss("Test Boss", 100, 20, year, "advice", 1F);
        boss.createAttackBoss();
        List<Spell> knownSpells = boss.getKnownSpells();
        assertEquals(1, knownSpells.size());
        Spell attack = knownSpells.get(0);
        assertEquals("Stroke", attack.getName());
        assertEquals(15, attack.getValue());
        assertEquals("Make huge damages", attack.getDescription());
        assertEquals(1, attack.getYear());
        assertEquals("attack", attack.getType());
        assertEquals("damages", attack.getEffectOne());
        assertEquals("none", attack.getEffectTwo());
    }

    @Test
    public void testCreateAttackVoldemort() {
        Year year = new Year(7, "seventh", "name", "lieu", "advice");
        Boss boss = new Boss("Test Boss", 100, 20, year, "advice", 1F);
        boss.createAttackVoldemort();
        List<Spell> knownSpells = boss.getKnownSpells();
        assertEquals(3, knownSpells.size());
        Spell avada = knownSpells.get(0);
        Spell doloris = knownSpells.get(1);
        Spell sectumsempra = knownSpells.get(2);

        assertEquals("Avada Kedavra", avada.getName());
        assertEquals(2000, avada.getValue());
        assertEquals("Kill immediately", avada.getDescription());
        assertEquals(1, avada.getYear());
        assertEquals("attack", avada.getType());
        assertEquals("damages", avada.getEffectOne());
        assertEquals("none", avada.getEffectTwo());

        assertEquals("Doloris", doloris.getName());
        assertEquals(40, doloris.getValue());
        assertEquals("Make someone suffer and provokes damages", doloris.getDescription());
        assertEquals(1, doloris.getYear());
        assertEquals("attack", doloris.getType());
        assertEquals("damages", doloris.getEffectOne());
        assertEquals("none", doloris.getEffectTwo());

        assertEquals("Sectumsempra", sectumsempra.getName());
        assertEquals(45, sectumsempra.getValue());
        assertEquals("Your opponent bleed when you use this spell", sectumsempra.getDescription());
        assertEquals(6, sectumsempra.getYear());
        assertEquals("attack", sectumsempra.getType());
        assertEquals("damages", sectumsempra.getEffectOne());
        assertEquals("none", sectumsempra.getEffectTwo());
    }

    @Test
    public void testCreateAttackBellatrix() {
        Year year = new Year(7, "seventh", "name", "lieu", "advice");
        Boss boss = new Boss("Test Boss", 100, 20, year, "advice", 1F);
        boss.createAttackBellatrix();
        List<Spell> knownSpells = boss.getKnownSpells();
        assertEquals(2, knownSpells.size());
        Spell doloris = knownSpells.get(0);
        Spell sectumsempra = knownSpells.get(1);


        assertEquals("Doloris", doloris.getName());
        assertEquals(40, doloris.getValue());
        assertEquals("Make someone suffer and provokes damages", doloris.getDescription());
        assertEquals(1, doloris.getYear());
        assertEquals("attack", doloris.getType());
        assertEquals("damages", doloris.getEffectOne());
        assertEquals("none", doloris.getEffectTwo());

        assertEquals("Sectumsempra", sectumsempra.getName());
        assertEquals(45, sectumsempra.getValue());
        assertEquals("Your opponent bleed when you use this spell", sectumsempra.getDescription());
        assertEquals(6, sectumsempra.getYear());
        assertEquals("attack", sectumsempra.getType());
        assertEquals("damages", sectumsempra.getEffectOne());
        assertEquals("none", sectumsempra.getEffectTwo());
    }

    @Test
    public void testCheckVulnerability() {
        Year year = new Year(7, "seventh", "name", "lieu", "advice");
        Boss boss = new Boss("Test Boss", 100, 20, year, "advice", 1F);
        boss.checkVulnerability();
        assertEquals(1, boss.getVulnerability());
        boss.checkVulnerability();
        assertEquals(2, boss.getVulnerability());
        boss.checkVulnerability();
        assertEquals(0f, boss.getHp(), 0.01);
        assertEquals("dead", boss.getStatus());
    }

    @Test
    public void testBossAccio(){
        Year year = new Year(7, "seventh", "name", "lieu", "advice");
        Boss boss = new Boss("Basilic", 100, 20, year, "advice", 1F);
        Boss boss2 = new Boss("Lord Voldemort and the Portekey", 100, 20, year, "advice", 1F);
        Utiles utiles = new Utiles();
        Wizard player = new Wizard(utiles, "Test", 100F, 100, 2F);
        boss.setVulnerability(2);
        boss.testBossAccio(player);
        assertEquals("dead", boss.getStatus());
        boss2.setVulnerability(2);
        boss2.testBossAccio(player);
        assertEquals("dead", boss2.getStatus());
    }

    @Test
    public void testBoss() {
        Year year = new Year(7, "seventh", "name", "lieu", "advice");
        Utiles utiles = new Utiles();
        Wizard player = new Wizard(utiles, "Test", 100F, 100, 2F);
        Boss troll = new Boss("Troll", 100, 20, year, "advice", 1F);
        Boss deathEater = new Boss("Death Eater", 100, 20, year, "advice", 1F);
        troll.testBoss("Wingardium Leviosa", player);
        assertEquals(1, troll.getVulnerability());
        deathEater.testBoss("Sectumsempra", player);
        assertEquals(1, deathEater.getVulnerability());
    }

}
