package com.example.opak_3;

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

public abstract class Hmyz extends Canvas {
    protected int rychl = 4;
    protected Color farba;
    protected Timeline t;
    protected GraphicsContext gc;

    protected KeyCode k;

    public Hmyz(int x, int y, Color f){
        super(x,y);
        farba = f;
        setLayoutX(x);
        setLayoutY(y);
        gc = getGraphicsContext2D();
        vykresli();

        t = new Timeline(new KeyFrame(Duration.millis(50), e-> pohyb()));
        t.setCycleCount(Animation.INDEFINITE);

        setFocusTraversable(true);
        setOnKeyPressed(ev -> sprav(ev));

    }
    protected abstract void vykresli();
    protected abstract void pohyb();
    public void zac(){
        t.play();
    }
    public void sprav(KeyEvent evt){
        k = evt.getCode();
        if(k==KeyCode.W) posun();
    }
    public void posun(){
        setLayoutY(getLayoutY()+50);
    }
}
