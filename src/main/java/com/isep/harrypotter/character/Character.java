package com.isep.harrypotter.character;


import lombok.Getter;
import lombok.Setter;

import com.isep.harrypotter.knowledge.*;
import com.isep.harrypotter.scholarship.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Getter @Setter
public abstract class Character {
    private String name;
    private List<Spell> knownSpells;
    private float hp;
    private int maxHP;
    private String status;
    private float percentSpells = 0.80F;
    private float damage;
    private int vulnerability = 0;
    public Character(String name, float hp, int maxHP, float damage){
        List<Spell> knownSpells = new ArrayList<>();
        this.name = name;
        this.knownSpells = knownSpells;
        this.hp = hp;
        this.maxHP = maxHP;
        this.status = "OK";
        this.damage = damage;
    }



    public float random(){
        Random random = new Random();
        return random.nextFloat();
    }




    public void attack(Year year, Character characterTwo) {
        boolean test = testStatus();
        if (this instanceof Wizard) {
            if (test) {
                Wizard player = (Wizard) this;
                player.attack(year, characterTwo);
            }
        } else if (this instanceof AbstractEnemy) {
            if (test) {
                AbstractEnemy enemy = (AbstractEnemy) this;
                Wizard player = (Wizard) characterTwo;
                enemy.attack(player);
            }
        }
    }

    public boolean testStatus(){
        String status = this.status;
        boolean test = true;
        switch (status) {
            case "Confused1" -> {
                this.setStatus("OK");
                test = false;
            }
            case "Confused2" -> {
                this.setStatus("Confused1");
                test = false;
            }
            case "Reduced1" -> {
                this.setStatus("OK");
                this.setDamage(getDamage() + 0.3F);
            }
        }
        return test;
    }

