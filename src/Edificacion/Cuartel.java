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
    private String Nombre = "Cuartel";
    private Jugador propitario;
    private int FaseSet=-1;
    private int TipoDeTropa = 0;
    private int EsperaDeTropa = 0;
    private boolean Disponibilidad=true;
    private ArrayList<Tropa> Tropas;
    String NombreEscuadron = "Escuadron";
    String NombreSuperSoldado = "Super Soldado";
    int DamageEscuadron;
    int DamageSuperSoldado;
    
    @Override
    public Tropa GenerarTropa(){
        if(this.FaseSet==-1){
            this.FaseSet=Auxiliar.getFase();
        }
        int comprobador = Auxiliar.getFase()-this.FaseSet;
        if(comprobador==EsperaDeTropa){
            setDisponibilidad(true);
            this.FaseSet=-1;
            Tropa tropa= TropaFactory.getTropa(this.TipoDeTropa);
            tropa.setPropietario(this.propitario);
            if(this.TipoDeTropa==1){
                tropa.setNombre(NombreEscuadron);
                tropa.setDamageBase(DamageEscuadron);
                System.out.println("El "+NombreEscuadron+" ha sido entrenado");
                System.out.println("");   
            }
            else if (this.TipoDeTropa==2){
                tropa.setNombre(NombreSuperSoldado);
                tropa.setDamageBase(DamageSuperSoldado);
                System.out.println("El "+NombreSuperSoldado+" ha sido entrenado");
                System.out.println("");
            }
            return tropa;
        }
        return null;
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
    
    @Override
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

    public String getNombreEscuadron() {
        return NombreEscuadron;
    }

    public void setNombreEscuadron(String NombreEscuadron) {
        this.NombreEscuadron = NombreEscuadron;
    }

    public String getNombreSuperSoldado() {
        return NombreSuperSoldado;
    }

    public void setNombreSuperSoldado(String NombreSuperSoldado) {
        this.NombreSuperSoldado = NombreSuperSoldado;
    }

    public int getDamageEscuadron() {
        return DamageEscuadron;
    }

    public void setDamageEscuadron(int DamageEscuadron) {
        this.DamageEscuadron = DamageEscuadron;
    }

    public int getDamageSuperSoldado() {
        return DamageSuperSoldado;
    }

    public void setDamageSuperSoldado(int DamageSuperSoldado) {
        this.DamageSuperSoldado = DamageSuperSoldado;
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
