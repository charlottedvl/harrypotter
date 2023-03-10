package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Spell extends AbstractSpell{


    public Spell(String name, int damage, String description, int year) {
        super(name, damage, description, year);
    }

    Spell lumos = new Spell("Lumos", 0, "Create a light at the end of your wand. Useful to see in the dark... and to reassure you", 1);
    Spell allohomora = new Spell("Allohomora", 0, "Open any lock you want", 1);
    Spell wingardium_Leviosa = new Spell("Wingardium Leviosa", 0, "Levitate any object, provided you pronounce the magic formula correctly", 1);

    public void createSpells(ArrayList<Spell> spells){
        spells.add(lumos);
        spells.add(allohomora);
        spells.add(wingardium_Leviosa);
    }



    public void attendSpellClass(Year year, ArrayList<Spell> Spells){
        System.out.println("You have chosen to attend the sorcery class");
        System.out.println("This year, you can learn one of the many spells below. Please enter the name of the spell you want to learn");
        int i = 1;
        for (Spell element : Spells) {
            if (element.getYear() == year){
                System.out.println(i + ". " + element.getName() + " : " + element.getDescription());
                i++;
            }
        }
    }


    public void learnSpell(Spell spell){

    }

}
