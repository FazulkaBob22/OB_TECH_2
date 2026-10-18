package com.example.geometric;

import javafx.scene.paint.Color;

public class MySquare extends GeometricShape{
    public MySquare(int x, int y) {
        super(x, y, Color.PURPLE);
        rychlostY = 2;
        vykresli();
        spustiPohyb();
    }
    @Override
    protected void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());

        gc.setFill(farba);
        gc.fillRect(5, 5, 45, 45);
    }
    @Override
    protected void pohyb() {

        if (getLayoutY() >= 340 || getLayoutY() <= 0) {
            rychlostY = -rychlostY;
        }

        setLayoutY(getLayoutY() + rychlostY);
    }
}
