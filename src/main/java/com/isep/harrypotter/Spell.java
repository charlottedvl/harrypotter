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


    public static ArrayList<Spell> createSpells(){
        ArrayList<Spell> spells = new ArrayList<>();
        // We create the spells
        Spell lumos = new Spell("Lumos", 0, "Create a light at the end of your wand. Useful to see in the dark... and to reassure you", 1);
        Spell allohomora = new Spell("Allohomora", 0, "Open any lock you want", 1);
        Spell wingardium_Leviosa = new Spell("Wingardium Leviosa", 0, "Levitate any object, provided you pronounce the magic formula correctly", 1);
        // We add them to the list
        spells.add(lumos);
        spells.add(allohomora);
        spells.add(wingardium_Leviosa);
        return spells;
    }



    public static String attendSpellClass(Year year, ArrayList<Spell> spells, Wizard player){
        System.out.println("You have chosen to attend the sorcery class");
        System.out.println("This year, you can learn one of the many spells below. Please enter the name of the spell you want to learn");
        int i = 1;
        for (Spell spell : spells) {
            if (spell.getYear() == year.getNumberYear()){
                System.out.println(i + ". " + spell.getName() + " : " + spell.getDescription());
                i++;
            }
        }
        Scanner scanner = new Scanner(System.in);
        String nameSpell = scanner.nextLine();
        return nameSpell;
    }

    public static Spell searchSpell(String nameSpell, ArrayList<Spell> spells, Year year, Wizard player){
        for (Spell spell : spells) {
            if (spell.getName().equals(nameSpell)) {
                return spell;
            }
        }
        System.out.println("An error occurred, please try again");
        attendSpellClass(year, spells, player);
        return null;
    }
    public static void learnSpell(Spell spell, Wizard player, Year year, ArrayList<Spell> spells){
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
                System.out.println("Please enter a valid number");
                learnSpell(spell, player, year, spells);
                break;
        }

    }

}
