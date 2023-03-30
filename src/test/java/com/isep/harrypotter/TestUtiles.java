package com.isep.harrypotter;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class TestUtiles extends Utiles {
    private int choice;

    public TestUtiles(int choice) {
        this.choice = choice;
    }

    @Override
    public int choice(int max) {
        return choice;
    }
}
