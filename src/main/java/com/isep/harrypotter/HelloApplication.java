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

        // We get a random pet;
        Pet[] pets = Pet.values();
        int randomIndexPet = new Random().nextInt(pets.length);
        Pet pet = pets[randomIndexPet];

        // We get a random wand core;
        Core[] cores = Core.values();
        int randomIndexCore = new Random().nextInt(cores.length);
        Core core = cores[randomIndexCore];

        // We get a random wand size
        Random random = new Random();
        int size = random.nextInt(11) + 10;

        // We create the wand
        Wand wand = new Wand(core, size);

        // We get a house
        Houses house = SortingHat.SortingHouse();

        // We create a list of known spells and potions
        List<Spell> knownSpells = new ArrayList<>(); //We use array list because the size of an arraylist can be modified
        List<Potion> potions = new ArrayList<>();

        // We create the new wizard;
        Wizard player = new Wizard(name, pet, wand, house, knownSpells, potions);
        System.out.println("Hello " + name + ", we are happy to welcome you at Hogwarts School, the Wizard school");
        System.out.println("The Sorting Hat has attribuated you to " + house);
        System.out.println("Your pet is : " + pet);
        System.out.println("Your wand has : " + wand.core + " as a core and measures : " + wand.size + " cm.");
        System.out.println("Please enjoy your first year and learn as many things as you can.");

        //We initiate the year and the trimester
        ArrayList<Year> years = Year.createYear();
        int trimester = 1;




        // We change some attributes according to the house you are in
        House.SpecificationHouse(house, player.getPercentSpells(), player.getPercentPotion(), player.getDamage(), player.getDefensePoint());

        // We create the list of spells you can learn during all you school years
        ArrayList<Spell> spells = Spell.createSpells();

        //We start the first year
        Year.yearProgress(years.get(0), player, spells);


    }




}