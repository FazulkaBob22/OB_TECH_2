package com.example.weather_hw;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Raindrop extends WeatherObject {
    public Raindrop(int x, int y){
        super(x,y, Color.BLUE);
        rychlY = 2;
        vykresli();
        zac();
    }
    @Override
    protected void vykresli(){
        gc.clearRect(0,0,getWidth(), getHeight());
        gc.setFill(farb);
        gc.fillOval(10,10,35,35);


    }
    @Override
    protected void pohyb() {
        setLayoutY(getLayoutY() + rychlY);

        if (getParent() instanceof Pane
                && getLayoutY() >= ((Pane) getParent()).getHeight()) {
            odstran();
        }
    }
}
