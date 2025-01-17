package com.Exercitiul2.Laborator9;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Masina {
    @Id
    private String numarInmatriculare;
    private String marca;
    private int anFabricatie;
    private String culoare;
    private int numarKilometri;

    public String getNumarInmatriculare() {
        return numarInmatriculare;
    }

    public void setNumarInmatriculare(String numarInmatriculare) {
        this.numarInmatriculare = numarInmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getNumarKilometri() {
        return numarKilometri;
    }

    public void setNumarKilometri(int numarKilometri) {
        this.numarKilometri = numarKilometri;
    }
}

