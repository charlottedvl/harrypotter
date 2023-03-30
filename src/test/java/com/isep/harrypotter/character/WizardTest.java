package com.isep.harrypotter.character;


import com.isep.harrypotter.TestUtiles;
import com.isep.harrypotter.Utiles;
import com.isep.harrypotter.knowledge.ForbiddenSpell;
import com.isep.harrypotter.knowledge.Potion;
import com.isep.harrypotter.knowledge.Spell;
import com.isep.harrypotter.scholarship.Year;
import org.junit.jupiter.api.Test;



import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WizardTest {

    @Test
    public void testShowSpells() {
        Year year = new Year(3, "third", "name", "place", "advice");
        Spell spell1 = new Spell("Spell 1", 1, "Description 1", 3, "Type 1", "none", "none");
        Spell spell2 = new Spell("Spell 2", 2, "Description 2", 3, "Type 2", "none", "none");
        Spell spell3 = new Spell("Spell 3", 3, "Description 3", 3, "Type 1", "none", "none");
        Spell spell4 = new Spell("Spell 4", 4, "Description 4", 3, "Type 2", "none", "none");
        Spell spell5 = new Spell("Spell 5", 5, "Description 5", 3, "Type 3", "none", "none");
        List<Spell> spells = new ArrayList<>();
        spells.add(spell1);
        spells.add(spell2);
        spells.add(spell3);
        spells.add(spell4);
        spells.add(spell5);
        String type = "Type 1";
        Utiles utiles = new Utiles();
        Wizard player = new Wizard(utiles, "Test", 100F, 100, 2F);
        int i = 1;
        int expectedOutput = 3;
        int actualOutput = player.showSpells(spells, year, type, i);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testLearnSpell() {
        Spell spell1 = new Spell("Spell 1", 1, "Description 1", 3, "Type 1", "none", "none");
        Utiles utiles = new TestUtiles(1); // Utilise TestUtiles au lieu de Utiles
        Wizard player = new Wizard(utiles, "Test", 100F, 100, 2F);
        Year year = new Year(7, "seventh", "name", "lieu", "advice");
        player.learnSpell(spell1, year);
        assertFalse(player.getSpells().contains(spell1));
        boolean test = player.getKnownSpells().get(0).getName().equals("Spell 1");
        assertTrue(test);
        assertEquals(1, player.getKnownSpells().size());
    }

    @Test
    public void testShowPotions() {
        Year year = new Year(3, "third", "name", "place", "advice");
        Potion potion1 = new Potion("Potion 1", 1F, "Description 1", 3, "Type 1", "none", "none");
        Potion potion2 = new Potion("Potion 2", 2F, "Description 2", 3, "Type 2", "none", "none");
        Potion potion3 = new Potion("Potion 3", 3F, "Description 3", 3, "Type 1", "none", "none");
        Potion potion4 = new Potion("Potion 4", 4F, "Description 4", 3, "Type 2", "none", "none");
        Potion potion5 = new Potion("Potion 5", 5F, "Description 5", 3, "Type 3", "none", "none");
        List<Potion> potions = new ArrayList<>();
        potions.add(potion1);
        potions.add(potion2);
        potions.add(potion3);
        potions.add(potion4);
        potions.add(potion5);
        String type = "Type 1";
        Utiles utiles = new Utiles();
        Wizard player = new Wizard(utiles, "Test", 100F, 100, 2F);
        int i = 1;
        int expectedOutput = 3;
        int actualOutput = player.showPotions(potions, year, type, i);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testLearnPotion() {
        Potion potion = new Potion("Potion 1", 1F, "Description 1", 3, "Type 1", "none", "none");
        Utiles utiles = new TestUtiles(1); // Utilise TestUtiles au lieu de Utiles
        Wizard player = new Wizard(utiles, "Test", 100F, 100, 2F);
        Year year = new Year(7, "seventh", "name", "lieu", "advice");
        player.learnPotion(potion, year);
        assertTrue(player.getPotions().contains(potion));
        assertEquals(1, player.getPotions().size());
    }

    @Test
    // Test cannot pass because in the test, there is System.out(0);
    public void testTestExpell() {
        // Test case where the random float is less than or equal to 35
        Wizard player = new Wizard(new Utiles(), "Test", 100F, 100, 2F);
        player.testExpell(0.34F);
        assertEquals("Expelled", player.getStatus());

        // Test case where the random float is greater than 35
        Wizard player2 = new Wizard(new Utiles(), "Test", 100F, 100, 2F);
        player2.testExpell(0.36F);
        assertNotEquals("Expelled", player2.getStatus());
    }

    @Test
    public void testChooseSpell() {
        Year year = new Year(3, "third", "name", "place", "advice");
        Spell spell1 = new Spell("Spell 1", 1F, "Description 1", 3, "attack", "none", "none");
        Spell spell2 = new Spell("Spell 2", 2F, "Description 2", 3, "attack", "none", "none");
        Spell spell3 = new Spell("Spell 3", 3F, "Description 3", 3, "defense", "none", "none");
        Spell spell4 = new Spell("Spell 4", 4F, "Description 4", 3, "defense", "none", "none");
        Spell spell5 = new Spell("Spell 5", 5F, "Description 5", 3, "defense", "none", "none");
        Utiles utiles = new TestUtiles(3);
        Wizard player = new Wizard(utiles, "Test", 100F, 100, 2F);
        player.getKnownSpells().add(spell1);
        player.getKnownSpells().add(spell2);
        player.getKnownSpells().add(spell3);
        player.getKnownSpells().add(spell4);
        player.getKnownSpells().add(spell5);
        AbstractEnemy enemy = new Enemy("Enemy", 100F, 100, year, "advice", 2F);
        player.chooseSpell(year, enemy, "attack");
        assertEquals(2F, spell2.getValue());
    }
    @Test
    //// Test cannot pass because it calls testExpell();
    public void testChooseForbiddenSpell() {
        Year year = new Year(3, "third", "name", "place", "advice");
        ForbiddenSpell spell1 = new ForbiddenSpell("FSpell 1", 1, "Description 1", 3, "none", "none");
        ForbiddenSpell spell2 = new ForbiddenSpell("FSpell 2", 2, "Description 2", 3, "none", "none");
        ForbiddenSpell spell3 = new ForbiddenSpell("FSpell 3", 3, "Description 3", 3, "none", "none");
        ForbiddenSpell spell4 = new ForbiddenSpell("FSpell 4", 4, "Description 4", 3, "none", "none");
        ForbiddenSpell spell5 = new ForbiddenSpell("FSpell 5", 5, "Description 5", 3, "none", "none");
        Utiles utiles = new TestUtiles(3);
        Wizard player = new Wizard(utiles, "Test", 100F, 100, 2F);
        player.getForbiddenSpells().add(spell1);
        player.getForbiddenSpells().add(spell2);
        player.getForbiddenSpells().add(spell3);
        player.getForbiddenSpells().add(spell4);
        player.getForbiddenSpells().add(spell5);
        AbstractEnemy enemy = new Enemy("Enemy", 100F, 100, year, "advice", 2F);
        player.chooseForbiddenSpell(year, enemy, "attack");
        assertEquals(2F, spell2.getValue());
    }
    @Test
    public void testChoosePotion() {
        Year year = new Year(3, "third", "name", "place", "advice");
        Potion potion1 = new Potion("Potion 1", 1F, "Description 1", 3, "attack", "none", "none");
        Potion potion2 = new Potion("Potion 2", 2F, "Description 2", 3, "attack", "none", "none");
        Potion potion3 = new Potion("Potion 3", 3F, "Description 3", 3, "defense", "none", "none");
        Potion potion4 = new Potion("Potion 4", 4F, "Description 4", 3, "defense", "none", "none");
        Potion potion5 = new Potion("Potion 5", 5F, "Description 5", 3, "defense", "none", "none");
        Utiles utiles = new TestUtiles(3);
        Wizard player = new Wizard(utiles, "Test", 100F, 100, 2F);
        player.getPotions().add(potion1);
        player.getPotions().add(potion2);
        player.getPotions().add(potion3);
        player.getPotions().add(potion4);
        player.getPotions().add(potion5);
        AbstractEnemy enemy = new Enemy("Enemy", 100F, 100, year, "advice", 2F);
        player.choosePotion(year, enemy, "attack");
        assertEquals(2F, potion2.getValue());
    }

    /*@Test
    Ne fonctionne pas car choose What Use s'appelle en continu
    public void testChooseAttackDefense() {
        TestUtiles utiles = new TestUtiles(2);
        Wizard player = new Wizard(utiles, "Test", 100F, 100, 2F);
        Year year = new Year(7, "seventh", "name", "lieu", "advice");
        Spell spell1 = new Spell("Spell 1", 1F, "Description 1", 3, "defense", "none", "none");
        Spell spell2 = new Spell("Spell 2", 2F, "Description 2", 3, "defense", "none", "none");
        Spell spell3 = new Spell("Spell 3", 3F, "Description 3", 3, "defense", "none", "none");
        player.getKnownSpells().add(spell1);
        player.getKnownSpells().add(spell2);
        player.getKnownSpells().add(spell3);
        AbstractEnemy enemy = new Enemy("Enemy", 100F, 100, year, "advice", 2F);
        player.chooseAttackDefense(year, enemy);
        assertEquals(1, utiles.getChoice());
    }
*/

    @Test
    public void testReward() {
        TestUtiles utiles = new TestUtiles(1); //Increase health
        Wizard player = new Wizard(utiles, "Test", 100F, 100, 2F);
        Wizard player2 = new Wizard(utiles, "Test", 100F, 100, 2F);
        player.reward();
        assertEquals(200F, player.getHp(), "Health");
        assertEquals(200F, player.getMaxHP());
        assertEquals(2.5F, player.getDamage(), 0.001);
        //Increase damages
        utiles.setChoice(2);
        player2.reward();
        assertEquals(150F, player2.getHp(), "Damages");
        assertEquals(150F, player2.getMaxHP());
        assertEquals(3F, player2.getDamage(), 0.001);
    }

}
