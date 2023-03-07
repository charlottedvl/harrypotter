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
        List<Spell> knownSpells = new ArrayList<>();
        List<Potion> potions = new ArrayList<>();

        // We create the new wizard;
        Wizard player = new Wizard(name, pet, wand, house, knownSpells, potions);
        System.out.println("Hello " + player.name + ", we are happy to welcome you at Hogwarts School, the Wizard school");
        System.out.println("The Sorting Hat has attribuated you to " + player.house);
        System.out.println("Your pet is : " + player.pet);
        System.out.println("Your wand has : " + player.wand.core + " as a core and mesures : " + player.wand.size + " cm.");
        System.out.println("Please enjoy your first year and learn as many things as you can.");
    }

}