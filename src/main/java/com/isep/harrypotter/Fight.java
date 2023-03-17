package com.isep.harrypotter;

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

    public static ArrayList<Fight> createFightYearOne(Year year){
        //Enemies for first fight
        Enemy shadowOne = Enemy.createEnemyShadow(year);
        Enemy shadowTwo = Enemy.createEnemyShadow(year);
        List<AbstractEnemy> enemiesOne = new ArrayList<>();
        enemiesOne.add(shadowOne);
        enemiesOne.add(shadowTwo);
        Fight FOneYOne = new Fight(year, enemiesOne, "Oh no ! It seems that you are in trouble. In the dungeon, the shadows scares you. You become to be paranoid and hurt yourself. \nTry to reassure yourself", 1);
        //Enemies for second fight
        Enemy lock = Enemy.createEnemyLock(year);
        Enemy rock = Enemy.createEnemyRock(year);
        List<AbstractEnemy> enemiesTwo = new ArrayList<>();
        enemiesTwo.add(lock);
        enemiesTwo.add(rock);
        Fight FTwoYOne = new Fight(year, enemiesTwo, "When you enter deeper in the Dungeon, you see that the way is blocked by a rock and a door closed by a lock. \nClear the way to pass", 2);
        //Enemies for the Boss fight
        Boss troll = Boss.createTroll(year);
        List<AbstractEnemy> enemiesBoss = new ArrayList<>();
        enemiesBoss.add(troll);
        Fight FBoss = new Fight(year, enemiesBoss, "There is a HUUUUGE Troll on your way ! Make him inconscious. Be careful, he is insensible to potion", 3);
        //Create the list of fights for the first year
        ArrayList<Fight> fights = new ArrayList<>();
        fights.add(FOneYOne);
        fights.add(FTwoYOne);
        fights.add(FBoss);
        return fights;
    }
    public static void StartFightsOne(Year year, Wizard player){
        ArrayList<Fight> fightsOne = createFightYearOne(year);
        Fight firstFight = fightsOne.get(0);
        Fight secondFight = fightsOne.get(1);
        Fight bossFight = fightsOne.get(2);
        System.out.println(firstFight.getDescription());
        fight(player, firstFight.getEnemies(), year);
        System.out.println(secondFight.getDescription());
        fight(player, secondFight.getEnemies(), year);
        System.out.println(bossFight.getDescription());
        fight(player, bossFight.getEnemies(), year);
    }

    public static void fight(Wizard player, List<AbstractEnemy> enemies, Year year){
        AbstractEnemy enemyOne = enemies.get(0);
        AbstractEnemy enemyTwo;
        if (enemies.size() > 1){
            enemyTwo = enemies.get(1);
        } else {
            ArrayList<Spell> knownSpells = new ArrayList<>();
            enemyTwo = new Enemy("Not An Enemy", knownSpells, 0, 0, year, "No need for an advice, it is already dead");
            enemyTwo.setStatus("dead");
        }
        while (player.getHp()>0 && (enemyOne.getHp()>0 || enemyTwo.getHp()>0)){
            Character.attack(player, year, enemyOne, enemyTwo);
            if (player.getStatus() != "dead" && enemyOne.getStatus() != "dead"){
                Character.attack(enemyOne, year, player, enemyTwo);
            }
            if (player.getStatus() != "dead" && enemyTwo.getStatus() != "dead") {
                Character.attack(enemyTwo, year, player, enemyOne);
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

    public static void effectAttack(Character characterOne, Character characterTwo, String name, int level, float value, String effect, float percent){
        float randomFloat = Utiles.random(characterOne);
        switch (effect){
            case "light"-> light(characterTwo, characterTwo, name, percent);
            case "confusion"-> confusion(characterOne, characterTwo, level, name, randomFloat, percent);
            case "attire" -> attire(characterTwo, percent);
            case "reduce" -> reduce(characterOne, characterTwo, name, value, randomFloat, percent);
            case "damages" -> damages(characterOne, characterTwo, name, value, randomFloat, percent);
        }
    }
    public static void effectDefense(Character characterOne, Character characterTwo, String name, float value, String effect, float percent){
        float randomFloat = Utiles.random(characterOne);
        switch (effect) {
            case "heal" -> heal(characterOne, characterTwo, value, randomFloat, name, percent);
            case "increase" -> increase(characterOne, percent);
            case "expecto" -> expecto(characterTwo, percent);
        }
    }

    public static void damages(Character character, Character opponent, String name, float value, float randomFloat, float percent){
        String [] names = Character.findName(character, opponent);
        String nameCharacter = names[0];
        String opponentName = names[1];
        float damages = (character.getDamage()*value);
        if (character.getPercentSpells() >= randomFloat){
            if (name.equals("Wingardium Leviosa") && opponent.getName().equals("Troll")){
                Boss boss = (Boss) opponent;
                Boss.checkVulnerability(boss);
            } else {
                opponent.setHp(opponent.getHp()-damages);
                boolean isDead = Character.isDead(opponent);
                if (isDead == false){
                    System.out.println(nameCharacter + " successfully use " + name +". " + opponentName + " " + opponent.getHp() + " HP.");
                }
            }
        } else if (randomFloat > 0.95F){
            character.setHp(character.getHp()-damages);
            boolean isDead = Character.isDead(character);
            if (isDead == false){
                System.out.println(nameCharacter +" misuse " + name + " ! " + nameCharacter + " now " + character.getHp() + " HP.");
            } else {
                System.out.println(nameCharacter +" been defeated.");
            }
        } else {
            System.out.println(nameCharacter + " failed to use " + name + ". No damages have been done to anyone.");
        }
    }

    public static void reduce(Character character, Character opponent, String name, float value, float randomFloat, float percent){
        String [] names = Character.findName(character, opponent);
        String nameCharacter = names[0];
        String opponentName = names[1];
        if (randomFloat <= percent){
            opponent.setDamage(0.7F);
            opponent.setStatus("Reduced1");
            System.out.println(nameCharacter + " succeeded to use " + name + ". " + opponentName + " the damages reduced for one turn.");
        } else if (randomFloat >= 0.95F){
            character.setDamage(0.7F);
            character.setStatus("Reduced1");
            System.out.println(nameCharacter + " succeeded to use " + name + ". " + opponentName + " the damages reduced for one turn.");
        } else {
            System.out.println(nameCharacter + " failed to use " + name + ". Nothing happened.");
        }
    }

    public static void attire(Character character, float percent){

    }

    public static void expecto(Character character, float percent){

    }

    public static void light(Character character, Character opponent, String name, float percent){
        float randomFloat = Utiles.random(character);
        if (randomFloat <= character.getPercentSpells()) {
            if (opponent.getName() == "Shadow") {
                opponent.setHp(0F);
                opponent.setStatus("dead");
                System.out.println("The shadow disappears.");
            } else if (opponent.getName() == "Lock") {
                opponent.setHp(0F);
                opponent.setStatus("dead");
                System.out.println("You have succeeded to open the lock !");
            } else if (character instanceof AbstractEnemy && !name.equals("Allohomora")) {
                AbstractEnemy enemy = (AbstractEnemy) character;
                System.out.println("Advice to defeat this opponent : " + enemy.getAdvice());
            } else if (name.equals("Allohomora")){
                System.out.println(name + " succeeded but no target is available. Nothing happened");
            }
        } else {
            System.out.println(name + " failed. Nothing happened...");
        }
    }

    public static void heal(Character character, Character opponent, float value, float randomFloat, String name, float percent){
        String [] names = Character.findName(character, opponent);
        String nameCharacter = names[0];
        String opponentName = names[1];
        if (randomFloat <= character.getPercentSpells()){
            character.setHp(character.getHp() + value);
            System.out.println(nameCharacter + " succeeded to use " + name + ". " + nameCharacter + " been healed. It has now " + character.getHp() + " HP.");
        } else if (randomFloat > 0.95F){
            opponent.setHp(opponent.getHp() + value);
            System.out.println(nameCharacter + " failed to use " + name + ". " + opponentName + " been healed. It has now " + opponent.getHp() + " HP.");
        } else {
            System.out.println(name + " failed. Nothing happened...");
        }
    }

    public static void confusion(Character character, Character opponent, int level, String name, float randomFloat, float percent){
        String [] names = Character.findName(character, opponent);
        String nameCharacter = names[0];
        String opponentName = names[1];
        if (randomFloat <= character.getPercentSpells()){
            if (level == 1){
                opponent.setStatus("Confused1");
                System.out.println(nameCharacter + " use " + name + " that bring unconsciousness. " + opponentName + " been set out of the fight for one turn.");
            } else {
                opponent.setStatus("Confused2");
                System.out.println(nameCharacter + " cast a spell that bring unconsciousness. " + opponentName + " been set out of the fight for two turns.");
            }
        } else {
            if (level == 1){
                character.setStatus("Confused1");
                System.out.println(nameCharacter + " failed to cast a spell that bring unconsciousness. " + nameCharacter + " been set out of the fight for one turn.");
            } else {
                character.setStatus("Confused2");
                System.out.println(nameCharacter + " failed to cast a spell that bring unconsciousness. " + nameCharacter + " been set out of the fight for two turns.");
            }
        }
    }

    public static void increase(Character character, float percent){
    }
}
