package com.isep.harrypotter.knowledge;

import com.isep.harrypotter.character.*;
import com.isep.harrypotter.character.Character;
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












    public void usePotionAttack(Wizard player, Character characterTwo){
        player.effectAttack(characterTwo, this.name, this.value, this.effectOne, player.getPercentPotion());
        player.effectAttack(characterTwo, this.name, this.value, this.effectTwo, player.getPercentPotion());
    }

    public void usePotionDefense(Wizard player, Character characterTwo){
        player.effectDefense(characterTwo, this.name, this.value, this.effectOne, player.getPercentPotion());
        player.effectDefense(characterTwo, this.name, this.value, this.effectTwo, player.getPercentPotion());
    }
}
