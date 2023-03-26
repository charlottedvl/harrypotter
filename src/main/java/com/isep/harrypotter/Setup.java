package com.isep.harrypotter;

import com.isep.harrypotter.character.AbstractEnemy;
import com.isep.harrypotter.character.Boss;
import com.isep.harrypotter.character.Enemy;
import com.isep.harrypotter.character.Wizard;
import com.isep.harrypotter.knowledge.*;
import com.isep.harrypotter.scholarship.Fight;
import com.isep.harrypotter.scholarship.Year;

import java.util.ArrayList;
import java.util.List;

public class Setup {

    public void createSpells(ArrayList<Spell> spells){
        Spell incendio = new Spell("Incendio", 40F, "Make a jet of fire to make huge damages to your opponent", 2, "attack", "light", "damages");
        Spell expelliarmus = new Spell("Expelliarmus", 10F, "Disarm an opponent that can't make any damages for a small time", 2, "attack", "confusion", "damages");
        Spell glacius = new Spell("Glacius", 40F, "Freeze the blood of your enemy to make damages", 3, "attack", "damages", "none");
        Spell confringo = new Spell("Confringo", 50F, "Make things explode", 6, "attack", "light", "damages");
        Spell sectumsempra = new Spell("Sectumsempra", 45F, "Your opponent bleed when you use this spell", 6, "attack", "damages", "none");
        Spell accio = new Spell("Accio", 0F, "Attract objects", 2, "attack", "attire", "none");
        Spell lumos = new Spell("Lumos", 0F, "Create a light at the end of your wand. Useful to see in the dark... and to reassure you", 1, "none", "light", "none");
        Spell allohomora = new Spell("Allohomora", 0F, "Open any lock you want", 1, "none", "light", "none");
        Spell wingardiumLeviosa = new Spell("Wingardium Leviosa", 30F, "Levitate any object, provided you pronounce the magic formula correctly", 1, "none", "damages", "none");
        Spell expecto = new Spell("Expecto Patronum", 0F, "Send away dementors", 3, "defense", "expecto", "none");
        Spell reducto = new Spell("Reducto", 0F, "Reduce the size of an opponent. It makes less damages for two turns", 3, "defense", "reduce", "none");
        Spell stupefy = new Spell("Stupefy", 20F, "Immobilize the enemy", 4, "defense", "confusion", "damages");
        Spell episkey = new Spell("Episkey", 0F, "Heal your injuries", 5, "defense", "expecto", "none");
        spells.add(wingardiumLeviosa);
        spells.add(lumos);
        spells.add(allohomora);
        spells.add(incendio);
        spells.add(expelliarmus);
        spells.add(accio);
        spells.add(glacius);
        spells.add(expecto);
        spells.add(reducto);
        spells.add(stupefy);
        spells.add(episkey);
        spells.add(confringo);
        spells.add(sectumsempra);
    }


    public void createForbiddenSpell(ArrayList<ForbiddenSpell> forbiddenSpells){
        ForbiddenSpell avadaKedavra = new ForbiddenSpell("Avada Kedavra", 100000, "Kill immediately", 1, "damages", "none");
        forbiddenSpells.add(avadaKedavra);
        ForbiddenSpell doloris = new ForbiddenSpell("Doloris", 60, "Make someone suffer and provokes damages", 1, "damages", "none");
        forbiddenSpells.add(doloris);
        ForbiddenSpell imperio = new ForbiddenSpell("Imperio", 30, "Your opponent bleed when you use this spell", 6,  "confusion", "damages");
        forbiddenSpells.add(imperio);
    }