    public boolean isDead(){
        if (this.hp <= 0){
            this.setHp(0);
            if (this instanceof AbstractEnemy){
                this.setStatus("dead");
                System.out.println(this.name + " is dead.");
            } else {
                System.out.println("Oh no ! You are dead. You can't stop Voldemort anymore.\nYou can try again if you dare to !");
                System.exit(0);
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




    public void effectAttack(Character characterTwo, String name, float value, String effect, float percent, float randomFloat){
        switch (effect){
            case "light"-> this.light(characterTwo, name, randomFloat, percent);
            case "confusion"-> this.confusion(characterTwo, name, value, randomFloat, percent);
            case "attire" -> this.attire(characterTwo, name, randomFloat, percent);
            case "reduce" -> this.reduce(characterTwo, name, randomFloat, percent);
            case "damages" -> this.damages(characterTwo, name, value, randomFloat, percent);
        }
    }
    public void effectDefense(Character characterTwo, String name, float value, String effect, float percent, float randomFloat){
        switch (effect) {
            case "heal" -> heal(characterTwo, value, randomFloat, name, percent);
            case "increase" -> increase(name, randomFloat, percent);
            case "expecto" -> expecto(characterTwo);
        }
    }

    public void damages(Character opponent, String name, float value, float randomFloat, float percent){
        String [] names = this.findName(opponent);
        String nameCharacter = names[0];
        String opponentName = names[1];
        float damages = (this.getDamage()*value);
        if (randomFloat <= percent){
            if (opponent instanceof Boss boss){
                boss.testBoss(name);
            } else {
                opponent.setHp(opponent.getHp()-damages);
                boolean isDead = opponent.isDead();
                if (!isDead){
                    System.out.println(nameCharacter + " successfully use " + name +". " + opponentName + " " + opponent.getHp() + " HP.");
                }
            }
        } else if (randomFloat >= 0.98F){
            this.setHp(this.getHp()-damages);
            boolean isDead;
            isDead = this.isDead();
            if (!isDead){
                System.out.println(nameCharacter +" misuse " + name + " ! " + nameCharacter + " now " + this.getHp() + " HP.");
            } else {
                System.out.println(nameCharacter +" been defeated.");
            }
        } else {
            System.out.println(nameCharacter + " failed to use " + name + ". No damages have been done to anyone.");
        }
    }

    public void reduce(Character opponent, String name, float randomFloat, float percent){
        String [] names = this.findName(opponent);
        String nameCharacter = names[0];
        String opponentName = names[1];
        if (randomFloat <= percent){
            opponent.setDamage(opponent.getDamage() - 0.3F);
            opponent.setStatus("Reduced1");
            System.out.println(nameCharacter + " succeeded to use " + name + ". " + opponentName + " the damages reduced for one turn.");
        } else if (randomFloat >= 0.95F){
            this.setDamage(this.getDamage()-0.3F);
            this.setStatus("Reduced1");
            System.out.println(nameCharacter + " succeeded to use " + name + ". " + opponentName + " the damages reduced for one turn.");
        } else {
            System.out.println(nameCharacter + " failed to use " + name + ". Nothing happened.");
        }
    }

    public void attire(Character opponent, String name, float randomFloat, float percent){
        String [] names = this.findName(opponent);
        String nameCharacter = names[0];
        if (randomFloat <= percent){
            if (opponent instanceof Boss boss) {
                boss.testBossAccio();
                System.out.println(nameCharacter + " succeeded to use " + name + ". ");
            } else {
                System.out.println(nameCharacter + " failed to find a valid target " + name + ". Nothing happened.");
            }
        } else {
            System.out.println("Nothing happened");
        }
    }

    public void expecto(Character opponent){
        if (opponent.getName().equals("dementor")){
            opponent.checkCount();
        } else {
            System.out.println("You succeeded at casting the spell but your enemies are invulnerable to this spell...");
        }
    }
    public void checkCount(){
        if (this.vulnerability <=2){
            this.setVulnerability(this.getVulnerability()+1);
            System.out.println("It works ! Your spell has damaged the enemies. Continue this way !");
        } else {
            setHp(0);
            setStatus("dead");
            System.out.println("Your enemies are defeated ! ");
        }
    }

    public void light(Character opponent, String name,float randomFloat, float percent){
        if (randomFloat <= percent) {
            if (opponent.getName().equalsIgnoreCase("Shadow")) {
                opponent.setHp(0F);
                opponent.setStatus("dead");
                System.out.println("The enemy disappears.");
            } else if (opponent.getName().equalsIgnoreCase("Lock") && name.equals("Allohomora")) {
                opponent.setHp(0F);
                opponent.setStatus("dead");
                System.out.println("You have succeeded to open the lock !");
            } else if (this instanceof AbstractEnemy enemy && !name.equals("Allohomora")) {
                System.out.println("Advice to defeat this opponent : " + enemy.getAdvice());
            } else if (name.equals("Allohomora")){
                System.out.println(name + " succeeded and the light shine bright...");
            }
        } else {
            System.out.println(name + " failed. Nothing happened...");
        }
    }

    public void heal(Character opponent, float value, float randomFloat, String name, float percent){
        String [] names = this.findName(opponent);
        String nameCharacter = names[0];
        String opponentName = names[1];
        float valueEffective = (this.getDamage()*value);
        if (randomFloat <= percent){
            this.setHp(this.getHp() + valueEffective);
            if (this.getHp() > this.getMaxHP()){
                this.setHp(this.getMaxHP());
            }
            System.out.println(nameCharacter + " succeeded to use " + name + ". " + nameCharacter + " been healed. It has now " + this.getHp() + " HP.");
        } else if (randomFloat > 0.95F){
            opponent.setHp(opponent.getHp() + value);
            if (opponent.getHp() > opponent.getMaxHP()){
                opponent.setHp(opponent.getMaxHP());
            }
            System.out.println(nameCharacter + " failed to use " + name + ". " + opponentName + " been healed. It has now " + opponent.getHp() + " HP.");
        } else {
            System.out.println(name + " failed. Nothing happened...");
        }
    }

    public void confusion(Character opponent, String name, float value, float randomFloat, float percent){
        String [] names = this.findName(opponent);
        String nameCharacter = names[0];
        String opponentName = names[1];
        if (randomFloat <= percent){
            opponent.setStatus("Confused2");
            System.out.println(nameCharacter + " cast a spell that bring unconsciousness. " + opponentName + " been set out of the fight for two turns.");
        } else {
            this.setStatus("Confused2");
            System.out.println(nameCharacter + " failed to cast a spell that bring unconsciousness. " + nameCharacter + " been set out of the fight for two turns.");
        }
    }

    public void increase(String name, float randomFloat, float percent){
        if (randomFloat <= percent) {
            switch (name) {
                case "Strengthening Solution" -> this.setDamage(this.getDamage() + 0.2F);
                case "Wit-Sharpening Potion" -> this.setPercentSpells(this.getPercentSpells() + 0.05F);
                case "Felix Felicis" -> {
                    //The character is a wizard
                    Wizard player = (Wizard) this;
                    player.setPercentSpells(this.getPercentSpells() + 0.05F);
                    player.setPercentPotion(player.getPercentPotion() + 0.05F);
                }
            }
            System.out.println("The use of " + name + "succeeded ! You have improved your performances");
        } else {
            System.out.println("The use of " + name + " failed. Nothing happened...");
        }
    }
}
