/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificacion;

import Parcial_2_POO.Auxiliar;
import Parcial_2_POO.Jugador;
import Tropa.Tropa;
import Tropa.TropaFactory;
import java.util.ArrayList;


/**
 *
 * @author Mai Perez
 */
public class Cuartel extends Thread implements Edificacion{
    private String Nombre;
    private Jugador propitario;
    private int FaseSet=-1;
    private int TipoDeTropa = 0;
    private int EsperaDeTropa = 0;
    private boolean Disponibilidad=true;
    private ArrayList<Tropa> Tropas;
    
    public void GenerarTropa(){
        if(this.FaseSet==-1){
            this.FaseSet=Auxiliar.getFase();
        }
        int comprobador = Auxiliar.getFase()-this.FaseSet;
        if(comprobador==EsperaDeTropa){
            if(this.TipoDeTropa==1){
                System.out.println("El escuadron ha sido entrenado");
                System.out.println("");   
            }
            else if (this.TipoDeTropa==2){
                System.out.println("El Super Soldado ha sido entrenado");
                System.out.println("");
            }
            
            setDisponibilidad(true);
            this.FaseSet=-1;
            Tropa Tropa= TropaFactory.getTropa(this.TipoDeTropa);
            Tropa.setPropietario(this.propitario);
            Tropa.setNombre(String.valueOf(this.Tropas.size()+1));
            Tropas.add(Tropa);
        }
        
    }
    
    @Override
    public void run() {
        GenerarTropa();  
  
    }

    //Gets and sets.

    public Jugador getPropitario() {
        return propitario;
    }

    public void setPropitario(Jugador propitario) {
        this.propitario = propitario;
    }
    
    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    
    public String getNombre() {
        return Nombre;
    }
    
    public int getFaseSet() {
        return FaseSet;
    }

    public void setFaseSet(int FaseSet) {
        this.FaseSet = FaseSet;
    }

    @Override
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

    public ArrayList<Tropa> getTropas() {
        return Tropas;
    }

    public void setTropas(ArrayList<Tropa> Tropas) {
        this.Tropas = Tropas;
    }

    public int getEsperaDeTropa() {
        return EsperaDeTropa;
    }

    public void setEsperaDeTropa(int EsperaDeTropa) {
        this.EsperaDeTropa = EsperaDeTropa;
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
