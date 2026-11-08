package com.example.opak_3;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Mucha extends Hmyz{

    public Mucha(int x, int y) {
        super(x, y, Color.BLUE);
        rychl = 4;
        vykresli();
        zac();

        setOnMouseClicked(ev -> odstran());
    }
    @Override
    protected void vykresli(){
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(farba);
        gc.fillOval(10,10,15,15);
    }
    @Override
    protected void pohyb(){
    setLayoutX(getLayoutX() + rychl);

    if(getLayoutX() >= ((Pane) getParent()).getWidth()){
        rychl = -4;
    }
    }
    public void odstran(){
        t.stop();
        if(getParent() instanceof Pane){
            Pane rodic = (Pane) getParent();
            rodic.getChildren().remove(this);
        }
    }


}
