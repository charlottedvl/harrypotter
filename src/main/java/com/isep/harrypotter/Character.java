package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Getter @Setter
public abstract class Character {
    private String name;
    private List<Spell> knownSpells;
    private float hp;
    private int maxHP;
    private String status;
    private float percentSpells = 0.80F;
    private float damage = 1F;
    public Character(String name, float hp, int maxHP){
        List<Spell> knownSpells = new ArrayList<Spell>();
        this.name = name;
        this.knownSpells = knownSpells;
        this.hp = hp;
        this.maxHP = maxHP;
        this.status = "OK";
    }



    public float random(){
        Random random = new Random();
        float randomFloat = random.nextFloat();
        return randomFloat;
    }




    public void attack(Year year, Character characterTwo, Character characterThree) {
        boolean test = testStatus();
        if (this instanceof Wizard) {
            if (test == true) {
                ArrayList<AbstractEnemy> enemies = new ArrayList<AbstractEnemy>();
                enemies.add((AbstractEnemy) characterTwo);
                enemies.add((AbstractEnemy) characterThree);
                Wizard player = (Wizard) this;
                player.choiceEnemy(year, enemies);
            }
        } else if (this instanceof AbstractEnemy) {
            if (test == true){
                AbstractEnemy enemy = (AbstractEnemy) this;
                enemy.attack((Wizard) characterTwo);
            }
        }
    }

    public boolean testStatus(){
        String status = this.status;
        boolean test = true;
        switch (status){
            case "Confused1":
                this.setStatus("OK");
                test = false;
                break;
            case "Confused2":
                this.setStatus("Confused1");
                test = false;
                break;
            case "Reduced1" :
                this.setStatus("OK");
                this.setDamage(1F);
                if (this instanceof Wizard){
                    Wizard player = (Wizard) this;
                    if (player.getHouse().equals("Slytherin")){
                        this.setDamage(1.2F);
                    }
                }
                break;
        }
        return test;
    }

    public boolean isDead(){
        if (this.hp < 0){
            this.setHp(0);
            if (this instanceof AbstractEnemy){
                ((AbstractEnemy) this).setStatus("dead");
                System.out.println(this.name + " is dead.");
            } else {
                System.out.println("Oh no ! You are dead. You can't stop Voldemort anymore.\nYou can try again if you dare to !");
            }
            return true;
        } else {
            return false;
        }
    }

    public String[] findName(Character opponent){
        String[] names = new String[2];
        if (this instanceof Wizard){
            names[0] = "You have";
            names[1] = opponent.getName() + " has";
        } else {
            names[0] = this.name + " has";
            names[1] = "You have";
        }
        return names;
    }




    public void effectAttack(Character characterTwo, String name, int level, float value, String effect, float percent){
        float randomFloat = random();
        switch (effect){
            case "light"-> this.light(characterTwo, name, percent, randomFloat);
            case "confusion"-> this.confusion(characterTwo, level, name, randomFloat, percent);
            case "attire" -> this.attire(percent);
            case "reduce" -> this.reduce(characterTwo, name, value, randomFloat, percent);
            case "damages" -> this.damages(characterTwo, name, value, randomFloat, percent);
        }
    }
    public void effectDefense(Character characterTwo, String name, int level, float value, String effect, float percent){
        float randomFloat = random();
        switch (effect) {
            case "heal" -> heal(characterTwo, value, randomFloat, name, percent);
            case "increase" -> increase(percent);
            case "expecto" -> expecto(percent);
        }
    }

    public  void damages(Character opponent, String name, float value, float randomFloat, float percent){
        String [] names = this.findName(opponent);
        String nameCharacter = names[0];
        String opponentName = names[1];
        float damages = (this.getDamage()*value);
        if (percent >= randomFloat){
            if (name.equals("Wingardium Leviosa") && opponent.getName().equals("Troll")){
                Boss boss = (Boss) opponent;
                boss.checkVulnerability();
            } else {
                opponent.setHp(opponent.getHp()-damages);
                boolean isDead = opponent.isDead();
                if (isDead == false){
                    System.out.println(nameCharacter + " successfully use " + name +". " + opponentName + " " + opponent.getHp() + " HP.");
                }
            }
        } else if (randomFloat > 0.95F){
            this.setHp(this.getHp()-damages);
            boolean isDead = this.isDead();
            if (isDead == false){
                System.out.println(nameCharacter +" misuse " + name + " ! " + nameCharacter + " now " + this.getHp() + " HP.");
            } else {
                System.out.println(nameCharacter +" been defeated.");
            }
        } else {
            System.out.println(nameCharacter + " failed to use " + name + ". No damages have been done to anyone.");
        }
    }

