package com.isep.harrypotter;


import java.util.Random;

public class Wand {
    Core core;
    int size;

    public Wand(){
        this.core = Core.values()[new Random().nextInt(Core.values().length)];
        this.size = new Random().nextInt(11) + 10;
    }
}
