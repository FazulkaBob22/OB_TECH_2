package com.example.opak_1;

public class Polozka {
    private String nazov;
    private String typ;
    private int cislo;
    private double cena;
    private int zaruka;

    public Polozka(String nazov, String typ, int cislo, double cena, int zaruka){
        this.nazov = nazov;
        this.typ = typ;
        this.cislo = cislo;
        this.cena = cena;
        this.zaruka = zaruka;

    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }
    public void setTyp(String typ){
        this.typ = typ;
    }

    public void setCislo(int cislo) {
        this.cislo = cislo;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setZaruka(int zaruka) {
        this.zaruka = zaruka;
    }
    @Override
    public String toString(){
        if(HelloController.zobrazZaruka){
        return "Zaruka do: " + zaruka;}
        else {
            return "SN: " + cislo + " - " + nazov;
        }

    }

}
