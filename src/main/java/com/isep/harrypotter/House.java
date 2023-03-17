package com.isep.harrypotter;

public class House {
    enum Houses {
        Gryffindor,
        Hufflepuff,
        Ravenclaw,
        Slytherin

    }

    public static void SpecificationHouse(House.Houses house, float percentSpells, float percentPotion, float damage, float hp, float maxHP){
        switch (house){
            case Ravenclaw -> percentSpells = percentSpells + 0.05F;
            case Slytherin -> damage = damage + 0.2F;
            case Gryffindor -> {
                hp = hp + 20F;
                maxHP = maxHP+20F;
            }
            case Hufflepuff -> percentPotion = percentPotion + 005F;
            default -> System.out.println("An error occurred. Please restart the game");
        }
    }
}
