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
        System.out.println("Veuillez saisir votre nom");
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
        System.out.println("Your wand has : " + wand.core + " as a core and mesures : " + wand.size + " cm.");
        System.out.println("Please enjoy your first year and learn as many things as you can.");

        //We initiate the year and the trimester
        int year = 1;
        int trimester = 1;

        //We initiate the percent of success of each action (Fireworks is for year 5)
        float percentSpells = 0.75F;
        float percentPotion = 0.75F;
        float percentFireworks = 0.35F;

        // We initiate the number of Health Point (HP) and Damage Point (DP)
        int hp = 100;
        int dp = 100;

        // We initiate the damage and the defense
        float damage = 1F;
        float defense = 1F;

        // We change some attributes according to the house you are in
        switch (house){
            case Ravenclaw -> percentSpells = 0.85F;
            case Slytherin -> damage = 1.2F;
            case Gryffindor -> defense = 1.2F;
            case Hufflepuff -> percentPotion = 0.85F;
            default -> System.out.println("An error occurred. Please restart the game");
        }

        //Proposition of the 3 types of actions for the first semester
        int action = ChoiceAction(trimester);
        switch (action){
            case 1:
                break;
            case 2:
                break;
            case 3:
                percentSpells = SkipClass(percentSpells);
                percentPotion = SkipClass(percentPotion);
                percentFireworks = SkipClassFireworks(percentFireworks);
                break;
            default:
                System.out.println("Please enter a valid number");
                break;
        }

    }

    public static int ChoiceAction(int trimester){
        String number ="";
        if (trimester == 1){
            number = "first";
        } else if (trimester == 2){
            number = "second";
        } else {
            number = "third";
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do of your " + number + " trimester at Hogwarts ? (Please enter the number of the action)");
        System.out.println("1. Follow the sorcery lesson");
        System.out.println("2. Follow the potion lesson");
        System.out.println("3. Skip class and have fun");
        int action = scanner.nextInt();
        return action;
    }

    public static float SkipClass(float percentSuccess){
        percentSuccess = (float) (percentSuccess - 0.05);
        return percentSuccess;
    }

    public static float SkipClassFireworks(float percentFireworks){
        percentFireworks = (float) (percentFireworks + 0.05);
        return percentFireworks;
    }
}