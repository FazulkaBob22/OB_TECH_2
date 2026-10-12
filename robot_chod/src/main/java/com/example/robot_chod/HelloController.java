package com.example.robot_chod;

import javafx.fxml.FXML;

import javafx.scene.layout.Pane;

public class HelloController {
    @FXML
    private Pane root;
    Robotik robot;
@FXML public void initialize(){
    robot = new Robotik(100, 100, root);
    root.getChildren().add(robot);
    robot.requestFocus();}


    }

