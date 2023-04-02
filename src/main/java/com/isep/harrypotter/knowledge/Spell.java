package com.isep.harrypotter.knowledge;


import com.isep.harrypotter.character.Character;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Spell extends AbstractSpell {

    public Spell(String name, float value, String description, int year, String type, String effectOne, String effectTwo) {

        super(name, value, description, year, type, effectOne, effectTwo);
    }

    ////Make effect for according to the defense spell used
    public void useSpellDefense(Character characterOne, Character characterTwo, float randomFloat) {
        characterOne.effectDefense(characterTwo, this.getName(), this.getValue(), this.getEffectOne(), characterOne.getPercentSpells(), randomFloat);
        characterOne.effectDefense(characterTwo, this.getName(), this.getValue(), this.getEffectTwo(), characterOne.getPercentSpells(), randomFloat);
    }


}
