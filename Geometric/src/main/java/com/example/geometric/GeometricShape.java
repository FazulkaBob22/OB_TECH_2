package com.example.geometric;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class GeometricShape extends Canvas {

    protected GraphicsContext gc;
    protected Color farba;
    protected double rychlostX;
    protected double rychlostY;
    protected Timeline casovac;

    public GeometricShape(int x, int y, Color f) {
        super(60, 60);

        farba = f;

        setLayoutX(x);
        setLayoutY(y);

        gc = getGraphicsContext2D();

        casovac = new Timeline(
                new KeyFrame(Duration.millis(30), e -> pohyb())
        );

        casovac.setCycleCount(Animation.INDEFINITE);
    }

    protected abstract void vykresli();

    protected abstract void pohyb();

    public void spustiPohyb() {
        casovac.play();
    }

    public void posunDole() {
        setLayoutY(getLayoutY() + 30);
    }
}

