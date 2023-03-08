package com.isep.harrypotter;

public class House {
    enum Houses {
        Gryffindor,
        Hufflepuff,
        Ravenclaw,
        Slytherin

    }

    public static void SpecificationHouse(House.Houses house, float percentSpells, float percentPotion, float damage, int defensePoint){
        switch (house){
            case Ravenclaw -> percentSpells = 0.85F;
            case Slytherin -> damage = 1.2F;
            case Gryffindor -> defensePoint = 120;
            case Hufflepuff -> percentPotion = 0.85F;
            default -> System.out.println("An error occurred. Please restart the game");
        }
    }
}
