package com.example.zviera;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;


public class HelloController {
    @FXML
    private Pane root;
    private void pridajObj(Animal zv){
        root.getChildren().add(zv);
    }
    @FXML
    private void pridajHer(){
        int x = (int) (Math.random() * 500 +10);
        int y = (int) (Math.random() * 300 +10);

        Herbivore h = new Herbivore(x,y);
        pridajObj(h);
    }
    @FXML
    private void pridajKar(){
        int x = (int) (Math.random() * 500 + 10);
        int y = (int) (Math.random() * 300 + 10);

        Carnivore c = new Carnivore(x, y);
        pridajObj(c);
    }
    @FXML
    private void otocKar(){
        for (int i = 0; i < root.getChildren().size(); i++) {
            Node objekt = root.getChildren().get(i);

            if (objekt instanceof Carnivore) {
                ((Carnivore) objekt).zmenSmer();
            }
        }
    }
    @FXML
    private void zastavPoh(){
        Animal.zmenPohyb();
    }
}
