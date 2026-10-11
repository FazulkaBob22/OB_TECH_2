package com.example.ot_s3_semafor;

import javafx.fxml.FXML;

import javafx.scene.layout.Pane;

public class HelloController {
    @FXML
    private Pane root;
    Semafor s;

    @FXML protected void draw(){
        s = new Semafor();
        root.getChildren().add(s);
    }
    @FXML protected void changeState(){
        s.zmenStav();
    }
    @FXML protected void startTimer(){
        s.start();
    }
    @FXML protected void turnOFF(){
        s.vypni();
    }

}
