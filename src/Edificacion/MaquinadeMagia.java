/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificacion;
import java.util.Date;

/**
 *
 * @author Mai Perez
 */
public class MaquinadeMagia extends Thread implements Edificacion {
    int Vida=1000;
    float RecursosGuardados;
    int tiempoAnterior=0;
    
    MaquinadeMagia(){
        start();
    }
    
    @Override
    public void run(){
        GenerarRecursos();      
    }
    
    
    public void GenerarRecursos() {
        
        if(this.Vida!=0){
            Date DateActual = new Date();
            int TiempoActual= DateActual.getHours()*3600+DateActual.getMinutes()*60+DateActual.getSeconds();
            if(tiempoAnterior==0){
                this.tiempoAnterior=TiempoActual;
            }
            else{
                int calculo= TiempoActual-tiempoAnterior;
                this.RecursosGuardados=this.RecursosGuardados+ (float)(calculo*5);
                this.tiempoAnterior=TiempoActual;
            }
        }
    }

    @Override
    public int EntregarRecursos() {
        if(this.RecursosGuardados>=0){
            int Entregado = (int) this.RecursosGuardados;
            this.RecursosGuardados=this.RecursosGuardados-Entregado;
            return Entregado; 
        }
        else{
            return 0;
        }
    }
    
    @Override
    public void RecibirDamage(int damage){
        this.Vida=this.Vida-damage;
    };


    @Override
    public void GenerarVehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDisponibilidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