    public void createAllPotions(ArrayList<Potion> allPotions){
        Potion forgetfulness = new Potion ("Forgetfulness Potion", 0F, "Make your opponent lose memory. it increase confusion, useful when you don't want your enemy to attack !", 1, "attack", "confusion", "none");
        Potion fire  = new Potion ("Fire Potion", 30F, "Create a huge fire that burn enemies and light up the place", 1, "attack", "light", "damages");
        Potion wiggenweld = new Potion ("Wiggenweld Potion", 10F, "A potion that help you heal from your injuries", 1, "defense", "heal", "none");
        Potion strengtheningSolution = new Potion("Strengthening Solution ", 0F, "Increase your damages", 2, "defense", "increase", "none");
        Potion confusingConcoction = new Potion("Confusing Concoction", 0F, "Your enemies are confused and don't attack you for two turn", 3, "attack", "confusion", "none");
        Potion undetectablePoisons  = new Potion("Undetectable Poisons", 30F, "A powerful poison touch your enemies and makes damages", 3, "attack", "damages", "none");
        Potion WitSharpeningPotion = new Potion("Wit-Sharpening Potion", 0F, "Increase your chance to succeeded to cast spells", 4, "defense", "increase", "none");
        Potion skeleGro = new Potion("Skele-Gro", 25F, "Help you to restore your bones when they are broken", 4, "defense", "heal", "none");
        Potion erumpentPotion = new Potion("Erumpent Potion", 40F, "Explode when the potion touches enemies", 5, "attack", "damages", "none");
        Potion amortentia = new Potion("Amortentia", 0F, "Charm your enemy - even a boss ! - so that he doesn't make damages", 6, "attack", "confusion", "none");
        Potion felixFelicis  = new Potion("Felix Felicis", 0F, "Improve your chance to succeeded anything you do", 6, "defense", "increase", "none");
        Potion garrottingGas  = new Potion("Garrotting Gas", 20F, "Spread a gaz that make damages to your enemy but also make him a little confused", 7, "attack", "confusion", "damages");
        allPotions.add(forgetfulness);
        allPotions.add(fire);
        allPotions.add(wiggenweld);
        allPotions.add(strengtheningSolution);
        allPotions.add(confusingConcoction);
        allPotions.add(undetectablePoisons);
        allPotions.add(WitSharpeningPotion);
        allPotions.add(skeleGro);
        allPotions.add(erumpentPotion);
        allPotions.add(amortentia);
        allPotions.add(felixFelicis);
        allPotions.add(garrottingGas);
     }


