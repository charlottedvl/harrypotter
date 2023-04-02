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

    //The progress of a fight
    public void fight(Wizard player,  Year year) {
        AbstractEnemy enemyOne = this.enemies.get(0);
        AbstractEnemy enemyTwo;
        if (this.enemies.size() > 1) { //There two enemies
            enemyTwo = this.enemies.get(1);
        } else { //There one enemy, we create a fake second one to avoid errors
            enemyTwo = new Enemy("Not An Enemy", 0, 0, year, "No need for an advice, it is already dead", 0F);
            enemyTwo.setStatus("dead");
        }
        while (player.getHp()>0 && (!enemyOne.getStatus().equalsIgnoreCase("dead") || !enemyTwo.getStatus().equalsIgnoreCase("dead") )) {
            player.choiceEnemy((ArrayList<AbstractEnemy>) this.enemies, year); //player plays
            if (!player.getStatus().equalsIgnoreCase("dead") && !enemyOne.getStatus().equalsIgnoreCase("dead")) {
                enemyOne.attack(player); //If not dead, enemy 1 plays
            }
            if (!player.getStatus().equalsIgnoreCase("dead") && !enemyTwo.getStatus().equalsIgnoreCase("dead")) {
                enemyTwo.attack(player); //If not dead, enemy 2 plays
            }
        }
        if (enemies.get(0).getName().equalsIgnoreCase("Dolores Ombrage")) { //If Ombrage, we test for the fireworks
            float random = player.random();
            if (random <= player.getPercentFireworks()) {
                enemies.get(0).setHp(0);
                enemies.get(0).setStatus("dead");
                System.out.println("You have found your fireworks ! You fire them and make a huge spectacle in the exam room. Dolores Ombrage is angry but the exam are cancelled.");
            }
        }
        if (Objects.equals(enemyOne.getStatus(), "dead") && Objects.equals(enemyTwo.getStatus(), "dead")) {
            System.out.println("The fight is over ! You have defeated your enemies"); //Both enemies are dead, you win
        } else if (player.getStatus().equalsIgnoreCase("dead")) { //You are dead, game over
            System.out.println("The Game is over.");
            System.out.println(player.getHp());
            System.exit(0);
        }
    }

}
