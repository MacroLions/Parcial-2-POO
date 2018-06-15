/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificacion;

import Parcial_2_POO.Auxiliar;
import Parcial_2_POO.Jugador;
import Tropa.Tropa;
import Vehiculos.Vehiculo;
import Vehiculos.VehiculoFactory;
import java.util.ArrayList;


/**
 *
 * @author Mai Perez
 */
public class GeneradordeVehiculos extends Thread implements Edificacion{
    private String Nombre = "Generador de Vehiculos";
    private Jugador propitario;
    private int Vida=1000;
    private int FaseSet=-1;
    private int TipoDeVehiculo = 0;
    private int EsperaDeVehiculo = 0;
    private boolean Disponibilidad=true;
    private boolean Vivo=true;
    private ArrayList<Vehiculo> Vehiculos;
    String NombreVehiculo1 = "Motocicleta";
    String NombreVehiculo2 = "Camioneta";
    
    @Override
    public Vehiculo GenerarVehiculo(){
        if(this.FaseSet==-1){
            this.FaseSet=Auxiliar.getFase();
        }
        int comprobador = Auxiliar.getFase()-this.FaseSet;
        if(comprobador==EsperaDeVehiculo){
            Vehiculo vehiculo= VehiculoFactory.getVehiculo(this.TipoDeVehiculo);
            vehiculo.setPropietario(this.propitario);
            if(this.TipoDeVehiculo==1){
                vehiculo.setNombre(NombreVehiculo1);
                System.out.println(NombreVehiculo1+" se ha creado");
                setDisponibilidad(true);
                this.FaseSet=-1;
                this.EsperaDeVehiculo=0;
                this.TipoDeVehiculo=0;
                System.out.println("");   
            }
            else if (this.TipoDeVehiculo==2){
                vehiculo.setNombre(NombreVehiculo2);
                System.out.println(NombreVehiculo2+" se ha creado");
                setDisponibilidad(true);
                this.FaseSet=-1;
                this.EsperaDeVehiculo=0;
                this.TipoDeVehiculo=0;
                System.out.println("");
            }
            return vehiculo;
        }
        return null;
    }
    
    @Override
    public void run() {
        GenerarVehiculo();  
  
    }
    @Override
    public void RecibirDamage(int damage) {
        System.out.println("El Generador de Vehiculos de "+this.propitario.getNombre()+" recibio "+damage+" de daño");
        Vida=Vida-damage;
        if(Vida<=0){
            Vivo=false;
            //destroy();
        }
        
    }

    //Gets and sets.

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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

    public int getFaseSet() {
        return FaseSet;
    }

    public void setFaseSet(int FaseSet) {
        this.FaseSet = FaseSet;
    }

    public int getTipoDeVehiculo() {
        return TipoDeVehiculo;
    }

    public void setTipoDeVehiculo(int TipoDeVehiculo) {
        this.TipoDeVehiculo = TipoDeVehiculo;
    }

    public int getEsperaDeVehiculo() {
        return EsperaDeVehiculo;
    }

    public void setEsperaDeVehiculo(int EsperaDeVehiculo) {
        this.EsperaDeVehiculo = EsperaDeVehiculo;
    }

    public boolean isDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(boolean Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }

    public boolean isVivo() {
        return Vivo;
    }

    public void setVivo(boolean Vivo) {
        this.Vivo = Vivo;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return Vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> Vehiculos) {
        this.Vehiculos = Vehiculos;
    }

    public String getNombreVehiculo1() {
        return NombreVehiculo1;
    }

    public void setNombreVehiculo1(String NombreVehiculo1) {
        this.NombreVehiculo1 = NombreVehiculo1;
    }

    public String getNombreVehiculo2() {
        return NombreVehiculo2;
    }

    public void setNombreVehiculo2(String NombreVehiculo2) {
        this.NombreVehiculo2 = NombreVehiculo2;
    }

    @Override
    public int EntregarRecursos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tropa GenerarTropa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
