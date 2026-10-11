package com.example.auticko;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Auto extends Canvas {
    private GraphicsContext gc;
    private Pane root;
    private Timeline t;
    private boolean automat = false;
    private boolean bezi = true;
    private int smer = 1;
    private int rychlost = 2;

    public Auto(int x, int y, Pane root) {
        super(80, 40);
        this.root = root;
        setLayoutX(x);
        setLayoutY(y);
        gc = getGraphicsContext2D();
        vykresli();

        t = new Timeline(new KeyFrame(Duration.millis(40), e-> AutoDrive()));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();

        setOnKeyPressed(evt -> sprav(evt));
        setFocusTraversable(true);
        requestFocus();

        setOnMouseClicked(evt->klik());
    }

    private void vykresli() {
        gc.setFill(Color.PURPLE);
        gc.fillRect(0,0, getWidth(), getHeight());
    }

    public void Zmena(){
        automat = !automat;
    }

    private void klik(){
        if(bezi) {t.stop();bezi=false;}
        else {t.play();bezi=true;}
        requestFocus();
    }

    private void AutoDrive(){
        if (!automat) {return;}

        setLayoutX(getLayoutX() + smer * rychlost);

        if (getLayoutX() + getWidth() >= root.getWidth()) {smer = -1;}
        if (getLayoutX() <= 0) {smer = 1;}
    }

    private void sprav(KeyEvent evt){
        if(automat){return;}

        KeyCode k = evt.getCode();
        if (k == KeyCode.LEFT) {
            setLayoutX(getLayoutX() - 10);
        }
        if (k == KeyCode.RIGHT) {
            setLayoutX(getLayoutX() + 10);
        }
        if (k == KeyCode.UP) {
            setLayoutY(getLayoutY() - 10);
        }
        if (k == KeyCode.DOWN) {
            setLayoutY(getLayoutY() + 10);
        }
        if (getLayoutX() < 0) {
            setLayoutX(0);
        }
        if (getLayoutX() + getWidth() > root.getWidth()) {
            setLayoutX(root.getWidth() - getWidth());
        }
        if (getLayoutY() < 0) {
            setLayoutY(0);
        }
        if (getLayoutY() + getHeight() > root.getHeight()) {
            setLayoutY(root.getHeight() - getHeight());
        }
    }
}
