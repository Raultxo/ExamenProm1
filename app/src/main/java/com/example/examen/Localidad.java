package com.example.examen;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Localidad implements Serializable {

    private String nombre, provincia, tipo, web;
    private Drawable img;

    public Localidad (String nombre, String provincia, String tipo, Drawable img, String web) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.tipo = tipo;
        this.web = web;
        this.img = img;
    }

    public Drawable getImg() {
        return img;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getTipo() {
        return tipo;
    }

    public String getWeb() {
        return web;
    }

}
