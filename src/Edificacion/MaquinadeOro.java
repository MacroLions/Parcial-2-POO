/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificacion;
import static java.lang.Thread.sleep;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mai Perez
 */
public class MaquinadeOro extends Thread implements Edificacion {
    int Vida=1000;
    int RecursosGuardados=0;
    Date tiempoAnterior=null;
    
    MaquinadeOro(){
        start();
    }
    
    @Override
    public void run(){
        GenerarRecursos();
        try {
            sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(MaquinadeDiamantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @Override
    public void GenerarRecursos() {
        
        while(this.Vida!=0){
            Date TiempoActual = new Date();
            if(tiempoAnterior==null){
                this.tiempoAnterior=TiempoActual;
            }
            float calculo= (int) (TiempoActual.getTime()-tiempoAnterior.getTime());
            this.RecursosGuardados=this.RecursosGuardados+(int)(calculo*0.02);
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
