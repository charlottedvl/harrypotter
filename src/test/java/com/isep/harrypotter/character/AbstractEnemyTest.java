package com.isep.harrypotter.character;


import com.isep.harrypotter.scholarship.Year;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class AbstractEnemyTest {
    private Enemy enemy;
    private Boss boss;

    @BeforeEach
    public void setup() {
        Year year = new Year(7, "seventh", "name", "lieu", "advice");
        enemy = new Enemy("Enemy", 100F, 100, year, "advice", 2F);
        enemy.createEnemyAttack();
        boss = new Boss("Boss", 100F, 100, year, "advice", 2F);
        boss.createAttackBoss();
    }

    @Test
    public void attackTest() {


    }
}
