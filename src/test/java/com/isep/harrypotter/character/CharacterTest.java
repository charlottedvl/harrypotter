package com.isep.harrypotter.character;

import com.isep.harrypotter.Utiles;
import com.isep.harrypotter.scholarship.Year;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    public void testTestStatus() {
        Year year = new Year(7, "seventh", "name", "lieu", "advice");
        Wizard player = new Wizard(new Utiles(), "Test", 100F, 100, 2F);
        Enemy enemy = new Enemy("Death Eater", 800, 800, year, "Make damages to kill them !",6F);
        Boss boss = new Boss("Test Boss", 100, 20, year, "advice", 1F);

        player.setStatus("Confused1");
        assertFalse(player.testStatus(), "true wizard confused 1");
        assertEquals("OK", player.getStatus(), "Wizard confused1");

        player.setStatus("Confused2");
        assertFalse(player.testStatus(), "true wizard confused 2");
        assertEquals("Confused1", player.getStatus(), "Wizard confused2");

        player.setStatus("Reduced1");
        assertTrue(player.testStatus(), "false wizard reduced 1");
        assertEquals("OK", player.getStatus(), "Wizard reduced1");
        assertEquals(2.3F, player.getDamage(), 0.01);

        enemy.setStatus("Confused1");
        assertFalse(enemy.testStatus(), "enemy confused 1");
        assertEquals("OK", enemy.getStatus(), "enemy confused1");

        enemy.setStatus("Confused2");
        assertFalse(enemy.testStatus());
        assertEquals("Confused1", enemy.getStatus(), "enemy confused2");

        enemy.setStatus("Reduced1");
        assertTrue(enemy.testStatus());
        assertEquals("OK", enemy.getStatus(), "enemy reduced1");
        assertEquals(6.3F, enemy.getDamage(), 0.01);

        boss.setStatus("Confused1");
        assertFalse(boss.testStatus());
        assertEquals("OK", boss.getStatus(), "boss confused1");

        boss.setStatus("Confused2");
        assertFalse(boss.testStatus());
        assertEquals("Confused1", boss.getStatus(), "boss confused2");

        boss.setStatus("Reduced1");
        assertTrue(boss.testStatus());
        assertEquals("OK", boss.getStatus(), "boss reduced1");
        assertEquals(1.3F, boss.getDamage(), 0.01);

    }


}
