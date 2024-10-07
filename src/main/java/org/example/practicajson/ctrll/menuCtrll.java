package org.example.practicajson.ctrll;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class menuCtrll {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}