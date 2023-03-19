package com.isep.harrypotter;

import com.isep.harrypotter.House.Houses;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();

        // We initiate the new player
        // We get the name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = scanner.nextLine();




        // We create the new wizard;
        Wizard player = new Wizard(name, 100F, 100);
        System.out.println("Hello " + name + ", we are happy to welcome you at Hogwarts School, the Wizard school");
        System.out.println("The Sorting Hat has attribuated you to " + player.getHouse());
        System.out.println("Your pet is : " + player.getPet());
        System.out.println("Your wand has : " + player.getWand().core + " as a core and measures : " + player.getWand().size + " cm.");
        System.out.println("Please enjoy your first year and learn as many things as you can.");

        // We change some attributes according to the house you are in
        House house = player.getHouse();
        house.specificationsHouse(player);

        //We initiate the year and the trimester
        ArrayList<Year> years = new ArrayList<Year>();
        Year yearOne = new Year(1, "first", "The Philosopher's Stone", "Dungeon's toilets", "We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Wingardium Leviosa. ");
        years.add(yearOne);


        // We create the lists of spells you can learn during all you school years
        ArrayList<Spell> spells = new ArrayList<>();
        Spell lumos = new Spell("Lumos", 0F, "Create a light at the end of your wand. Useful to see in the dark... and to reassure you", 1, "none", "light", "none", 1);
        Spell allohomora = new Spell("Allohomora", 0F, "Open any lock you want", 1, "none", "light", "none", 1);
        Spell wingardium_Leviosa = new Spell("Wingardium Leviosa", 30F, "Levitate any object, provided you pronounce the magic formula correctly", 1, "none", "damages", "none", 1);
        spells.add(lumos);
        spells.add(allohomora);
        spells.add(wingardium_Leviosa);
        player.setSpells(spells);

        // We create the lists of potions you can learn during all you school years
        ArrayList<Potion> allPotions = new ArrayList<>();
        Potion forgetfulness = new Potion ("Forgetfulness Potion", 0F, "Make your opponent lose memory. it increase confusion, useful when you don't want your enemy to attack !", 1, "attack", "confusion", "none", 1);
        Potion wiggenweld = new Potion ("Wiggenweld Potion", 0F, "A potion that help you heal from your injuries", 1, "defense", "heal", "none", 1);
        Potion fire  = new Potion ("Fire Potion", 30F, "Create a huge fire that burn enemies and light up the place", 1, "attack", "light", "damages", 1);
        allPotions.add(forgetfulness);
        allPotions.add(wiggenweld);
        allPotions.add(fire);
        player.setAllPotions(allPotions);

        //We start the first year
        yearOne.yearProgress(years.get(0), player, spells, allPotions);

        years.get(0).StartFightsOne(player);



    }




}