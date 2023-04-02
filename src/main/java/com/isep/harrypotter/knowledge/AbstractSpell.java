package com.isep.harrypotter.knowledge;

import com.isep.harrypotter.character.Character;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public abstract class AbstractSpell {
    private String name;
    private float value;
    private String description;
    private int year;
    private String type;
    private String effectOne;
    private String effectTwo;

    //Make effect for according to the attack spell used
    public void useSpellAttack(Character characterOne, Character characterTwo, float randomFloat) {
        characterOne.effectAttack(characterTwo, this.getName(), this.getValue(), this.getEffectOne(), characterOne.getPercentSpells(), randomFloat);
        characterOne.effectAttack(characterTwo, this.getName(), this.getValue(), this.getEffectTwo(), characterOne.getPercentSpells(), randomFloat);
    }
}

