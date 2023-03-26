package com.isep.harrypotter.scholarship;

import com.isep.harrypotter.character.*;
import com.isep.harrypotter.knowledge.Spell;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter @Setter
public class Fight {
    private Year year;
    private List<AbstractEnemy> enemies;
    private String description;
    private int phase; // to know in which order the fights appear



    public void fight(Wizard player,  Year year){
        AbstractEnemy enemyOne = this.enemies.get(0);
        AbstractEnemy enemyTwo;
        if (this.enemies.size() > 1){
            enemyTwo = this.enemies.get(1);
        } else {
            ArrayList<Spell> knownSpells = new ArrayList<Spell>();
            enemyTwo = new Enemy("Not An Enemy", 0, 0, year, "No need for an advice, it is already dead", 0F);
            enemyTwo.setStatus("dead");
        }
        while (player.getHp()>0 && (enemyOne.getHp()>0 || enemyTwo.getHp()>0)){
            player.attack(year, enemyOne, enemyTwo);
            if (player.getStatus() != "dead" && enemyOne.getStatus() != "dead"){
                enemyOne.attack(year, player, enemyTwo);
            }
            if (player.getStatus() != "dead" && enemyTwo.getStatus() != "dead") {
                enemyTwo.attack(year, player, enemyOne);
            }
        }
        if (enemies.get(0).getName().equalsIgnoreCase("Dolores Ombrage")){
            float random = player.random();
            if (random <= player.getPercentFireworks()){
                enemies.get(0).setHp(0);
                enemies.get(0).setStatus("Dead");
                System.out.println("You have found your fireworks ! You fire them and make a huge spectacle in the exam room. Dolores Ombrage is angry but the exam are cancelled.");
            }
        }
        if (Objects.equals(enemyOne.getStatus(), "dead") && Objects.equals(enemyTwo.getStatus(), "dead")){
            System.out.println("The fight is over ! You have defeated your enemies");
        } else if (Objects.equals(player.getStatus(), "dead")){
            System.out.println("The Game is over.");
            System.out.println(player.getHp());
            System.exit(0);
        }

    }


}
