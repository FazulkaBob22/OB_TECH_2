package com.example.geometric;

import javafx.scene.paint.Color;

public class MyCircle extends GeometricShape{
    private double uhol = 0;
    private final double stredX;
    private double stredY;
    private final double pol = 30;

    public MyCircle(int x, int y){
        super(x,y, Color.GREEN);
        stredX=x;
        stredY = y;
        vykresli();
        spustiPohyb();
    }
    @Override
    protected void vykresli() {
        gc.clearRect(0,0,getWidth(), getHeight());
        gc.setFill(farba);
        gc.fillOval(10,10,40,40);

    }
    @Override
    protected void pohyb() {
        uhol += 0.06;

        setLayoutX(stredX + pol * Math.cos(uhol));
        setLayoutY(stredY + pol * Math.sin(uhol));
    }

    public void zmenaFarby(Color f) {
        farba = f;
        vykresli();
    }
    @Override
    public void posunDole() {
        super.posunDole();
        stredY += 30;
    }
}
