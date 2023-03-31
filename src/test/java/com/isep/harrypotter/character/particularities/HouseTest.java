package com.isep.harrypotter.character.particularities;

import com.isep.harrypotter.TestUtiles;
import com.isep.harrypotter.Utiles;
import com.isep.harrypotter.character.Wizard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseTest {

    @Test
    public void testSpecificationsHouse() {
        Utiles utiles = new Utiles();
        Wizard player = new Wizard(utiles, "Test", 100F, 100, 2F);

        House ravenclaw = new House();
        ravenclaw.name = House.Houses.Ravenclaw;
        ravenclaw.specificationsHouse(player);
        assertEquals(0.90f, player.getPercentSpells(), 0.01, "Ravenclaw");

        House slytherin = new House();
        slytherin.name = House.Houses.Slytherin;
        slytherin.specificationsHouse(player);
        assertEquals(1.2f, player.getDamage(), 0.01, "Slytherin");

        House gryffindor = new House();
        gryffindor.name = House.Houses.Gryffindor;
        gryffindor.specificationsHouse(player);
        assertEquals(120, player.getHp(), "Gryffindor");

        House hufflepuff = new House();
        hufflepuff.name = House.Houses.Hufflepuff;
        hufflepuff.specificationsHouse(player);
        assertEquals(0.90f, player.getPercentPotion(), 0.01, "Hufflepuff");
    }

}
