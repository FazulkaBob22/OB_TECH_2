package com.example.zviera;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class Animal extends Canvas {
    protected GraphicsContext gc;
    protected Color farba;
    protected  double rychlX;
    protected double rychlY;
    protected Timeline caso;

    private static boolean hybanie = true;

    public Animal(int x, int y, Color f){
        super(40,40);
        farba = f;
        setLayoutX(x);
        setLayoutY(y);
        gc = getGraphicsContext2D();
        caso = new Timeline(new KeyFrame(
                Duration.millis(50), e->{
            if(hybanie){pohyb();}
        }));
        caso.setCycleCount(Animation.INDEFINITE);
    }
    protected abstract void vykresli();
    protected abstract void pohyb();

    public void zacPoh(){
        caso.play();
    }
    public abstract void zmenSmer();
    public static void zmenPohyb(){
        hybanie = !hybanie;
    }
}
