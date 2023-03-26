package com.isep.harrypotter.character.particularities;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter @Setter
public class Wand {
    private Core core;
    private int size;

    public Wand(){
        this.core = Core.values()[new Random().nextInt(Core.values().length)];
        this.size = new Random().nextInt(11) + 10;
    }
}
