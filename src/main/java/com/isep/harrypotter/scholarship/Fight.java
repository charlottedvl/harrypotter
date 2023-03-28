package com.isep.harrypotter.scholarship;

import com.isep.harrypotter.character.*;
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
            enemyTwo = new Enemy("Not An Enemy", 0, 0, year, "No need for an advice, it is already dead", 0F);
            enemyTwo.setStatus("dead");
        }
        while (player.getHp()>0 && (!enemyOne.getStatus().equalsIgnoreCase("dead") || !enemyTwo.getStatus().equalsIgnoreCase("dead") )){
            player.choiceEnemy((ArrayList<AbstractEnemy>) this.enemies, year);
            if (!player.getStatus().equalsIgnoreCase("dead") && !enemyOne.getStatus().equalsIgnoreCase("dead")){
                enemyOne.attack(year, player);
            }
            if (!player.getStatus().equalsIgnoreCase("dead") && !enemyTwo.getStatus().equalsIgnoreCase("dead")) {
                enemyTwo.attack(year, player);
            }
        }
        if (enemies.get(0).getName().equalsIgnoreCase("Dolores Ombrage")){
            float random = player.random();
            if (random <= player.getPercentFireworks()){
                enemies.get(0).setHp(0);
                enemies.get(0).setStatus("dead");
                System.out.println("You have found your fireworks ! You fire them and make a huge spectacle in the exam room. Dolores Ombrage is angry but the exam are cancelled.");
            }
        }
        if (Objects.equals(enemyOne.getStatus(), "dead") && Objects.equals(enemyTwo.getStatus(), "dead")){
            System.out.println("The fight is over ! You have defeated your enemies");
        } else if (player.getStatus().equalsIgnoreCase("dead")){
            System.out.println("The Game is over.");
            System.out.println(player.getHp());
            System.exit(0);
        }

    }


}
