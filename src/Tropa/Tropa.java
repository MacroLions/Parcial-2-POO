/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tropa;

import Edificacion.Edificacion;
import Parcial_2_POO.Jugador;
import java.util.ArrayList;

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
    public void setObjetivo(int Objetivo);
    public void setAtacando(boolean Atacando);
    public void setViajando(boolean Viajando);
    public boolean isAtacando();
    public boolean isViajando();
    public ArrayList<Edificacion> getObjetivos();
    public int getObjetivo();
}
