package com.isep.harrypotter;

import com.isep.harrypotter.character.*;
import com.isep.harrypotter.character.particularities.*;
import com.isep.harrypotter.scholarship.*;
import com.isep.harrypotter.knowledge.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
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
        Utiles utiles = new Utiles();

        // We get the name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = scanner.nextLine();

        // We create the new wizard;
        Wizard player = new Wizard(utiles, name, 100F, 100, 1F);
        System.out.println("Hello " + name + ", we are happy to welcome you at Hogwarts School, the Wizard school");
        System.out.println("The Sorting Hat has attribuated you to " + player.getHouse());
        System.out.println("Your pet is : " + player.getPet());
        System.out.println("Your wand has : " + player.getWand().getCore() + " as a core and measures : " + player.getWand().getSize() + " cm.");
        System.out.println("Please enjoy your first year and learn as many things as you can.");

        // We change some attributes according to the house you are in
        House house = player.getHouse();
        house.specificationsHouse(player);

        //We initiate the year and the trimester
        Setup setup = new Setup();
        ArrayList<Year> years = setup.setupYears();


        // We create the lists of spells you can learn during all you school years
        ArrayList<Spell> spells = new ArrayList<>();
        setup.createSpells(spells);
        player.setSpells(spells);

        // We create the list of forbidden spells
        ArrayList<ForbiddenSpell> forbiddenSpells = new ArrayList<>();
        setup.createForbiddenSpell(forbiddenSpells);
        player.setForbiddenSpells(forbiddenSpells);

        // We create the lists of potions you can learn during all you school years
        ArrayList<Potion> allPotions = new ArrayList<>();
        setup.createAllPotions(allPotions);
        player.setAllPotions(allPotions);

        // We create the list of fights
        ArrayList<ArrayList<Fight>> fights = setup.setupFights(years);

        //We start the years
        setup.scholarshipProgress(years, player, fights);

    }




}