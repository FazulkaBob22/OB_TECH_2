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
        try {
            double x = Double.parseDouble(field1.getText());

            if (x * 1000 == (int) (x * 1000)) {
                int y = (int) (x * 1000);
                mm1.setText("mm: " + y);
            } else {
                mm1.setText("mm: " + (x * 1000));
            }
            if (x * 100 == (int) (x * 100)) {
                int y = (int) (x * 100);
                cm1.setText("cm: " + y);
            } else {
                cm1.setText("cm: " + x * 100);
            }

            if (x == (int) x) {
                int y = (int) x;
                m1.setText("m: " + y);
            } else {
                m1.setText("m: " + x);
            }

            if (x / 1000 == (int) (x / 1000)) {
                int y = (int) (x / 1000);
                km1.setText("km: " + y);
            } else {
                km1.setText("km: " + x / 1000);
            }
        }
        catch (NumberFormatException e) {
            mm1.setText("neciselna hodnota");
            m1.setText("neciselna hodnota");
            cm1.setText("neciselna hodnota");
            km1.setText("neciselna hodnota");
        }

    }


}
