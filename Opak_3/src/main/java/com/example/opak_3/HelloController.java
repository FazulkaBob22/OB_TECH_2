package com.example.opak_3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML
    private Pane root;

    @FXML
    private void pridaj(Hmyz h){
        root.getChildren().add(h);
    }
    @FXML
    private void addF(){
        int x = (int) (Math.random() * 400+10);
        int y = (int) (Math.random() * 300+10);
        Mucha m = new Mucha(x,y);
        pridaj(m);
    }
    @FXML private void addC(){
        int x = (int) (Math.random() * 400+10);
        int y = 280;
        Chrobak c = new Chrobak(x,y);
        pridaj(c);
    }


}
