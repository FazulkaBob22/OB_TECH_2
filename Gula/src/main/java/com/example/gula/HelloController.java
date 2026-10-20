package com.example.gula;

import javafx.fxml.FXML;

import javafx.scene.layout.Pane;

public class HelloController {
    @FXML
    private Pane root;
    Ballin gula;
    public void initialize(){
        gula = new Ballin(100,100, root);
        root.getChildren().add(gula);
    }

}
