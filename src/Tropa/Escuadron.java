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
 * @author Mai Perez
 */

public class Escuadron implements Tropa{
    Jugador Propietario; //Listo
    String nombre = "Escuadron"; //Listo
    int DamageBase=100; //Listo
    
    int FaseInicial=0;//Listo
    int FaseUbicacion=0;//Se supone funciona en Viajando.
    
    ArrayList <Edificacion> Objetivos;
    int Objetivo;
    
    boolean Viajando=false;//Funciona con el global de Viajando.
    boolean Atacando=false;//Funciona con el global de Atacando.
       
    
    
    @Override
    public int Atacar() {
        if(FaseUbicacion==2){
            return DamageBase;
        }
        else if(FaseUbicacion<2){
            return 0;
        }
        return 0;
    }

    @Override
    public void Viajar(int FaseActual){
        if(FaseUbicacion<2){
            System.out.println("El "+this.nombre+" de "+this.Propietario.getNombre()+" aún está viajando.");
            this.FaseUbicacion= FaseActual - this.FaseInicial;
        }
        else if(FaseUbicacion==2){
            System.out.println("El "+this.nombre+" de "+this.Propietario.getNombre()+" ya llegó");
            this.Atacando=true;
        }
    }

    //Gets and sets.
    @Override
    public Jugador getPropietario() {
        return Propietario;
    }
    
    @Override
    public void setPropietario(Jugador Propietario) {
        this.Propietario = Propietario;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public int getDamageBase() {
        return DamageBase;
    }
    
    @Override
    public void setDamageBase(int DamageBase) {
        this.DamageBase = DamageBase;
    }
    
    @Override
    public int getFaseInicial() {
        return FaseInicial;
    }
    
    @Override
    public void setFaseInicial(int FaseInicial) {
        this.FaseInicial = FaseInicial;
    }
    
    @Override
    public int getFaseUbicacion() {
        return FaseUbicacion;
    }
    
    @Override
    public void setFaseUbicacion(int FaseUbicacion) {
        this.FaseUbicacion = FaseUbicacion;
    }
    
    @Override
    public ArrayList<Edificacion> getObjetivos() {
        return Objetivos;
    }
    
    @Override
    public void setObjetivos(ArrayList<Edificacion> Objetivos) {
        this.Objetivos = Objetivos;
    }
    
    @Override
    public int getObjetivo() {
        return Objetivo;
    }
    
    @Override
    public void setObjetivo(int Objetivo) {
        this.Objetivo = Objetivo;
    }
    
    @Override
    public boolean isViajando() {
        return Viajando;
    }
    
    @Override
    public void setViajando(boolean Viajando) {
        this.Viajando = Viajando;
    }
    
    @Override
    public boolean isAtacando() {
        return Atacando;
    }

    @Override
    public void setAtacando(boolean Atacando) {
        this.Atacando = Atacando;
    }

}
