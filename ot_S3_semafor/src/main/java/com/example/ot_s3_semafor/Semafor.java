package com.example.ot_s3_semafor;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Semafor extends Canvas {
    private GraphicsContext gc;
    private int stav = 0;
    private int stav2 = 0;
    private Timeline t;
    private Timeline timo;
    private boolean bezi = false;
    private boolean vypnuti = false;

    public Semafor(){
        super(150,400);
        setLayoutX(150);
        this.gc = this.getGraphicsContext2D();
        vykresli(Color.RED, Color.BLACK, Color.BLACK);
        setOnMousePressed(e->zmenStav());
        t = new Timeline(new KeyFrame(Duration.seconds(1), e->zmenStav()));
        timo = new Timeline(new KeyFrame(Duration.seconds(1),e->koloC()));
        t.setCycleCount(Timeline.INDEFINITE);
        timo.setCycleCount(Timeline.INDEFINITE);
    }

    public void start(){
        timo.stop();
        if (bezi){t.stop();bezi=false;}
        else {t.play();bezi=true;}
    }
    public void vypni(){
        t.stop();
        bezi=false;
        timo.play();
    }

    public void vykresli(Color red, Color yellow, Color green){
        gc.setFill(Color.GRAY);
        gc.fillRect(0,0,150,400);
        gc.setFill(red);
        gc.fillOval(30,30,80,80);
        gc.setFill(yellow);
        gc.fillOval(30,120,80,80);
        gc.setFill(green);
        gc.fillOval(30,210,80,80);
    }

    public void zmenStav(){
        if (stav == 3){stav =0;}
        else {stav++;}
        switch(stav){
            case 0: vykresli(Color.RED,Color.BLACK,Color.BLACK); break;
            case 1: vykresli(Color.RED, Color.ORANGE, Color.BLACK); break;
            case 2: vykresli(Color.BLACK, Color.BLACK, Color.GREEN); break;
            case 3: vykresli(Color.BLACK, Color.ORANGE, Color.BLACK); break;
    }
}

    public void koloC(){
        if (stav2 == 1){stav2 = 0;}
        else {stav2++;}
        switch (stav2){

            case 0: vykresli(Color.BLACK,Color.BLACK,Color.BLACK); break;
            case 1: vykresli(Color.BLACK, Color.ORANGE, Color.BLACK); break;
        }
    }

    }
