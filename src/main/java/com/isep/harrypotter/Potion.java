package com.isep.harrypotter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter @Setter
public class Potion {
    private String name;
    private float value;
    private String description;
    private int year;
    private String type;
    private String effectOne;
    private String effectTwo;
    private int level;











    public void usePotionAttack(Wizard player, Character characterTwo){
        player.effectAttack(characterTwo, this.name, this.level, this.value, this.effectOne, player.getPercentPotion());
        player.effectAttack(characterTwo, this.name, this.level, this.value, this.effectTwo, player.getPercentPotion());
    }

    public void usePotionDefense(Wizard player, Character characterTwo){
        player.effectDefense(characterTwo, this.name, this.level, this.value, this.effectOne, player.getPercentPotion());
        player.effectDefense(characterTwo, this.name, this.level, this.value, this.effectTwo, player.getPercentPotion());
    }
}
