package com.isep.harrypotter;

import com.isep.harrypotter.character.Wizard;
import com.isep.harrypotter.knowledge.ForbiddenSpell;
import com.isep.harrypotter.knowledge.Potion;
import com.isep.harrypotter.knowledge.Spell;
import com.isep.harrypotter.scholarship.Fight;
import com.isep.harrypotter.scholarship.Year;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSetup {

    @Test
    public void testCreateSpells() {
        ArrayList<Spell> spells = new ArrayList<>();
        Setup setup = new Setup();
        setup.createSpells(spells);
        assertEquals("Incendio", spells.get(3).getName(), "Name of spell 1");
        assertEquals(40F, spells.get(3).getValue(), 0.001, "Damage of spell 1");
        assertEquals("Expelliarmus", spells.get(4).getName(), "Name of spell 2");
        assertEquals(10F, spells.get(4).getValue(), 0.001, "Damage of spell 2");
        assertEquals("Glacius", spells.get(6).getName(), "Name of spell 3");
        assertEquals(40F, spells.get(6).getValue(), 0.001, "Damage of spell 3");
        assertEquals("Confringo", spells.get(11).getName(), "Name of spell 12");
        assertEquals(50F, spells.get(11).getValue(), 0.001, "Damage of spell 12");
        assertEquals("Sectumsempra", spells.get(12).getName(), "Name of spell 13");
        assertEquals(45F, spells.get(12).getValue(), 0.001, "Damage of spell 13");
    }

    @Test
    public void testCreateForbiddenSpell(){
        ArrayList<ForbiddenSpell> forbiddenSpells = new ArrayList<>();
        Setup setup = new Setup();
        setup.createForbiddenSpell(forbiddenSpells);
        assertEquals("Avada Kedavra", forbiddenSpells.get(0).getName(), "Name of spell 1");
        assertEquals(100000, forbiddenSpells.get(0).getValue(), 0.001, "Damage of spell 1");
        assertEquals("Doloris", forbiddenSpells.get(1).getName(), "Name of spell 2");
        assertEquals(60, forbiddenSpells.get(1).getValue(), 0.001, "Damage of spell 2");
        assertEquals("Imperio", forbiddenSpells.get(2).getName(), "Name of spell 3");
        assertEquals(30, forbiddenSpells.get(2).getValue(), 0.001, "Damage of spell 3");
    }

    @Test
    public void testCreateAllPotions() {
        ArrayList<Potion> allPotions = new ArrayList<>();
        Setup setup = new Setup();
        setup.createAllPotions(allPotions);
        assertEquals("Fire Potion", allPotions.get(1).getName(), "Name of potion 1");
        assertEquals(30F, allPotions.get(1).getValue(), 0.001, "Damage of potion 1");
        assertEquals("Undetectable Poisons", allPotions.get(5).getName(), "Name of potion 2");
        assertEquals(30F, allPotions.get(5).getValue(), 0.001, "Damage of potion 2");
        assertEquals("Skele-Gro", allPotions.get(7).getName(), "Name of potion 3");
        assertEquals(25F, allPotions.get(7).getValue(), 0.001, "Damage of potion 3");
        assertEquals("Erumpent Potion", allPotions.get(8).getName(), "Name of potion 12");
        assertEquals(40F, allPotions.get(8).getValue(), 0.001, "Damage of potion 12");
        assertEquals("Amortentia", allPotions.get(9).getName(), "Name of potion 13");
        assertEquals(0F, allPotions.get(9).getValue(), 0.001, "Damage of potion 13");
    }

    @Test
    public void testSetupYears() {
        Setup setup = new Setup();
        ArrayList<Year> years = setup.setupYears();

        assertEquals(7, years.size());

        assertEquals(1, years.get(0).getNumberYear());
        assertEquals("first", years.get(0).getNumber());
        assertEquals("The Philosopher's Stone", years.get(0).getName());
        assertEquals("Dungeon's toilets", years.get(0).getLieu());
        assertEquals("We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Wingardium Leviosa. ", years.get(0).getAdvice());

        assertEquals(2, years.get(1).getNumberYear());
        assertEquals("second", years.get(1).getNumber());
        assertEquals("The Chamber of Secret", years.get(1).getName());
        assertEquals("Chamber of Secret", years.get(1).getLieu());
        assertEquals("We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Accio. ", years.get(1).getAdvice());

        assertEquals(5, years.get(4).getNumberYear());
        assertEquals("fifth", years.get(4).getNumber());
        assertEquals("The Order of Phoenix", years.get(4).getName());
        assertEquals("Hogwarts exam room", years.get(4).getLieu());
        assertEquals("Learn as many things as you can to succeed in your HOWL", years.get(4).getAdvice());

    }

    @Test
    public void testCreateFightYearOne() {
        Year yearOne = new Year(1, "first", "The Philosopher's Stone", "Dungeon's toilets", "We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Wingardium Leviosa. ");
        Setup setup = new Setup();
        ArrayList<Fight> fights = setup.createFightYearOne(yearOne);
        assertEquals(fights.size(), 3);
        assertEquals(fights.get(0).getDescription(), "Oh no ! It seems that you are in trouble. In the dungeon, the shadows scares you. You become to be paranoid and hurt yourself. \nTry to reassure yourself");
        assertEquals(fights.get(0).getEnemies().size(), 2);
        assertEquals(fights.get(0).getPhase(), 1);

        assertEquals(fights.get(1).getDescription(), "When you enter deeper in the Dungeon, you see that the way is blocked by a rock and a door closed by a lock. \nClear the way to pass");
        assertEquals(fights.get(1).getEnemies().size(), 2);
        assertEquals(fights.get(1).getPhase(), 2);

        assertEquals(fights.get(2).getDescription(), "There is a HUUUUGE Troll on your way ! Make him inconscious. Be careful, he is insensible to potion");
        assertEquals(fights.get(2).getEnemies().size(), 1);
        assertEquals(fights.get(2).getPhase(), 3);
    }

    @Test
    public void testCreateFightYearTwo() {
        Year yearTwo = new Year(2, "second", "The Chamber of Secret", "Chamber of Secret", "We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Accio. ");
        Setup setup = new Setup();
        ArrayList<Fight> fights = setup.createFightYearTwo(yearTwo);
        assertEquals(fights.size(), 3);
        assertEquals(fights.get(0).getDescription(), "The year pass by and many disappearances happen. The professors suspect the Chamber of Secret to be open. They decide to set up a duel between students. You are chosen against your principal rival.");
        assertEquals(fights.get(0).getEnemies().size(), 1);
        assertEquals(fights.get(0).getPhase(), 1);

        assertEquals(fights.get(1).getDescription(), "You have found the access to the Chamber of Secret ! While you go down in the tunnels, you are sent into a spiders' nest. You need to pass them !");
        assertEquals(fights.get(1).getEnemies().size(), 2);
        assertEquals(fights.get(1).getPhase(), 2);

        assertEquals(fights.get(2).getDescription(), "You have entered the Chamber of Secret. Oh no ! Your are confronted to a Basilic that want to eat you ! The only way to defeat it is destroying the diary in front of you.");
        assertEquals(fights.get(2).getEnemies().size(), 1);
        assertEquals(fights.get(2).getPhase(), 3);
    }
    @Test
    public void testCreateFightYearThree() {
        Year yearThree = new Year(3, "third", "The Prisoner of Azkaban", "Lake in the Forbidden Forrest", "We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Expecto Patrunum. ");
        Setup setup = new Setup();
        ArrayList<Fight> fights = setup.createFightYearThree(yearThree);
        assertEquals(fights.size(), 3);
        assertEquals(fights.get(0).getDescription(), "One of the test of the Goblet of Fire is to defeat a dragon.\nWhen you hear this information, your are frightened. Use all of your knowledge to defeat it !");
        assertEquals(fights.get(0).getEnemies().size(), 1);
        assertEquals(fights.get(0).getPhase(), 1);

        assertEquals(fights.get(1).getDescription(), "As the final exam approach, you are stressed out. You decide to take a walk in the park. \nAs you go through the forest, a dark and long howl to the Moon is heard. You turn around and discover a big werewolf that want to make you his dinner... You need to flee !");
        assertEquals(fights.get(1).getEnemies().size(), 1);
        assertEquals(fights.get(1).getPhase(), 2);

        assertEquals(fights.get(2).getDescription(), "Now that you have loosen the werewolf, you rest by the Lake. You stay there and don't perceive the dementors coming ! You are surrounded, defeat them if you want to keep your sanity !");
        assertEquals(fights.get(2).getEnemies().size(), 1);
        assertEquals(fights.get(2).getPhase(), 3);
    }
    @Test
    public void testCreateFightYearFour() {
        Year yearFour = new Year(4, "fourth", "The Goblet of Fire", "Little Hangleton Cemetery", "Learn as many things as you can to survive the competition");
        Setup setup = new Setup();
        ArrayList<Fight> fights = setup.createFightYearFour(yearFour);
        assertEquals(fights.size(), 3);
        assertEquals(fights.get(0).getDescription(), "One of the test of the Goblet of Fire is to defeat a dragon.\nWhen you hear this information, your are frightened. Use all of your knowledge to defeat it !");
        assertEquals(fights.get(0).getEnemies().size(), 1, "enemy 1");
        assertEquals(fights.get(0).getPhase(), 1);

        assertEquals(fights.get(1).getDescription(), "The competition of the Goblet Of Fire end by a labyrinth. You are lucky : you found the cup first !\nBut as you touch it, you are send in another place, where Peter Petitgrow wait for you to awakened Lord Voldemort.\nYou can't stop him : some death eaters have appeared in front of you ! You need to defeat them if you want a chance to stop Petitgrow.");
        assertEquals(fights.get(1).getEnemies().size(), 2, "enemy 2");
        assertEquals(fights.get(1).getPhase(), 2);

        assertEquals(fights.get(2).getDescription(), "Petitgrow has succeeded to reanimate Lord Voldemort ! He needs to be disarm so that you can attract the cup - a Portkey ! - and travel back to the school, where you are in safety. The Portkey is just near Voldemort, focus him to attract the cup");
        assertEquals(fights.get(2).getEnemies().size(), 2, "enemy 3");
        assertEquals(fights.get(2).getPhase(), 3);
    }
    @Test
    public void testCreateFightYearFive() {
        Year yearFive = new Year(5, "fifth", "The Order of Phoenix", "Hogwarts exam room", "Learn as many things as you can to succeed in your HOWL");
        Setup setup = new Setup();
        ArrayList<Fight> fights = setup.createFightYearFive(yearFive);
        assertEquals(fights.size(), 3);
        assertEquals(fights.get(0).getDescription(), "Dolores Ombrage has authorized dementors to come inside the school. You think it's a bad idea but don't worry to much about it... until one comes to devour you !");
        assertEquals(fights.get(0).getEnemies().size(), 2);
        assertEquals(fights.get(0).getPhase(), 1);

        assertEquals(fights.get(1).getDescription(), "As the final exam approach, you are stressed out. You decide to take a walk in the park. \nAs you go through the forest, a dark and long howl to the Moon is heard. You turn around and discover a big werewolf that want to make you his dinner... You need to flee !");
        assertEquals(fights.get(1).getEnemies().size(), 2);
        assertEquals(fights.get(1).getPhase(), 2);

        assertEquals(fights.get(2).getDescription(), "Dolores Ombrage made you live an awful year at Hogwarts. You want to destroy the exam she organized all year. For that, you interrupt the test by attacking Ombrage. You have bring fireworks... but where are they ?\nContinue to attack her until you find your fireworks !");
        assertEquals(fights.get(2).getEnemies().size(), 1);
        assertEquals(fights.get(2).getPhase(), 3);
    }
    @Test
    public void testCreateFightYearSix() {
        Year yearSix = new Year(6, "sixth", "The Half-Blood Prince", "Astronomy tower", "We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Sectumsempra. ");
        Setup setup = new Setup();
        ArrayList<Fight> fights = setup.createFightYearSix(yearSix);
        assertEquals(fights.size(), 3);
        assertEquals(fights.get(0).getDescription(), "This year, you are in competition with a real good student that provokes you everytime he can.\nOne afternoon, he blokes you in the bathroom and attacks you. you have to response : make him huge damages but don't kill him. Then he will flee.");
        assertEquals(fights.get(0).getEnemies().size(), 1);
        assertEquals(fights.get(0).getPhase(), 1);

        assertEquals(fights.get(1).getDescription(), "Dumbledore has invited you to an adventure. Everything seems alright since shadows start to attack you and your director. Make them disappear !");
        assertEquals(fights.get(1).getEnemies().size(), 2);
        assertEquals(fights.get(1).getPhase(), 2);

        assertEquals(fights.get(2).getDescription(), "Now that you return to Hogwarts, you are confronted to Death Eaters that invade the buildings. They kill Dumbledore and now, you have to defeat them if you want to survive !");
        assertEquals(fights.get(2).getEnemies().size(), 1);
        assertEquals(fights.get(2).getPhase(), 3);
    }
    @Test
    public void testCreateFightYearSeven() {
        Year yearSeven = new Year(7, "seventh", "The Deathly Hallows", "Hogwarts", "We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Expelliarmus. ");
        Setup setup = new Setup();
        ArrayList<Fight> fights = setup.createFightYearSeven(yearSeven);
        assertEquals(fights.size(), 3);
        assertEquals(fights.get(0).getDescription(), "The school is attacked ! Death Eaters try to enter. Stop them !");
        assertEquals(fights.get(0).getEnemies().size(), 2);
        assertEquals(fights.get(0).getPhase(), 1);

        assertEquals(fights.get(1).getDescription(), "The Death Eaters are dead but now, Nagini tries to inject you his poison.Defeat it.");
        assertEquals(fights.get(1).getEnemies().size(), 1);
        assertEquals(fights.get(1).getPhase(), 2);

        assertEquals(fights.get(2).getDescription(), "You are now confronted to Lord Voldemort and Bellatrix Lestrange. It's your time to shine : kill them ! If you succeed, the threat will be destroyed !");
        assertEquals(fights.get(2).getEnemies().size(), 2);
        assertEquals(fights.get(2).getPhase(), 3);
    }


    @Test
    public void testSetupFights() {
        Setup setup = new Setup();
        List<Year> years = new ArrayList<>();
        years.add(new Year(1, "first", "The Philosopher's Stone", "Dungeon's toilets", ""));
        years.add(new Year(2, "second", "The Chamber of Secret", "Chamber of Secret", ""));
        years.add(new Year(3, "third", "The Prisoner of Azkaban", "Lake in the Forbidden Forrest", ""));
        years.add(new Year(4, "fourth", "The Goblet of Fire", "Little Hangleton Cemetery", ""));
        years.add(new Year(5, "fifth", "The Order of Phoenix", "Hogwarts exam room", ""));
        years.add(new Year(6, "sixth", "The Half-Blood Prince", "Astronomy tower", ""));
        years.add(new Year(7, "seventh", "The Deathly Hallows", "Hogwarts", ""));

        ArrayList<ArrayList<Fight>> fights = setup.setupFights(years);

        assertEquals(7, fights.size());
        assertEquals(3, fights.get(0).size());
        assertEquals(3, fights.get(1).size());
        assertEquals(3, fights.get(2).size());
        assertEquals(3, fights.get(3).size());
        assertEquals(3, fights.get(4).size());
        assertEquals(3, fights.get(5).size());
        assertEquals(3, fights.get(6).size());
    }


    }
