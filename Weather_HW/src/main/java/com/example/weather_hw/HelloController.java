package com.example.weather_hw;

import javafx.fxml.FXML;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private Pane root;
    private void pridajObj(WeatherObject ob){
        root.getChildren().add(ob);
    }
    @FXML
    private void addCloud(){
        int x = (int) (Math.random() * 500+10);
        int y = 40;

        Cloud c = new Cloud(x,y);
        pridajObj(c);
    }
    @FXML
    private void addRain(){
        int x = (int) (Math.random() * 500+10);
        int y = (int) (Math.random() * 300 +10);

        Raindrop r = new Raindrop(x,y);
        pridajObj(r);
    }
    @FXML
    private void addSnow(){
        int x = (int) (Math.random() * 500+10);
        int y = (int) (Math.random() * 300 +10);

        Snowflake s = new Snowflake(x,y);
        pridajObj(s);
    }
    @FXML
    private void stop(){
        WeatherObject.zastav();
    }
    @FXML
    private void Blue(){
        for(int i = 0; i < root.getChildren().size();i++){
            Node objekt = root.getChildren().get(i);
            if(objekt instanceof Cloud)
            {((Cloud) objekt).Farba(Color.BLUE);}
        }
    }
    @FXML
    private void Move(){
        for(int i = 0; i < root.getChildren().size();i++){
            Node objekt = root.getChildren().get(i);
            if(objekt instanceof WeatherObject)
            {((WeatherObject) objekt).posun();}
    }
    }
    }

