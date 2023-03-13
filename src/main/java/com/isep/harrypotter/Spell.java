package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter @Setter
public class Spell extends AbstractSpell{


    public Spell(String name, int damage, String description, int year, String type) {

        super(name, damage, description, year, type);
    }


    public static ArrayList<Spell> createSpells(){
        ArrayList<Spell> spells = new ArrayList<>();
        // We create the spells
        Spell lumos = new Spell("Lumos", 0, "Create a light at the end of your wand. Useful to see in the dark... and to reassure you", 1, "none");
        Spell allohomora = new Spell("Allohomora", 0, "Open any lock you want", 1, "none");
        Spell wingardium_Leviosa = new Spell("Wingardium Leviosa", 0, "Levitate any object, provided you pronounce the magic formula correctly", 1, "none");
        // We add them to the list
        spells.add(lumos);
        spells.add(allohomora);
        spells.add(wingardium_Leviosa);
        return spells;
    }



    public static Spell attendSpellClass(Year year, ArrayList<Spell> spells, Wizard player){
        System.out.println("You have chosen to attend the sorcery class");
        System.out.println("This year, you can learn one of the many spells below. Please enter the number of the spell you want to learn");
        int i=1;
        showSpells(spells, year, "attack", i);
        showSpells(spells, year, "defense", i);
        showSpells(spells, year, "none", i);
        int choice = HelloApplication.choice(spells.size());
        return spells.get(choice-1);
    }

    public static Spell searchSpell(String nameSpell, ArrayList<Spell> spells, Year year, Wizard player){
        while (true) {
            for (Spell spell : spells) {
                if (spell.getName().equalsIgnoreCase(nameSpell)) {
                    return spell;
                }
            }
            System.out.println("Please enter a valid spell");
            Spell spell = attendSpellClass(year, spells, player);
        }
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
                spells.remove(spell);
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


    public static void showSpells(List<Spell> spells, Year year, String type, int i){
        for (Spell spell : spells) {
            if (spell.getYear() <= year.getNumberYear() && spell.getType().equalsIgnoreCase(type)){
                System.out.println(i + ". " + spell.getName() + " : " + spell.getDescription());
                i++;
            }
        }
    }
    public static void useSpell(){

    }
}
