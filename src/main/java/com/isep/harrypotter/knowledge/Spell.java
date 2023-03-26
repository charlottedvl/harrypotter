package com.isep.harrypotter.knowledge;


import com.isep.harrypotter.character.*;
import com.isep.harrypotter.character.Character;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Spell extends AbstractSpell{

    public Spell(String name, float value, String description, int year, String type, String effectOne, String effectTwo) {

        super(name, value, description, year, type, effectOne, effectTwo);
    }






    public void useSpellDefense(Character characterOne, Character characterTwo){
        characterOne.effectDefense(characterTwo, this.getName(), this.getValue(), this.getEffectOne(), characterOne.getPercentSpells());
        characterOne.effectDefense(characterTwo, this.getName(), this.getValue(), this.getEffectTwo(), characterOne.getPercentSpells());
    }


}
