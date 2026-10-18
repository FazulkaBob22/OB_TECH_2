package com.example.geometric;

import javafx.fxml.FXML;
import javafx.scene.Node;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private Pane root;

    @FXML
    public void initialize(){
        root.setFocusTraversable(true);
        root.setOnKeyPressed(ev-> {
            KeyCode klav = ev.getCode();
            switch (klav){
                case O:
                    root.getChildren().add(
                            new MyRectangle(randX(),randY())
                    ); break;
                case K:
                    root.getChildren().add(
                            new MyCircle(randX(), randY())
                    );break;
                case S:
                    root.getChildren().add(
                            new MySquare(randX(), randY())
                    );break;
                case M:
                    FarbaKr();break;
                case D:
                    DoleObj();break;
                default:break;
            }
        });
        root.setOnMouseClicked(ev -> root.requestFocus());
    }
    private int randX(){return (int) (Math.random() * 450+30);}
    private int randY(){return (int) (Math.random() * 220+30);}
    private void FarbaKr(){
        for(int i = 0; i < root.getChildren().size();i++){
            Node objekt = root.getChildren().get(i);
            if (objekt instanceof MyCircle)
            {((MyCircle) objekt).zmenaFarby(Color.BLUE);}

        }
    }
    private void DoleObj() {
        for (int i = 0; i < root.getChildren().size(); i++) {
            Node objekt = root.getChildren().get(i);

            if (objekt instanceof GeometricShape) {
                ((GeometricShape) objekt).posunDole();
            }
        }
    }
    }