    public void reduce(Character opponent, String name, float value, float randomFloat, float percent){
        String [] names = this.findName(opponent);
        String nameCharacter = names[0];
        String opponentName = names[1];
        if (randomFloat <= percent){
            opponent.setDamage(0.7F);
            opponent.setStatus("Reduced1");
            System.out.println(nameCharacter + " succeeded to use " + name + ". " + opponentName + " the damages reduced for one turn.");
        } else if (randomFloat >= 0.95F){
            this.setDamage(0.7F);
            this.setStatus("Reduced1");
            System.out.println(nameCharacter + " succeeded to use " + name + ". " + opponentName + " the damages reduced for one turn.");
        } else {
            System.out.println(nameCharacter + " failed to use " + name + ". Nothing happened.");
        }
    }

    public void attire(float percent){

    }

    public void expecto(float percent){

    }

    public void light(Character opponent, String name, float percent, float randomFloat){
        if (randomFloat <= percent) {
            if (opponent.getName() == "Shadow") {
                opponent.setHp(0F);
                opponent.setStatus("dead");
                System.out.println("The shadow disappears.");
            } else if (opponent.getName() == "Lock") {
                opponent.setHp(0F);
                opponent.setStatus("dead");
                System.out.println("You have succeeded to open the lock !");
            } else if (this instanceof AbstractEnemy && !name.equals("Allohomora")) {
                AbstractEnemy enemy = (AbstractEnemy) this;
                System.out.println("Advice to defeat this opponent : " + enemy.getAdvice());
            } else if (name.equals("Allohomora")){
                System.out.println(name + " succeeded but no target is available. Nothing happened");
            }
        } else {
            System.out.println(name + " failed. Nothing happened...");
        }
    }

    public void heal(Character opponent, float value, float randomFloat, String name, float percent){
        String [] names = this.findName(opponent);
        String nameCharacter = names[0];
        String opponentName = names[1];
        if (randomFloat <= percent){
            this.setHp(this.getHp() + value);
            System.out.println(nameCharacter + " succeeded to use " + name + ". " + nameCharacter + " been healed. It has now " + this.getHp() + " HP.");
        } else if (randomFloat > 0.95F){
            opponent.setHp(opponent.getHp() + value);
            System.out.println(nameCharacter + " failed to use " + name + ". " + opponentName + " been healed. It has now " + opponent.getHp() + " HP.");
        } else {
            System.out.println(name + " failed. Nothing happened...");
        }
    }

    public void confusion(Character opponent, int level, String name, float randomFloat, float percent){
        String [] names = this.findName(opponent);
        String nameCharacter = names[0];
        String opponentName = names[1];
        if (randomFloat <= percent){
            if (level == 1){
                opponent.setStatus("Confused1");
                System.out.println(nameCharacter + " use " + name + " that bring unconsciousness. " + opponentName + " been set out of the fight for one turn.");
            } else {
                opponent.setStatus("Confused2");
                System.out.println(nameCharacter + " cast a spell that bring unconsciousness. " + opponentName + " been set out of the fight for two turns.");
            }
        } else {
            if (level == 1){
                this.setStatus("Confused1");
                System.out.println(nameCharacter + " failed to cast a spell that bring unconsciousness. " + nameCharacter + " been set out of the fight for one turn.");
            } else {
                this.setStatus("Confused2");
                System.out.println(nameCharacter + " failed to cast a spell that bring unconsciousness. " + nameCharacter + " been set out of the fight for two turns.");
            }
        }
    }

    public void increase(float percent){
    }
}
