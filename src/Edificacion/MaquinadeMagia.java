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
public class MaquinadeMagia implements Edificacion {
    int Vida=1000;
    int RecursosGuardados;
    Date tiempoAnterior=null;
    
    MaquinadeMagia(){}
    
    @Override
    public void GenerarRecursos() {
        if(this.Vida!=0){
            Date TiempoActual = new Date();
            if(tiempoAnterior==null){
                this.tiempoAnterior=TiempoActual;
            }
            float calculo= (int) (TiempoActual.getTime()-tiempoAnterior.getTime());
            this.RecursosGuardados=this.RecursosGuardados+(int)(calculo*0.04);
            this.tiempoAnterior=TiempoActual;
        }
    }

    @Override
    public int EntregarRecursos() {
        if(this.RecursosGuardados>=0){
            int Entregado = this.RecursosGuardados;
            this.RecursosGuardados=0;
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
    public void GenerarTropa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void GenerarVehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
