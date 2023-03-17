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


        // We get a random wand core;
        Core[] cores = Core.values();
        int randomIndexCore = new Random().nextInt(cores.length);
        Core core = cores[randomIndexCore];

        // We get a random wand size
        Random random = new Random();
        int size = random.nextInt(11) + 10;

        // We create the wand
        Wand wand = new Wand(core, size);


        //We create the hp and maxHP
        int hp = 100;
        int maxHP = 100;

        // We create a list of known spells and potions
        List<Spell> knownSpells = new ArrayList<Spell>();
        List<Potion> potions = new ArrayList<Potion>();

        // We create the new wizard;
        Wizard player = new Wizard(name, wand, knownSpells, potions, hp, maxHP);
        System.out.println("Hello " + name + ", we are happy to welcome you at Hogwarts School, the Wizard school");
        System.out.println("The Sorting Hat has attribuated you to " + player.getHouse());
        System.out.println("Your pet is : " + player.getPet());
        System.out.println("Your wand has : " + wand.core + " as a core and measures : " + wand.size + " cm.");
        System.out.println("Please enjoy your first year and learn as many things as you can.");

        //We initiate the year and the trimester
        ArrayList<Year> years = Year.createYear();
        int trimester = 1;

        House house = new House();


        // We change some attributes according to the house you are in
        house.SpecificationHouse(player.getHouse(), player.getPercentSpells(), player.getPercentPotion(), player.getDamage(), player.getHp(), player.getMaxHP());

        // We create the lists of spells and potions you can learn during all you school years
        ArrayList<Spell> spells = Spell.createSpells();
        ArrayList<Potion> allPotions = Potion.createPotions();

        //We start the first year
        Year.yearProgress(years.get(0), player, spells, allPotions);

        Fight.StartFightsOne(years.get(0), player);



    }




}