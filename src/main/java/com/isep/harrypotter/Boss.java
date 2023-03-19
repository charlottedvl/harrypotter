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
    public Boss(String name, float hp, int maxHP, Year year, String advice) {

        super(name, hp, maxHP, year, advice);
        setStatus("OK");
    }

    public void createTroll(Year year){
        List<Spell> knownSpellsTroll = new ArrayList<>();
        Spell attackTroll = new Spell("Stroke", 15, "Make huge damages", 1, "attack", "damages", "none", 1);
        knownSpellsTroll.add(attackTroll);
        this.setKnownSpells(knownSpellsTroll);
    }
    public void checkVulnerability(){
        this.setVulnerability(this.getVulnerability()+1);
        switch (this.getVulnerability()){
            case 1:
                System.out.println("Well done ! Continue this way !");
                break;
            case 2:
                System.out.println("You have nearly defeated it !");
                break;
            case 3:
                this.setHp(0F);
                this.setStatus("dead");
                System.out.println("The "+ this.getName() + " is knocked out ! Congrats");
                break;
        }
    }
}
