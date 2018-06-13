/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificacion;
import Parcial_2_POO.Jugador;
import Tropa.Tropa;
import java.util.Date;


/**
 *
 * @author Mai Perez
 */
public class MaquinadeDiamantes extends Thread implements Edificacion {
    private final String nombre = "Maquina de Diamantes";
    private Jugador propitario;
    int Vida=1000;
    private boolean Vivo=true;
    float RecursosGuardados;
    int tiempoAnterior=0;
    
    
    MaquinadeDiamantes(){
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
                this.RecursosGuardados=this.RecursosGuardados+ (float)(calculo*.05);
                this.tiempoAnterior=TiempoActual;
            }
        }
    }

    @Override
    public int EntregarRecursos() {
        if(this.RecursosGuardados>=1){
            int Entregado = (int) this.RecursosGuardados;
            this.RecursosGuardados=this.RecursosGuardados-Entregado;
            return Entregado; 
        }
        else{
            return 0;
        }
    }
    
    @Override
    public void RecibirDamage(int damage) {
        System.out.println(this.nombre+" de "+this.propitario.getNombre()+" recibio "+damage+" de daño");
        Vida=Vida-damage;
        if(Vida<=0){
            Vivo=false;
        }
        
    }

    
    //Gets and sets
    @Override
    public String getNombre() {
        return nombre;
    }
    
    public Jugador getPropitario() {
        return propitario;
    }

    public void setPropitario(Jugador propitario) {
        this.propitario = propitario;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int Vida) {
        this.Vida = Vida;
    }
    
    public boolean isVivo() {
        return Vivo;
    }

    public void setVivo(boolean Vivo) {
        this.Vivo = Vivo;
    }

    public float getRecursosGuardados() {
        return RecursosGuardados;
    }

    public void setRecursosGuardados(float RecursosGuardados) {
        this.RecursosGuardados = RecursosGuardados;
    }

    public int getTiempoAnterior() {
        return tiempoAnterior;
    }

    public void setTiempoAnterior(int tiempoAnterior) {
        this.tiempoAnterior = tiempoAnterior;
    }
    
    

    //Not suported. 
    @Override
    public void GenerarVehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDisponibilidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tropa GenerarTropa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
