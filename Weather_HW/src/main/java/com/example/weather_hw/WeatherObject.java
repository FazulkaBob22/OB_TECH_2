package com.example.weather_hw;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public abstract class WeatherObject extends Canvas {
    protected GraphicsContext gc;
    protected Color farb;
    protected double rychlX;
    protected double rychlY;
    protected Timeline timo;
    private static boolean hyb = true;
    protected Pane root;

    public WeatherObject(int x, int y, Color f){
        super(60,60);
        farb = f;
        setLayoutX(x);
        setLayoutY(y);
        gc = getGraphicsContext2D();
                timo = new Timeline(new KeyFrame(Duration.millis(50), e -> {if(hyb){pohyb();}}));


        timo.setCycleCount(Animation.INDEFINITE);

    }

public void zac(){timo.play();}
protected abstract void vykresli();
protected abstract void pohyb();
public static void zastav(){hyb = !hyb;}
    protected void odstran() {
    timo.stop();
        if (getParent() instanceof Pane) {
           Pane rodic = (Pane) getParent();
           rodic.getChildren().remove(this);
        }
    }
    public void posun(){setLayoutX(getLayoutX()-20);}
}
