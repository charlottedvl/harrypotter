package com.isep.harrypotter.character;


import lombok.Getter;
import lombok.Setter;


import com.isep.harrypotter.scholarship.Year;
import com.isep.harrypotter.knowledge.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Boss extends AbstractEnemy {
    private int vulnerability = 0;
    public Boss(String name, float hp, int maxHP, Year year, String advice, float damage) {

        super(name, hp, maxHP, year, advice, damage);
        setStatus("OK");
    }

    //Every boss has the same attack
    public void createAttackBoss() {
        List<Spell> knownSpells = new ArrayList<>();
        Spell attack = new Spell("Stroke", 15, "Make huge damages", 1, "attack", "damages", "none");
        knownSpells.add(attack);
        this.setKnownSpells(knownSpells);
    }

    // Attack for Voldemort from year 7
    public void createAttackVoldemort() {
        List<Spell> knownSpells = new ArrayList<>();
        Spell avadaKedavra = new Spell("Avada Kedavra", 2000, "Kill immediately", 1, "attack", "damages", "none");
        knownSpells.add(avadaKedavra);
        Spell doloris = new Spell("Doloris", 40, "Make someone suffer and provokes damages", 1, "attack", "damages", "none");
        knownSpells.add(doloris);
        Spell sectumsempra = new Spell("Sectumsempra", 45F, "Your opponent bleed when you use this spell", 6, "attack", "damages", "none");
        knownSpells.add(sectumsempra);
        this.setKnownSpells(knownSpells);
    }

    //Attack for Bellatrix Lestrange
    public void createAttackBellatrix() {
        List<Spell> knownSpells = new ArrayList<>();
        Spell doloris = new Spell("Doloris", 40, "Make someone suffer and provokes damages", 1, "attack", "damages", "none");
        knownSpells.add(doloris);
        Spell sectumsempra = new Spell("Sectumsempra", 45F, "Your opponent bleed when you use this spell", 6, "attack", "damages", "none");
        knownSpells.add(sectumsempra);
        this.setKnownSpells(knownSpells);
    }


    //Each boss need to be hurt 3 times with the special action to be defeated
    public void checkVulnerability() {
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


    //Test the different bosses that has a special action with accio used to do special action during boss fight
    public void testBossAccio(Wizard player) {
        String boss = this.getName();
        if (boss.equalsIgnoreCase("Basilic") || boss.equalsIgnoreCase("Lord Voldemort and the Portekey")) {
            this.checkVulnerability();
            if (this.getVulnerability() == 3) {
                if (player.getHouse().equals("Gryffindor") && boss.equalsIgnoreCase("Basilic")) {
                    System.out.println("You grabbed the sword of Godrick Gryffindor and plant it on the Basilic's heart. It's dead.");
                } else if (boss.equalsIgnoreCase("Basilic")) {
                    System.out.println("You grabbed the sword of Godrick Gryffindor and plant it on the Basilic's heart. It's dead.");
                } else {
                    System.out.println("You attract the portekey. As you touch it, you are send to the labyrinth again. ");
                }
            }
        }
    }

    //Test the different bosses or spells used to do special action during boss fight
    public void testBoss(String name, Wizard player) {
        String boss = this.getName();
        if (boss.equalsIgnoreCase("Troll") && name.equalsIgnoreCase("Wingardium Leviosa")) {
            this.checkVulnerability();
        } else if (boss.equalsIgnoreCase("Death Eater") && name.equalsIgnoreCase("Sectumsempra")) {
            this.checkVulnerability();
        } else if (boss.equalsIgnoreCase("Death Eater") && player.getHouse().equals("Serpentard")) {
            System.out.println("The Death Eaters propose you to join them. The dark forces are waiting for your response. What do you want to do ?");
            System.out.println("1. Join them\n2. Stay with the bright forces");
            int validate = player.getUtiles().choice(2);
            switch (validate) {
                case 1 -> {
                    System.out.println("The Death Eaters welcome you with a cold face.\nYou wonder if you made the right choice or not.\nWhatever you think, it's too late to do anything... You help the Dark Lord to attack Hogwarts. ");
                    System.exit(0);
                }
                case 2 -> System.out.println("You have chosen to stay with the light forces. Fight the Dark Ones !");
            }
        }
    }
}
