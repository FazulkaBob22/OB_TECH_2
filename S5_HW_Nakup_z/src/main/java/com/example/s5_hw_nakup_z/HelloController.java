package com.example.s5_hw_nakup_z;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class HelloController {
    @FXML private ListView<Polozka> list;
    @FXML private TextField name;
    @FXML private Button removeBtn;
    @FXML private TextField pocet;
    @FXML private Label celkovyPocet;

    private ObservableList<Polozka> zoznam = FXCollections.observableArrayList();

    @FXML public void initialize(){
        list.setItems(zoznam);
        list.setEditable(true);
        list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                removeBtn.setDisable(newValue==null));
        list.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.DELETE) remove();
        });
        name.setOnAction(e -> pocet.requestFocus());
        pocet.setOnAction(e->add());

        updatePocet();
    }


    @FXML
    protected void add(){
        String nazov = name.getText().trim();
        if(nazov.isEmpty()) return;

        try{
            int pocetk = Integer.parseInt((pocet.getText()));
            if (pocetk <= 0) return;
            Polozka polozka = new Polozka(nazov, pocetk);
            zoznam.add(polozka);

            name.clear();pocet.clear();
            name.requestFocus();
            updatePocet();

        } catch (NumberFormatException e){
            pocet.setText("");
            pocet.setPromptText("Zadali ste nevhodne cislo");
            pocet.requestFocus();
        }
    }
    @FXML
    protected void remove(){
        Polozka chosen = list.getSelectionModel().getSelectedItem();
        if(chosen == null) return;
        zoznam.remove(chosen);
        updatePocet();
    }
    @FXML
    protected void update(){
        Polozka chosen = list.getSelectionModel().getSelectedItem();
        String novN = name.getText().trim();
        if(chosen == null || novN.isEmpty()) return;
        try {
            int novP = Integer.parseInt(pocet.getText());
            if(novP <=0) return;


            chosen.setNazov(novN);
            chosen.setPocetk(novP);


            list.refresh();
            name.clear();
            pocet.clear();
            name.requestFocus();
            updatePocet();
        } catch (NumberFormatException e){
            pocet.requestFocus();
        }

    }
    private  void updatePocet(){
        int spolu = 0;
        for (Polozka p : zoznam){
            spolu += p.getPocetk();
        }
        celkovyPocet.setText("Celkovy pocet kusov: "+ spolu );
    }
}
