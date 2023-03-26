package com.isep.harrypotter.character.particularities;
import java.util.Random;

import com.isep.harrypotter.character.Wizard;
public class House {
    Houses name;
    enum Houses {
        Gryffindor,
        Hufflepuff,
        Ravenclaw,
        Slytherin
    }
    public House(){
        this.name = House.Houses.values()[new Random().nextInt(House.Houses.values().length)];
    }

    public void specificationsHouse(Wizard player){
        Houses house = this.name;
        switch (house){
            case Ravenclaw -> player.setPercentSpells(0.90F);
            case Slytherin -> player.setDamage(1.2F);
            case Gryffindor -> player.setHp(120);
            case Hufflepuff -> player.setPercentPotion(0.90F);
            default -> System.out.println("An error occurred. Please restart the game");
        }
    }
}
