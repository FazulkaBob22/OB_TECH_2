package com.example.weather_hw;


import javafx.scene.paint.Color;

public class Cloud extends WeatherObject{
    public Cloud(int x, int y){
        super(x,y, Color.GRAY);
        rychlX = 1;
        vykresli();
        zac();
    }
    @Override
    protected void vykresli(){
        gc.clearRect(0,0,getWidth(), getHeight());
        gc.setFill(farb);
        gc.fillOval(10,10,35,35);
        gc.fillOval(7,7,35,35);
        gc.fillOval(15,15,35,35);

    }
    @Override
    protected void pohyb(){
        if(getLayoutX() > 560 || getLayoutX() <= 0){
            rychlX = -rychlX;
        }
        setLayoutX(getLayoutX()+rychlX);
    }
    public void Farba(Color f){
        farb = f;
        vykresli();
    }

}
