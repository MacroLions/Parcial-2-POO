/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

import Parcial_2_POO.Jugador;

/**
 *
 * @author Maishi
 */
public class Camioneta implements Vehiculo {
    Jugador Propietario;
    private String Nombre = "Camioneta";
    private boolean Disponibilidad = true;

    public Jugador getPropietario() {
        return Propietario;
    }

    public void setPropietario(Jugador Propietario) {
        this.Propietario = Propietario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public boolean isDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(boolean Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }
    
    
    
}
