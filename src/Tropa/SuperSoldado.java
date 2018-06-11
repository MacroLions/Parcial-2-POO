/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tropa;

import Parcial_2_POO.Jugador;

/**
 *
 * @author Mai Perez
 */
public class SuperSoldado implements Tropa{
    Jugador Propietario;
    String nombre = "Super soldado";
    int FaseInicial=0;
    int FaseUbicacion=0;
    int DamageBase=250;

    @Override
    public int Atacar() {
        if(FaseUbicacion==2){
            return DamageBase;
        }
        else{
            System.out.println("El Super Soldado no pueden atacar ahora.");
            return 0;
        }
    }

    @Override
    public boolean Viajar(int FaseActual){
        if(FaseUbicacion<2){
            this.FaseUbicacion= FaseActual - this.FaseInicial;
            return true;
        }
        else{
            System.out.println("El escuadron ya llegó");
            return false;
        }
    }

    @Override
    public boolean ComprobadorDisponibilidad(int ValorFase) {
        return ValorFase==4;
    }

    @Override
    public void setPropietario(Jugador Propietario) {
        this.Propietario=Propietario;
    }
    @Override
    public String getNombre(){
        return nombre;
    }
    
    @Override
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }
    
}
