package com.isep.harrypotter;

public class ForbiddenSpell extends AbstractSpell{
    public ForbiddenSpell(String name, int damage, String description, int year) {
        super(name, damage, description, year, "attack");
    }
}
