package com.isep.harrypotter;

public class Spell extends AbstractSpell{

    private String name;
    private int damage;
    private String description;
    enum SpellsYearOne{
        WingardiumLeviosa,
        Allohomora,
        Lumos
    }

    enum SpellsYearTwo{
        Accio,
        Reparo

    }
}
