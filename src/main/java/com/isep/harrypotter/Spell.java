package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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



    public String attendSpellClass(Year year, ArrayList<Spell> spells, Wizard player){
        System.out.println("You have chosen to attend the sorcery class");
        System.out.println("This year, you can learn one of the many spells below. Please enter the name of the spell you want to learn");
        int i = 1;
        for (Spell spell : spells) {
            if (spell.getYear() == year){
                System.out.println(i + ". " + spell.getName() + " : " + spell.getDescription());
                i++;
            }
        }
        Scanner scanner = new Scanner(System.in);
        String spell = scanner.nextLine();
        return spell;
    }

    public void learnSpell(Spell spell, Wizard player, Year year, ArrayList<Spell> spells){
        System.out.println("Are you sur you want to learn " + spell.getName() + " ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        Scanner scanner = new Scanner(System.in);
        int validate = scanner.nextInt();
        switch (validate){
            case 1 :
                player.getKnownSpells().add(spell);
                System.out.println("You have successfully learn " + spell.getName());
                break;
            case 2:
                System.out.println("Please choose another spell from the list");;
                attendSpellClass(year, spells, player);
                break;
            default :
                System.out.println("Please enter a valide number");
                learnSpell(spell, player, year, spells);
                break;
        }

    }

}
