/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tropa;

import Edificacion.Edificacion;
import Parcial_2_POO.Auxiliar;
import Parcial_2_POO.Jugador;
import java.util.ArrayList;

/**
 *
 * @author Mai Perez
 */

public class Escuadron implements Tropa{
    Jugador Propietario;
    String nombre;
    int FaseInicial=0;
    int FaseUbicacion=0;
    
    ArrayList <Edificacion> Objetivos;
    int Objetivo;
    
    int DamageBase=100;
    
    boolean Viajando=false;
    boolean Atacando=false;
       
    
    
    @Override
    public int Atacar() {
        if(FaseUbicacion==2){
            return DamageBase;
        }
        else if(FaseUbicacion<2){
            System.out.println("El escuadron "+this.nombre+" de "+this.Propietario+" aún está viajando.");
            return 0;
        }
        return 0;
    }

    @Override
    public boolean Viajar(int FaseActual){
        if(FaseUbicacion<2){
            this.FaseUbicacion= FaseActual - this.FaseInicial;
            return false;
        }
        else if(FaseUbicacion==2){
            System.out.println("El escuadron ya llegó");
            return true;
        }
        return true;
    }

    @Override
    public boolean ComprobadorDisponibilidad(int ValorFase) {
        return ValorFase==2;
    }
    
    
    //Gets y Sets

    public Jugador getPropietario() {
        return Propietario;
    }
    
    @Override
    public void setPropietario(Jugador Propietario) {
        this.Propietario = Propietario;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFaseInicial() {
        return FaseInicial;
    }

    public void setFaseInicial(int FaseInicial) {
        this.FaseInicial = FaseInicial;
    }

    public int getFaseUbicacion() {
        return FaseUbicacion;
    }

    public void setFaseUbicacion(int FaseUbicacion) {
        this.FaseUbicacion = FaseUbicacion;
    }

    public ArrayList<Edificacion> getObjetivos() {
        return Objetivos;
    }

    public void setObjetivos(ArrayList<Edificacion> Objetivos) {
        this.Objetivos = Objetivos;
    }

    public int getObjetivo() {
        return Objetivo;
    }

    public void setObjetivo(int Objetivo) {
        this.Objetivo = Objetivo;
    }

    public int getDamageBase() {
        return DamageBase;
    }

    public void setDamageBase(int DamageBase) {
        this.DamageBase = DamageBase;
    }

    public boolean isViajando() {
        return Viajando;
    }

    public void setViajando(boolean Viajando) {
        this.Viajando = Viajando;
    }

    public boolean isAtacando() {
        return Atacando;
    }

    public void setAtacando(boolean Atacando) {
        this.Atacando = Atacando;
    }

    
}
