/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificacion;

import Parcial_2_POO.Auxiliar;
import Tropa.Tropa;

/**
 *
 * @author Mai Perez
 */
public class Cuartel extends Thread implements Edificacion{
    private int FaseSet=-1;
    
    public Tropa GenerarTropa(int op){
        int FaseActual=Auxiliar.getFase();
        if(FaseSet==-1){
            FaseSet=FaseActual;
        }
        
        return null;
   
    }
    
    @Override
    public void run() {
        
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
