package com.example.opak_1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;

import java.util.Locale;

public class HelloController {
    @FXML private ListView<Polozka> list;
    @FXML private TextField addNazov;
    @FXML private TextField addCislo;
    @FXML private TextField addTyp;
    @FXML private TextField addZaruka;
    @FXML private TextField addCena;
    @FXML private Button add;
    @FXML private Button remove;
    @FXML private Button update;
    @FXML private CheckBox myCheck;
    public static boolean zobrazZaruka = true;
    private ObservableList<Polozka> zoznam = FXCollections.observableArrayList();


    @FXML public void initialize(){
        list.setItems(zoznam);
        list.setEditable(true);
        list.getSelectionModel().selectedIndexProperty().addListener(((observable, oldValue, newValue) ->
                remove.setDisable(newValue==null)));
        list.setOnKeyPressed(e->{if(e.getCode() == KeyCode.DELETE) RemoveZaznam();});
        addNazov.setOnAction(e-> addCislo.requestFocus());
        addCislo.setOnAction(e-> addTyp.requestFocus());
        addTyp.setOnAction(e-> addZaruka.requestFocus());
        addZaruka.setOnAction(e-> addCena.requestFocus());
        addCena.setOnAction(e-> addZaznam());

    }
    @FXML protected void addZaznam(){
        String nazov = addNazov.getText().trim();
        if(nazov.isEmpty()) return;
        String typ = addTyp.getText().trim();
        if(typ.isEmpty()) return;
        try {
            int cislo = Integer.parseInt((addCislo.getText()));
            if (cislo< 0) return;
            int zaruka = Integer.parseInt((addZaruka.getText()));
            if (zaruka < 19900101) return;
            double cena = Double.parseDouble((addCena.getText()));
            if (cena <= 0.0) return;

            Polozka polozka = new Polozka(nazov, typ, cislo, cena, zaruka);
            zoznam.add(polozka);
            addNazov.clear();addCena.clear();addZaruka.clear();addCislo.clear();addTyp.clear();
            addNazov.requestFocus();
        }
        catch (NumberFormatException e){
            addCislo.setText("");addZaruka.setText("");addCena.setText("");
            addCislo.requestFocus();
        }
    }

    @FXML protected void RemoveZaznam(){
        Polozka chosen = list.getSelectionModel().getSelectedItem();
        if(chosen == null) return;
        zoznam.remove(chosen);
    }

    @FXML protected void EditZaznam(){
        Polozka chosen = list.getSelectionModel().getSelectedItem();
        String novN = addNazov.getText().trim();
        String novT = addTyp.getText().trim();
        if(chosen == null || novN.isEmpty() || novT.isEmpty()) return;
        try {
            int Ncislo = Integer.parseInt((addCislo.getText()));
            if (Ncislo< 0) return;
            int Nzaruka = Integer.parseInt((addZaruka.getText()));
            if (Nzaruka < 19900101) return;
            double Ncena = Double.parseDouble((addCena.getText()));
            if (Ncena <= 0.0) return;

            chosen.setNazov(novN);
            chosen.setTyp(novT);
            chosen.setCislo(Ncislo);
            chosen.setZaruka(Nzaruka);
            chosen.setCena(Ncena);
            list.refresh();
            addNazov.clear();addCena.clear();addZaruka.clear();addCislo.clear();addTyp.clear();
            addNazov.requestFocus();
        } catch (NumberFormatException e){
            addNazov.requestFocus();
        }

    }
    @FXML
    protected void ShowZaruka() {
    zobrazZaruka = myCheck.isSelected();
    list.refresh();
    }
}
