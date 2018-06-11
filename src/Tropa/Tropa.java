/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tropa;

import Parcial_2_POO.Jugador;

/**
 *
 * @author Maishi
 */
public interface Tropa {
    public int Atacar();
    public boolean Viajar(int FaseActual);
    public boolean ComprobadorDisponibilidad(int ValorFase);
    public void setPropietario(Jugador Propietario);
    public void setNombre(String nombre);
    public String getNombre();
}
