package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Boss extends AbstractEnemy{
    private int vulnerability = 0;
    public Boss(String name, List<Spell> knownSpells, float hp, int maxHP, Year year, String advice) {

        super(name, knownSpells, hp, maxHP, year, advice);
        setStatus("OK");
    }

    public static Boss createTroll(Year year){
        List<Spell> knownSpellsTroll = new ArrayList<>();
        Spell attackTroll = new Spell("Stroke", 15, "Make huge damages", 1, "attack", "damages", "none", 1);
        knownSpellsTroll.add(attackTroll);
        Boss Troll = new Boss("Troll", knownSpellsTroll, 1000, 1000, year, "Use Wingardium Leviosa to make damages on his head");
        return Troll;
    }
    public static void vulnerability(Boss boss){
        boss.setVulnerability(boss.getVulnerability()+1);
        switch (boss.getVulnerability()){
            case 1:
                System.out.println("Well done ! Continue this way !");
                break;
            case 2:
                System.out.println("You have nearly defeated it !");
                break;
            case 3:
                boss.setHp(0F);
                boss.setStatus("dead");
                System.out.println("The "+ boss.getName() + " is knocked out ! Congrats");
                break;
        }
    }
}
