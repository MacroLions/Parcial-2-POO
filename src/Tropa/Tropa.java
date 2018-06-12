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
    //Metodos basicos?
    public int Atacar();
    public void Viajar(int FaseActual);
    
    //Metodos necesarios para sets locos ¿
    public Jugador getPropietario();
    public void setPropietario(Jugador Propietario);
    public String getNombre();
    public void setNombre(String nombre);
    public int getDamageBase();
    public void setDamageBase(int DamageBase);
    public int getFaseInicial();
    public void setFaseInicial(int FaseInicial);
    public int getFaseUbicacion();
    public void setFaseUbicacion(int FaseUbicacion);
    public ArrayList<Edificacion> getObjetivos();
    public void setObjetivos(ArrayList<Edificacion> Objetivos);
    public int getObjetivo();
    public void setObjetivo(int Objetivo);
    public boolean isViajando();
    public void setViajando(boolean Viajando);
    public boolean isAtacando();
    public void setAtacando(boolean Atacando);

}
