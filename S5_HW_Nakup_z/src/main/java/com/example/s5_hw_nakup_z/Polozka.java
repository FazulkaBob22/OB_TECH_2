package com.example.s5_hw_nakup_z;

public class Polozka {
    private String nazov;
    private int pocetk;

    public Polozka(String nazov, int pocetk){
        this.nazov = nazov;
        this.pocetk = pocetk;
    }
    public int getPocetk(){
        return pocetk;
    }
    public void setNazov(String nazov){
        this.nazov = nazov;
    }
    public void setPocetk(int pocetk){
        this.pocetk = pocetk;
    }
    @Override
    public String toString() {
        return nazov + " - " + pocetk + " ks";
    }
}
