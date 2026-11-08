package com.example.s6_z1;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField cisloField;

    @FXML private TextArea areaFaktorial;
    @FXML private TextArea areaMocnina;
    @FXML private TextArea areaFibonacci;

    @FXML private ProgressBar progressFaktorial;
    @FXML private ProgressBar progressMocnina;
    @FXML private ProgressBar progressFibonacci;
    @FXML
    protected void runTask() {
        int zaklad;

        try {
            zaklad = Integer.parseInt(cisloField.getText());

            if (zaklad <= 0) {
                System.out.println("Zadaj kladné číslo!");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("Zadaj platné celé číslo!");
            return;
        }

        areaFaktorial.clear();
        areaMocnina.clear();
        areaFibonacci.clear();

        progressFaktorial.setProgress(0);
        progressMocnina.setProgress(0);
        progressFibonacci.setProgress(0);

        Thread vlakno1 = new Thread(() -> {

            long faktorial = 1;

            for (int i = 1; i <= zaklad; i++) {

                faktorial *= i;

                String text = i + "! = " + faktorial;
                double progress = (double) i / zaklad;

                Platform.runLater(() -> {
                    areaFaktorial.appendText(text + "\n");
                    progressFaktorial.setProgress(progress);
                });

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        Thread vlakno2 = new Thread(() -> {

            long vysledok = 1;

            for (int i = 1; i <= zaklad; i++) {

                vysledok *= zaklad;

                String text = zaklad + "^" + i + " = " + vysledok;
                double progress = (double) i / zaklad;

                Platform.runLater(() -> {
                    areaMocnina.appendText(text + "\n");
                    progressMocnina.setProgress(progress);
                });

                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        Thread vlakno3 = new Thread(() -> {

            long a = 0;
            long b = 1;

            for (int i = 1; i <= zaklad; i++) {

                String text = String.valueOf(a);

                long dalsie = a + b;
                a = b;
                b = dalsie;

                double progress = (double) i / zaklad;

                Platform.runLater(() -> {
                    areaFibonacci.appendText(text + "\n");
                    progressFibonacci.setProgress(progress);
                });

                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        vlakno1.setDaemon(true);
        vlakno2.setDaemon(true);
        vlakno3.setDaemon(true);

        vlakno1.start();
        vlakno2.start();
        vlakno3.start();

    }

    }

