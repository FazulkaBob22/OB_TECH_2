package com.example.auticko;

import javafx.fxml.FXML;

import javafx.scene.layout.Pane;

public class HelloController {
    @FXML
    private Pane root;
    Auto auto;
    @FXML public void zacat(){
        auto = new Auto(0,50,root);
        root.getChildren().add(auto);
    }
    @FXML public void gearChange(){
        if (auto != null) {
            auto.Zmena();
            auto.requestFocus();
        }
    }

}
