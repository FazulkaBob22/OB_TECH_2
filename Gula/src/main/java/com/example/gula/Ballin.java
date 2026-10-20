package com.example.gula;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Ballin extends Canvas {
    private GraphicsContext gc;
    private int sped = 5;
    private int wX = 1;
    private int wY = 1;
    private boolean Zastav = true;
    private Timeline tim;
    private Pane root;

    public Ballin(double x, double y, Pane root){
        super(40,40);
        this.root = root;
        setLayoutX(x);setLayoutY(y);
        gc = getGraphicsContext2D();
        vykresli();

        tim = new Timeline(new KeyFrame(Duration.millis(50), e-> move()));
        tim.setCycleCount(Animation.INDEFINITE);
        tim.play();
        setOnKeyPressed(e -> sprav(e));
        setFocusTraversable(true);
        requestFocus();
        setOnMouseClicked(e->click());
    }
    private void vykresli() {
        gc.setFill(Color.PURPLE);
        gc.fillOval(0,0,getWidth(),getHeight());
    }
    private void click(){
        if(Zastav){tim.stop();Zastav=false;}
        else {tim.play();Zastav=true;}
    }

    private void move(){
        setLayoutY(getLayoutY() + wY * sped);
        setLayoutX(getLayoutX() + wX * sped);

        if(getLayoutY() <=0){wY = 1;}
        if(getLayoutY() + getHeight() >= root.getHeight()){wY = -1;}
        if(getLayoutX() <=0){wX = 1;}
        if(getLayoutX() + getWidth() >= root.getWidth()){wX = -1;}
    }
    private void sprav(KeyEvent e){
        KeyCode k = e.getCode();
        if(k == KeyCode.F){sped = sped +1;}
        if(k == KeyCode.S){
            if(sped>0){
            sped = sped - 1;}
        }
    }
}
