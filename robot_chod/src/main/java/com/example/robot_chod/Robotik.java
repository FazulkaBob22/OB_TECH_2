package com.example.robot_chod;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Robotik extends Canvas {

    private GraphicsContext gc;
    private Pane root;
    private Timeline t;

    private boolean automat = false;

    private int smerX = 1;
    private int smerY = 0;

    private int rychlost = 3;

    public Robotik(int x, int y, Pane root) {
        super(60, 60);

        this.root = root;

        setLayoutX(x);
        setLayoutY(y);

        gc = getGraphicsContext2D();
        vykresli();

        t = new Timeline(
                new KeyFrame(Duration.millis(30), e -> AutoDrive())
        );

        t.setCycleCount(Timeline.INDEFINITE);
        t.play();

        setFocusTraversable(true);
        setOnKeyPressed(evt -> sprav(evt));

        setOnMouseClicked(evt -> zmenRezim());
    }

    private void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());


        if (smerX == 1) {
            gc.setFill(Color.GREEN);
        } else if (smerX == -1) {
            gc.setFill(Color.RED);
        } else if (smerY == -1) {
            gc.setFill(Color.BLUE);
        } else {
            gc.setFill(Color.ORANGE);
        }

        gc.fillRect(0, 0, getWidth(), getHeight());


        gc.setFill(Color.WHITE);

        if (smerX == 1) {
            gc.fillRect(40, 15, 12, 30);
        } else if (smerX == -1) {
            gc.fillRect(8, 15, 12, 30);
        } else if (smerY == -1) {
            gc.fillRect(15, 8, 30, 12);
        } else {
            gc.fillRect(15, 40, 30, 12);
        }
    }

    public void zapniAutomat() {
        automat = true;
    }

    public void vypniAutomat() {
        automat = false;
    }

    private void zmenRezim() {
        automat = !automat;
        requestFocus();
    }

    private void AutoDrive() {
        if (!automat) {
            return;
        }

        double novaX = getLayoutX() + smerX * rychlost;
        double novaY = getLayoutY() + smerY * rychlost;

        if (novaX <= 0 || novaX + getWidth() >= root.getWidth()) {
            smerX = -smerX;
        }

        if (novaY <= 0 || novaY + getHeight() >= root.getHeight()) {
            smerY = -smerY;
        }

        novaX = getLayoutX() + smerX * rychlost;
        novaY = getLayoutY() + smerY * rychlost;

        setLayoutX(Math.max(0,
                Math.min(novaX, root.getWidth() - getWidth())));

        setLayoutY(Math.max(0,
                Math.min(novaY, root.getHeight() - getHeight())));

        vykresli();
    }

    private void sprav(KeyEvent evt) {
        if (automat) {
            return;
        }

        KeyCode k = evt.getCode();

        if (k == KeyCode.W) {
            smerX = 0;
            smerY = -1;
        } else if (k == KeyCode.S) {
            smerX = 0;
            smerY = 1;
        } else if (k == KeyCode.A) {
            smerX = -1;
            smerY = 0;
        } else if (k == KeyCode.D) {
            smerX = 1;
            smerY = 0;
        } else {
            return;
        }

        double novaX = getLayoutX() + smerX * 10;
        double novaY = getLayoutY() + smerY * 10;

        setLayoutX(Math.max(0,
                Math.min(novaX, root.getWidth() - getWidth())));

        setLayoutY(Math.max(0,
                Math.min(novaY, root.getHeight() - getHeight())));

        vykresli();
    }
}
