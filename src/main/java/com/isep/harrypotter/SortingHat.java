package com.isep.harrypotter;

import java.util.Random;

public class SortingHat {

    public static House.Houses SortingHouse() {
        House.Houses[] houses = House.Houses.values();
        int randomIndexHouse = new Random().nextInt(houses.length);
        House.Houses house = houses[randomIndexHouse];
        return house;
    }


}
