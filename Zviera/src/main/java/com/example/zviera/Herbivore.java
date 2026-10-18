package com.example.zviera;

import javafx.scene.paint.Color;

public class Herbivore extends Animal{
    public Herbivore(int x, int y){
        super(x,y,Color.GREEN);
        rychlX = 2;
        vykresli();
        zacPoh();
    }
    @Override
    protected void vykresli(){
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(farba);
        gc.fillOval(5, 5, 35, 35);
        gc.setFill(Color.WHITE);
        gc.fillOval(12, 13, 5, 5);
        gc.fillOval(29, 13, 5, 5);
    }
    @Override
    protected void pohyb() {
        if (getLayoutX() >= 560 || getLayoutX() <= 0) {
            rychlX = -rychlX;
        }
        setLayoutX(getLayoutX() + rychlX);
    }
    @Override
    public void zmenSmer(){
        rychlX = -rychlX;
    }
}
