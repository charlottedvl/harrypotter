package com.isep.harrypotter.knowledge;

import com.isep.harrypotter.character.Character;

public class ForbiddenSpell extends AbstractSpell{
    public ForbiddenSpell(String name, int damage, String description, int year, String effectOne, String effectTwo) {
        super(name, damage, description, year, "attack", effectOne, effectTwo);
    }


}
