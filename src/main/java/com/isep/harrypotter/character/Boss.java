package com.isep.harrypotter.character;


import lombok.Getter;
import lombok.Setter;


import com.isep.harrypotter.scholarship.Year;
import com.isep.harrypotter.knowledge.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Boss extends AbstractEnemy{
    private int vulnerability = 0;
    public Boss(String name, float hp, int maxHP, Year year, String advice, float damage) {

        super(name, hp, maxHP, year, advice, damage);
        setStatus("OK");
    }

    public void createAttackBoss(){
        List<Spell> knownSpells = new ArrayList<>();
        Spell attack = new Spell("Stroke", 15, "Make huge damages", 1, "attack", "damages", "none");
        knownSpells.add(attack);
        this.setKnownSpells(knownSpells);
    }

    public void createAttackVoldemort(){
        List<Spell> knownSpells = new ArrayList<>();
        Spell avadaKedavra = new Spell("Avada Kedavra", 2000, "Kill immediately", 1, "attack", "damages", "none");
        knownSpells.add(avadaKedavra);
        Spell doloris = new Spell("Doloris", 40, "Make someone suffer and provokes damages", 1, "attack", "damages", "none");
        knownSpells.add(doloris);
        Spell sectumsempra = new Spell("Sectumsempra", 45F, "Your opponent bleed when you use this spell", 6, "attack", "damages", "none");
        knownSpells.add(sectumsempra);
        this.setKnownSpells(knownSpells);
    }

    public void createAttackBellatrix(){
        List<Spell> knownSpells = new ArrayList<>();
        Spell doloris = new Spell("Doloris", 40, "Make someone suffer and provokes damages", 1, "attack", "damages", "none");
        knownSpells.add(doloris);
        Spell sectumsempra = new Spell("Sectumsempra", 45F, "Your opponent bleed when you use this spell", 6, "attack", "damages", "none");
        knownSpells.add(sectumsempra);
        this.setKnownSpells(knownSpells);
    }

    public void checkVulnerability(){
        this.setVulnerability(this.getVulnerability()+1);
        switch (this.getVulnerability()) {
            case 1 -> System.out.println("Well done ! Continue this way !");
            case 2 -> System.out.println("You have nearly defeated it !");
            case 3 -> {
                this.setHp(0F);
                this.setStatus("dead");
                System.out.println("The " + this.getName() + " is knocked out ! Congrats");
            }
        }
    }


    public void testBossAccio() {
        String boss = this.getName();
        if (boss.equalsIgnoreCase("Basilic") || boss.equalsIgnoreCase("Lord Voldemort and the Portekey")){
            this.checkVulnerability();
        }
    }

    public void testBoss(String name){
        String boss = this.getName();
        if (boss.equalsIgnoreCase("Troll") && name.equalsIgnoreCase("Wingardium Leviosa")){
            this.checkVulnerability();
        } else if (boss.equalsIgnoreCase("Death Eater") && name.equalsIgnoreCase("Sectumsempra")){
            this.checkVulnerability();
        }
    }
}
