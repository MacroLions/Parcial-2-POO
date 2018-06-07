/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tropa;

/**
 *
 * @author Mai Perez
 */
public class Escuadron implements Tropa{
    int FaseInicial=0;
    int FaseUbicacion=0;
    int DamageBase=125;
    
    
    public Escuadron(){}
    
    @Override
    public int Atacar() {
        if(FaseUbicacion==2){
            return DamageBase;
        }
        else{
            System.out.println("El escuadron no pueden atacar ahora.");
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
        return ValorFase==2;
    }
    
}
