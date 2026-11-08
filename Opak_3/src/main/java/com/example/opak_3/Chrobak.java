package com.example.opak_3;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;



public class Chrobak extends Hmyz{

    public Chrobak(int x, int y){
        super(x,y, Color.BLUE);
        rychl = 8;
        vykresli();
        zac();
    }

    @Override
    protected void vykresli() {
        gc.clearRect(0,0,getWidth(), getHeight());
        gc.setFill(farba);
        gc.fillRect(0,0,20,20);
    }

    @Override
    protected void pohyb() {
        {
            setLayoutX(getLayoutX() + rychl);

            if(getLayoutX() >=500 || getLayoutX() <= 0){
                rychl = -rychl;
            }


    }
}
    }
