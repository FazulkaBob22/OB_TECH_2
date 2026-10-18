package com.example.zviera;


import javafx.scene.paint.Color;

public class Carnivore extends Animal{
    public Carnivore(int x, int y){
        super(x, y, Color.ORANGE);
        rychlY = 2;
        vykresli();
        zacPoh();
    }
    @Override
    protected void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());

        gc.setFill(farba);
        gc.fillRect(5, 5, 30, 30);

        gc.setFill(Color.RED);
        gc.fillOval(10, 10, 8, 8);
        gc.fillOval(24, 10, 6, 6);
    }
    @Override
    protected void pohyb() {
        if (getLayoutY() >= 360 || getLayoutY() <= 0) {
            rychlY = -rychlY;
        }

        setLayoutY(getLayoutY() + rychlY);
    }
    @Override
    public void zmenSmer() {
        rychlY = -rychlY;
    }
}
