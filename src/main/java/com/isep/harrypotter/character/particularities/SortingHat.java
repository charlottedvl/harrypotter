package com.isep.harrypotter.character.particularities;
import java.util.Random;

public class SortingHat {

    public House.Houses SortingHouse() {
        House.Houses[] houses = House.Houses.values();
        int randomIndexHouse = new Random().nextInt(houses.length);
        House.Houses house = houses[randomIndexHouse];
        return house;
    }


}
