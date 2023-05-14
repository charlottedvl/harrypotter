package com.isep.harrypotter.controler;

import com.isep.harrypotter.Setup;
import com.isep.harrypotter.character.Wizard;
import com.isep.harrypotter.character.particularities.House;
import com.isep.harrypotter.knowledge.ForbiddenSpell;
import com.isep.harrypotter.knowledge.Potion;
import com.isep.harrypotter.knowledge.Spell;
import com.isep.harrypotter.scholarship.Fight;
import com.isep.harrypotter.scholarship.Year;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GetWizard {
    @FXML
    private TextField nameField;
    @FXML
    private Text startGame;
    @FXML
    private VBox view;
    @FXML
    private Button changeSceneButton;
    @FXML
    private void handleButtonConfirm(ActionEvent event) throws IOException {
        String name = nameField.getText();
        startGame.setText("Welcome " + name + " ! Get ready, your scholarship is about to begin :)");
        Wizard player = new Wizard(name, 100F, 100, 1.0F);

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
        Controller.load("YourCharacter.fxml", this.view, this.changeSceneButton);
    }
}
