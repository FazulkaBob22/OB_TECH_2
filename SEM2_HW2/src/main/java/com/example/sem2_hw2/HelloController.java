package com.example.sem2_hw2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label cm1, mm1, m1, km1;
    @FXML
    private TextField field1;


    @FXML protected void kon(){
        double x = Double.parseDouble(field1.getText());
        mm1.setText("mm: " + x*1000);
        cm1.setText("cm: " + x*100);
        m1.setText("m: "+ x);
        km1.setText("km: " + x/1000);


    }


}
