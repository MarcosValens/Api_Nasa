package com.esliceu.model;

public class Asteroid {
    private String nombre;
    private double velocidad;
    private boolean esPeligroso;
    private double tamano;

    public Asteroid(String nombre, double velocidad, boolean esPeligroso, double tamano) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.esPeligroso = esPeligroso;
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public boolean isEsPeligroso() {
        return esPeligroso;
    }

    public double getTamano() {
        return tamano;
    }
}
