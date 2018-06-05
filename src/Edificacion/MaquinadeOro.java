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
public class MaquinadeOro implements Edificacion {
    int Vida=1000;
    int RecursosGuardados;
    int tiempoAnterior=0;
    
    MaquinadeOro(){}
    
    @Override
    public void GenerarRecursos() {
        
        if(Vida!=0){
            int segundosActuales = new Date().getSeconds();
        
            if(tiempoAnterior==0){
                this.tiempoAnterior=segundosActuales;
            }
        
            this.RecursosGuardados= this.RecursosGuardados+ (segundosActuales-tiempoAnterior)*100;
        }
    }

    @Override
    public int EntregarRecursos() {
        if(RecursosGuardados>0){
            int Entregado = (int) this.RecursosGuardados;
            this.RecursosGuardados=0;
            return Entregado; 
        }
        else{
            System.out.println("No hay Oro");
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
