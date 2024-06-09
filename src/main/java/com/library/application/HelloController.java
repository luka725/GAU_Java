package com.library.application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String memberName = HelloApplication.getMemberFromDatabase(1);
        if (memberName != null) {
            welcomeText.setText("Welcome, " + memberName + "!");
        }else{
            welcomeText.setText("Welcome!");
        }

    }
}