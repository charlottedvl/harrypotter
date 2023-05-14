package com.isep.harrypotter.controler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class HelloController {
    @FXML
    private Button changeSceneButton;
    @FXML
    private VBox view;


    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, InterruptedException {
        String filename = "GetWizard.fxml";
        Controller.load(filename, view, changeSceneButton);

    }



    @FXML
    protected void onHelloButtonMouseEntered() {
        changeSceneButton.setText("Click me !");
    }
    @FXML
    protected void onHelloButtonMouseExited() {
        changeSceneButton.setText("Start Game");
    }
}