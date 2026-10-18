package com.example.geometric;

import javafx.scene.paint.Color;

public class MyRectangle extends GeometricShape{
    public MyRectangle(int x, int y){
        super(x,y, Color.RED);
        rychlostX = 2;
        vykresli();
        spustiPohyb();
    }
    @Override
    protected void vykresli(){
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(farba);
        gc.fillRect(5,12,50,25);
    }
    @Override
    protected void pohyb() {

        if (getLayoutX() >= 540 || getLayoutX() <= 0) {
            rychlostX = -rychlostX;
        }

        setLayoutX(getLayoutX() + rychlostX);
    }
}
