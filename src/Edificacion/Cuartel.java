/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificacion;

import Parcial_2_POO.Auxiliar;
import Tropa.Tropa;
import Tropa.TropaFactory;


/**
 *
 * @author Mai Perez
 */
public class Cuartel extends Thread implements Edificacion{
    private int FaseSet=-1;
    private int TipoDeTropa = 0;
    private boolean Disponibilidad=true;
    
    public Tropa GenerarTropa1(int op){
        int FaseActual = Auxiliar.getFase();
        
        if(this.FaseSet==-1){
            this.FaseSet=FaseActual;
            switch(op){
                case 1:
                    Tropa Tropa= TropaFactory.getTropa(op);
                    int calculoFase=FaseActual-this.FaseSet;
                    while(Tropa.ComprobadorDisponibilidad(calculoFase)==false){
                        FaseActual = Auxiliar.getFase();
                        calculoFase=FaseActual-this.FaseSet;
                    }
                    this.FaseSet=-1;
                    return Tropa;
                case 2:
                    Tropa Tropa2= TropaFactory.getTropa(op);
                    int calculoFase2=FaseActual-this.FaseSet;
                    while(Tropa2.ComprobadorDisponibilidad(calculoFase2)==false){
                        FaseActual = Auxiliar.getFase();
                        calculoFase2=FaseActual-this.FaseSet;
                    }
                    this.FaseSet=-1;
                    return Tropa2;    
            }
        }
        else{
            System.out.println("El cuartel está siendo ocupado por otra tropa.");
        }
        
        return null;
    }
    
    public Tropa GenerarTropa(){
        int Fase0=Auxiliar.getFase();
        while(Auxiliar.getFase()-Fase0!=2){
        }
        System.out.println("La tropa ha sido generada");
        Tropa Tropa= TropaFactory.getTropa(this.TipoDeTropa);
        setDisponibilidad(true);
        return Tropa;
    }
    
    @Override
    public void run() {
        GenerarTropa();
    }

    public int getFaseSet() {
        return FaseSet;
    }

    public void setFaseSet(int FaseSet) {
        this.FaseSet = FaseSet;
    }

    public boolean isDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(boolean Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }

    public int getTipoDeTropa() {
        return TipoDeTropa;
    }

    public void setTipoDeTropa(int TipoDeTropa) {
        this.TipoDeTropa = TipoDeTropa;
    }
    
    
    


    @Override
    public int EntregarRecursos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void GenerarVehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RecibirDamage(int damage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
