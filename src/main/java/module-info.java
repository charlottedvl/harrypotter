module com.isep.harrypotter {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.isep.harrypotter to javafx.fxml;
    exports com.isep.harrypotter;
    exports com.isep.harrypotter.character;
    opens com.isep.harrypotter.character to javafx.fxml;
    exports com.isep.harrypotter.knowledge;
    opens com.isep.harrypotter.knowledge to javafx.fxml;
    exports com.isep.harrypotter.character.particularities;
    opens com.isep.harrypotter.character.particularities to javafx.fxml;
    exports com.isep.harrypotter.scholarship;
    opens com.isep.harrypotter.scholarship to javafx.fxml;
    exports com.isep.harrypotter.controler;
    opens com.isep.harrypotter.controler to javafx.fxml;

}