     public ArrayList<Year> setupYears(){
         ArrayList<Year> years = new ArrayList<Year>();
         Year yearOne = new Year(1, "first", "The Philosopher's Stone", "Dungeon's toilets", "We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Wingardium Leviosa. ");
         years.add(yearOne);
         Year yearTwo = new Year(2, "second", "The Chamber of Secret", "Chamber of Secret", "We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Accio. ");
         years.add(yearTwo);
         Year yearThree = new Year(3, "third", "The Prisoner of Azkaban", "Lake in the Forbidden Forrest", "We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Expecto Patrunum. ");
         years.add(yearThree);
         Year yearFour = new Year(4, "fourth", "The Goblet of Fire", "Little Hangleton Cemetery", "Learn as many things as you can to survive the competition");
         years.add(yearFour);
         Year yearFive = new Year(5, "fifth", "The Order of Phoenix", "Hogwarts exam room", "Learn as many things as you can to succeed in your HOWL");
         years.add(yearFive);
         Year yearSix = new Year(6, "sixth", "The Half-Blood Prince", "Astronomy tower", "We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Sectumsempra. ");
         years.add(yearSix);
         Year yearSeven = new Year(7, "seventh", "The Deathly Hallows", "Hogwarts", "We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Expelliarmus. ");
         years.add(yearSeven);
         return years;
     }
    public ArrayList<Fight> createFightYearOne(Year year){
        //Enemies for first fight
        Enemy shadowOne = new Enemy("Shadow", 200, 200, year, "Use something that create light to destroy it", 1F);
        shadowOne.createEnemyAttack(year);
        Enemy shadowTwo = new Enemy("Shadow", 200, 200, year, "Use something that create light to destroy it", 1F);
        shadowTwo.createEnemyAttack(year);
        List<AbstractEnemy> enemiesOne = new ArrayList<>();
        enemiesOne.add(shadowOne);
        enemiesOne.add(shadowTwo);
        Fight FOneYOne = new Fight(year, enemiesOne, "Oh no ! It seems that you are in trouble. In the dungeon, the shadows scares you. You become to be paranoid and hurt yourself. \nTry to reassure yourself", 1);
        //Enemies for second fight
        Enemy lock = new Enemy("Lock",  70, 70, year, "Use a spell that can open lock to pass this adventure", 1F);
        lock.createEnemyLock(year);
        Enemy rock = new Enemy("Rock",  30, 30, year, "Make damages to destroy it", 1F);
        rock.createEnemyRock(year);
        List<AbstractEnemy> enemiesTwo = new ArrayList<>();
        enemiesTwo.add(lock);
        enemiesTwo.add(rock);
        Fight FTwoYOne = new Fight(year, enemiesTwo, "When you enter deeper in the Dungeon, you see that the way is blocked by a rock and a door closed by a lock. \nClear the way to pass", 2);
        //Enemies for the Boss fight
        Boss troll = new Boss("Troll", 1000, 1000, year, "Use Wingardium Leviosa to make damages on his head", 1F);
        troll.createAttackBoss(year);
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

    public ArrayList<Fight> createFightYearTwo(Year year){
        //Enemies for first fight
        Enemy rival = new Enemy("Your rival", 150, 150, year, "Make him KO or disarm him", 2F);
        rival.createEnemyAttack(year);
        List<AbstractEnemy> enemiesOne = new ArrayList<>();
        enemiesOne.add(rival);
        Fight FOneYTwo = new Fight(year, enemiesOne, "The year pass by and many disappearances happen. The professors suspect the Chamber of Secret to be open. They decide to set up a duel between students. You are chosen against your principal rival. \nDon't kill your opponent or you'll be expel ! ", 1);
        //Enemies for second fight
        Enemy spidersOne = new Enemy("Spiders",  120, 120, year, "Defeat them ! Spiders flee when they are in the light", 1.5F);
        spidersOne.createEnemyAttack(year);
        Enemy spidersTwo = new Enemy("Spiders",  120, 120, year, "Defeat them ! Spiders flee when they are in the light", 1.5F);
        spidersTwo.createEnemyAttack(year);
        List<AbstractEnemy> enemiesTwo = new ArrayList<>();
        enemiesTwo.add(spidersOne);
        enemiesTwo.add(spidersTwo);
        Fight FTwoYTwo = new Fight(year, enemiesTwo, "You have found the access to the Chamber of Secret ! While you go down in the tunnels, you are sent into a spiders' nest. You need to pass them !", 2);
        //Enemies for the Boss fight
        Boss basilic = new Boss("Basilic", 2000, 2000, year, "Use accio two times to bring to you fangs and plant them into Tom Jedusor's diary. If you are part of Gryffindor, you can use the sword using accio.", 2F);
        basilic.createAttackBoss(year);
        List<AbstractEnemy> enemiesBoss = new ArrayList<>();
        enemiesBoss.add(basilic);
        Fight FBoss = new Fight(year, enemiesBoss, "You have entered the Chamber of Secret. Oh no ! Your are confronted to a Basilic that want to eat you ! The only way to defeat it is destroying the diary in front of you.", 3);
        //Create the list of fights for the first year
        ArrayList<Fight> fights = new ArrayList<>();
        fights.add(FOneYTwo);
        fights.add(FTwoYTwo);
        fights.add(FBoss);
        return fights;
    }


    public ArrayList<Fight> createFightYearThree(Year year){
        //Enemies for first fight
        Enemy buckhead  = new Enemy("Buckbead", 300, 300, year, "Use all your spell to make huge damages and defeat it. You will need to protect your from its damages : confuse it !", 3F);
        buckhead.createEnemyAttack(year);
        List<AbstractEnemy> enemiesOne = new ArrayList<>();
        enemiesOne.add(buckhead);
        Fight FOneYThree = new Fight(year, enemiesOne, "One of the test of the Goblet of Fire is to defeat a dragon.\nWhen you hear this information, your are frightened. Use all of your knowledge to defeat it !", 1);
        //Enemies for second fight
        Enemy werewolf = new Enemy("Werewolf",  250, 250, year, "You need to confuse or freeze it to flee. You can choose to attack him but it is risky as it makes huge damages", 2.5F);
        werewolf.createEnemyAttack(year);
        List<AbstractEnemy> enemiesTwo = new ArrayList<>();
        enemiesTwo.add(werewolf);
        Fight FTwoYThree = new Fight(year, enemiesTwo, "As the final exam approach, you are stressed out. You decide to take a walk in the park. \nAs you go through the forest, a dark and long howl to the Moon is heard. You turn around and discover a big werewolf that want to make you his dinner... You need to flee !", 2);
        //Enemies for the Boss fight
        Boss dementors = new Boss("Dementors", 2000, 2000, year, "Use Expecto Patronum to make them leave ! It is the only spell useful against those enemies.", 3F);
        dementors.createAttackBoss(year);
        dementors.createAttackBoss(year);
        List<AbstractEnemy> enemiesBoss = new ArrayList<>();
        enemiesBoss.add(dementors);
        Fight FBoss = new Fight(year, enemiesBoss, "Now that you have loosen the werewolf, you rest by the Lake. You stay there and don't perceive the dementors coming ! You are surrounded, defeat them if you want to keep your sanity !", 3);
        //Create the list of fights for the first year
        ArrayList<Fight> fights = new ArrayList<>();
        fights.add(FOneYThree);
        fights.add(FTwoYThree);
        fights.add(FBoss);
        return fights;
    }

    public ArrayList<Fight> createFightYearFour(Year year){
        //Enemies for first fight
        Enemy dragon = new Enemy("Dragon", 350, 350, year, "Make him KO or disarm him", 3.5F);
        dragon.createEnemyAttack(year);
        List<AbstractEnemy> enemiesOne = new ArrayList<>();
        enemiesOne.add(dragon);
        Fight FOneYThree = new Fight(year, enemiesOne, "One of the test of the Goblet of Fire is to defeat a dragon.\nWhen you hear this information, your are frightened. Use all of your knowledge to defeat it !", 1);
        //Enemies for second fight
        Enemy deathEaterOne = new Enemy("Death Eater",  200, 200, year, "Make damages to kill them !", 3.5F);
        deathEaterOne.createEnemyLock(year);
        Enemy deathEaterTwo = new Enemy("Death Eater",  200, 200, year, "Make damages to kill them !", 3.5F);
        deathEaterOne.createEnemyAttack(year);
        deathEaterTwo.createEnemyAttack(year);
        List<AbstractEnemy> enemiesTwo = new ArrayList<>();
        enemiesTwo.add(deathEaterOne);
        enemiesTwo.add(deathEaterTwo);
        Fight FTwoYThree = new Fight(year, enemiesTwo, "The competition of the Goblet Of Fire end by a labyrinth. You are lucky : you found the cup first !\nBut as you touch it, you are send in another place, where Peter Petitgrow wait for you to awakened Lord Voldemort.\nYou can't stop him : some death eaters have appeared in front of you ! You need to defeat them if you want a chance to stop Petitgrow.", 2);
        //Enemies for the Boss fight
        Boss voldemort = new Boss("Lord Voldemort and the Portekey", 100000, 100000, year, "Use accio when you attack Lord Voldemort to attrack the Portekey to you.",3.5F);
        voldemort.createAttackBoss(year);
        Boss peterPetitgrow = new Boss("Peter Petitgrow", 100000, 100000, year, "Use expelliarmus to disarm Petitgrow. He can't be defeated in another way, he is too powerful", 3.5F);
        peterPetitgrow.createAttackBoss(year);
        List<AbstractEnemy> enemiesBoss = new ArrayList<>();
        enemiesBoss.add(voldemort);
        Fight FBoss = new Fight(year, enemiesBoss, "Petitgrow has succeeded to reanimate Lord Voldemort ! He needs to be disarm so that you can attract the cup - a Portkey ! - and travel back to the school, where you are in safety. The Portkey is just near Voldemort, focus him to attract the cup", 3);
        //Create the list of fights for the first year
        ArrayList<Fight> fights = new ArrayList<>();
        fights.add(FOneYThree);
        fights.add(FTwoYThree);
        fights.add(FBoss);
        return fights;
    }



    public ArrayList<Fight> createFightYearFive(Year year){
        //Enemies for first fight
        Enemy dementorOne  = new Enemy("Dementors", 500, 500, year, "Use Expecto Patronum to make them leave ! It is the only spell useful against those enemies.", 4F);
        Enemy dementorTwo  = new Enemy("Dementors", 500, 500, year, "Use Expecto Patronum to make them leave ! It is the only spell useful against those enemies.",4F);
        List<AbstractEnemy> enemiesOne = new ArrayList<>();
        enemiesOne.add(dementorOne);
        enemiesOne.add(dementorTwo);
        Fight FOneYThree = new Fight(year, enemiesOne, "Dolores Ombrage has authorized dementors to come inside the school. You think it's a bad idea but don't worry to much about it... until one comes to devour you !", 1);
        //Enemies for second fight
        Enemy trainingMachineOne  = new Enemy("Training machine ",  500, 500, year, "It's a training machine : you can use all your skill to defeat it !", 4F);
        trainingMachineOne.createEnemyAttack(year);
        Enemy trainingMachineTwo  = new Enemy("Training machine ",  500, 500, year, "It's a training machine : you can use all your skill to defeat it !", 4F);
        trainingMachineTwo.createEnemyAttack(year);
        List<AbstractEnemy> enemiesTwo = new ArrayList<>();
        enemiesTwo.add(trainingMachineOne);
        enemiesTwo.add(trainingMachineTwo);
        Fight FTwoYThree = new Fight(year, enemiesTwo, "As the final exam approach, you are stressed out. You decide to take a walk in the park. \nAs you go through the forest, a dark and long howl to the Moon is heard. You turn around and discover a big werewolf that want to make you his dinner... You need to flee !", 2);
        //Enemies for the Boss fight
        Boss doloresOmbrage = new Boss("Dolores Ombrage", 30000, 30000, year, "Continue to attack her with any spell until you find your fireworks !", 4.5F);
        doloresOmbrage.createAttackBoss(year);
        List<AbstractEnemy> enemiesBoss = new ArrayList<>();
        enemiesBoss.add(doloresOmbrage);
        Fight FBoss = new Fight(year, enemiesBoss, "Dolores Ombrage made you live an awful year at Hogwarts. You want to destroy the exam she organized all year. For that, you interrupt the test by attacking Ombrage. You have bring fireworks... but where are they ?\nContinue to attack her until you find your fireworks !", 3);
        //Create the list of fights for the first year
        ArrayList<Fight> fights = new ArrayList<>();
        fights.add(FOneYThree);
        fights.add(FTwoYThree);
        fights.add(FBoss);
        return fights;
    }

    public ArrayList<Fight> createFightYearSix(Year year){
        //Enemies for first fight
        Enemy rival = new Enemy("Your rival", 600, 600, year, "Make huge damages before you make him flee or make him KO. Sectumsempra is very useful...",4.5F);
        rival.createEnemyAttack(year);
        List<AbstractEnemy> enemiesOne = new ArrayList<>();
        enemiesOne.add(rival);
        Fight FOneYSix = new Fight(year, enemiesOne, "This year, you are in competition with a real good student that provokes you everytime he can.\nOne afternoon, he blokes you in the bathroom and attacks you. you have to response : make him huge damages but don't kill him. Then he will flee.", 1);
        //Enemies for second fight
        Enemy shadowOne = new Enemy("Shadow",  800, 800, year, "Use something that create light to destroy it", 4.5F);
        shadowOne.createEnemyAttack(year);
        Enemy shadowTwo = new Enemy("Shadow",  800, 800, year, "Use something that create light to destroy it", 4.5F);
        shadowTwo.createEnemyAttack(year);
        List<AbstractEnemy> enemiesTwo = new ArrayList<>();
        enemiesTwo.add(shadowOne);
        enemiesTwo.add(shadowTwo);
        Fight FTwoYSix = new Fight(year, enemiesTwo, "Dumbledore has invited you to an adventure. Everything seems alright since shadows start to attack you and your director. Make them disappear !", 2);
        //Enemies for the Boss fight
        Boss deathEater = new Boss("Death Eater", 1000, 1000, year, "Make damages to kill them !", 5F);
        deathEater.createAttackBoss(year);
        List<AbstractEnemy> enemiesBoss = new ArrayList<>();
        enemiesBoss.add(deathEater);
        Fight FBoss = new Fight(year, enemiesBoss, "Now that you return to Hogwarts, you are confronted to Death Eaters that invade the buildings. They kill Dumbledore and now, you have to defeat them if you want to survive !", 3);
        //Create the list of fights for the first year
        ArrayList<Fight> fights = new ArrayList<>();
        fights.add(FOneYSix);
        fights.add(FTwoYSix);
        fights.add(FBoss);
        return fights;
    }

    public ArrayList<Fight> createFightYearSeven(Year year) {
        //Enemies for first fight
        Enemy deathEaterOne = new Enemy("Death Eater", 800, 800, year, "Make damages to kill them !",6F);
        Enemy deathEaterTwo = new Enemy("Death Eater", 800, 800, year, "Make damages to kill them !", 6F);
        deathEaterOne.createEnemyAttack(year);
        deathEaterTwo.createEnemyAttack(year);
        List<AbstractEnemy> enemiesOne = new ArrayList<>();
        enemiesOne.add(deathEaterOne);
        enemiesOne.add(deathEaterTwo);
        Fight FOneYSeven = new Fight(year, enemiesOne, "The school is attacked ! Death Eaters try to enter. Stop them !", 1);
        //Enemies for second fight
        Enemy nagini = new Enemy("Nagini", 800, 800, year, "Use anything to stop it", 6F);
        nagini.createEnemyAttack(year);
        List<AbstractEnemy> enemiesTwo = new ArrayList<>();
        enemiesTwo.add(nagini);
        Fight FTwoYSeven = new Fight(year, enemiesTwo, "The Death Eaters are dead but now, Nagini tries to inject you his poison.Defeat it.", 2);
        //Enemies for the Boss fight
        Boss voldemort = new Boss("Lord Voldemort", 2000, 2000, year, "use any spell or potion to kill her. If your wand is made of phoenix feather, watch out !", 6F);
        voldemort.createAttackVoldemort(year);
        Boss bellatrixLestrange = new Boss("Bellatrix Lestrange", 800, 800, year, "Use any spell or potion to kill her !", 6F);
        bellatrixLestrange.createAttackBellatrix(year);
        List<AbstractEnemy> enemiesBoss = new ArrayList<>();
        enemiesBoss.add(voldemort);
        enemiesBoss.add(bellatrixLestrange);
        Fight FBoss = new Fight(year, enemiesBoss, "You are now confronted to Lord Voldemort and Bellatrix Lestrange. It's your time to shine : kill them ! If you succeed, the threat will be destroyed !", 3);
        //Create the list of fights for the first year
        ArrayList<Fight> fights = new ArrayList<>();
        fights.add(FOneYSeven);
        fights.add(FTwoYSeven);
        fights.add(FBoss);
        return fights;
    }
    public ArrayList<ArrayList<Fight>> setupFights(List<Year> years){
        ArrayList<Fight> fightsOne = createFightYearOne(years.get(0));
        ArrayList<Fight> fightsTwo = createFightYearTwo(years.get(1));
        ArrayList<Fight> fightsThree = createFightYearThree(years.get(2));
        ArrayList<Fight> fightsFour = createFightYearFour(years.get(3));
        ArrayList<Fight> fightsFive = createFightYearFive(years.get(4));
        ArrayList<Fight> fightsSix = createFightYearSix(years.get(5));
        ArrayList<Fight> fightsSeven = createFightYearSeven(years.get(6));
        ArrayList<ArrayList<Fight>> fights = new ArrayList<>();
        fights.add(fightsOne);
        fights.add(fightsTwo);
        fights.add(fightsThree);
        fights.add(fightsFour);
        fights.add(fightsFive);
        fights.add(fightsSix);
        fights.add(fightsSeven);
        return fights;
    }

    public void scholarshipProgress(ArrayList<Year> years, Wizard player, ArrayList<Spell> spells, ArrayList<Potion> allPotions, ArrayList<ArrayList<Fight>> fights){
        for (Year year : years){
            year.yearProgress(player, spells, allPotions);
            year.StartFights(player, fights.get(0));
            player.reward();
        }
    }
}
