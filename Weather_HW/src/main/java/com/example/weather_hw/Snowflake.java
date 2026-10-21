package com.example.weather_hw;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Snowflake extends WeatherObject{
    private double povodnaX;
    private double cas = Math.random() * Math.PI * 2;

    public Snowflake(int x, int y) {
        super(x, y, Color.LIGHTGREY);

        povodnaX = x;
        rychlY = 1;

        vykresli();
        zac();
    }

    @Override
    protected void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(farb);
        gc.fillOval(10, 10, 15, 15);
    }

    @Override
    protected void pohyb() {

        setLayoutY(getLayoutY() + rychlY);
        cas += 0.05;
        setLayoutX(povodnaX + Math.sin(cas) * 20);
        if (getParent() instanceof Pane
                && getLayoutY() >= ((Pane) getParent()).getHeight()) {
            odstran();
        }
    }
}
