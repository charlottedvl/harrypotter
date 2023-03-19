package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Getter @Setter
public class Spell extends AbstractSpell{

    private int level;
    public Spell(String name, float value, String description, int year, String type, String effectOne, String effectTwo, int level) {

        super(name, value, description, year, type, effectOne, effectTwo);
        this.level = level;
    }





    public void useSpellAttack(Character characterOne, Character characterTwo){
        characterOne.effectAttack(characterTwo, this.getName(), this.level, this.getValue(), this.getEffectOne(), characterOne.getPercentSpells());
        characterOne.effectAttack(characterTwo, this.getName(), this.level, this.getValue(), this.getEffectTwo(), characterOne.getPercentSpells());
    }
    public void useSpellDefense(Character characterOne, Character characterTwo){
        characterOne.effectDefense(characterTwo, this.getName(), this.level, this.getValue(), this.getEffectOne(), characterOne.getPercentSpells());
        characterOne.effectDefense(characterTwo, this.getName(), this.level, this.getValue(), this.getEffectTwo(), characterOne.getPercentSpells());
    }


}
