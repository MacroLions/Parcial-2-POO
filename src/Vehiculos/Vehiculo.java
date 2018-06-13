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
public interface Vehiculo {
    public void setNombre(String Nombre);
    public String getNombre();
    public boolean isDisponibilidad();
    public void setPropietario(Jugador Propietario);
    
}
