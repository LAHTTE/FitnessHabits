package com.strudelauxpommes.fitnesshabits.beverage;

/**
 * Created by Rico on 11/25/2017.
 */

public class Breuvage {
    static int nb_beverages = 0;
    int id;
    String name;
    int portion_ml;
    int quantite_ml;

    public Breuvage(String nom, int portion, int quantite){
        nb_beverages++;
        this.name = nom;
        this.portion_ml = portion;
        this.id = nb_beverages;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPortion_ml() {
        return portion_ml;
    }

    public int getQuantite_ml() {
        return quantite_ml;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPortion_ml(int portion_ml) {
        this.portion_ml = portion_ml;
    }

    public void setQuantite_ml(int quantite_ml) {
        this.quantite_ml = quantite_ml;
    }
}
