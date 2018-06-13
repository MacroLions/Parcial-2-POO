/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_2_POO;

import Edificacion.Edificacion;
import Tropa.Tropa;
import Vehiculos.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author Mai Perez
 */
public class Auxiliar extends Thread{
    static int fase=0;
    
    public static int RevisarEdificaciones(ArrayList lista, Edificacion EdificacionABuscar){
        int contador=0;
        for(int i = 0; i<lista.size();i++){
            if(lista.get(i).getClass()==EdificacionABuscar.getClass()){
                contador = contador+1;
            }    
        } 
        return contador;
    }
    
    public static int RecolectorMaster(ArrayList lista, Edificacion MaquinaRecursos){
        int contador=0;
        for(int i = 0; i<lista.size();i++){
            if(lista.get(i).getClass()==MaquinaRecursos.getClass()){
                Edificacion Master = (Edificacion) lista.get(i);
                contador=contador + Master.EntregarRecursos();
            }    
        } 
        return contador;
    }

    
    public static void RecursosCreatorMaster(ArrayList lista, Edificacion MaquinaRecursos){
        for(int i = 0; i<lista.size();i++){
            if(lista.get(i).getClass()==MaquinaRecursos.getClass()){
                Edificacion MaquinaRecursosMaster = (Edificacion) lista.get(i);
                MaquinaRecursosMaster.run();
            }    
        }
    }
    
    public static void TropaCreatorMaster(ArrayList lista, Edificacion MaquinaRecursos, ArrayList Tropas){
        for(int i = 0; i<lista.size();i++){
            if(lista.get(i).getClass()==MaquinaRecursos.getClass()){
                Edificacion MaquinaTropaMaster = (Edificacion) lista.get(i);
                if(MaquinaTropaMaster.isDisponibilidad()==false){
                    Tropa tropa=MaquinaTropaMaster.GenerarTropa();
                    if(tropa != null){
                        Tropas.add(tropa);
                    }
                }
                
            }    
        }
    }
    
     public static void VehiculoCreatorMaster(ArrayList lista, Edificacion MaquinaRecursos, ArrayList Vehiculos){
        for(int i = 0; i<lista.size();i++){
            if(lista.get(i).getClass()==MaquinaRecursos.getClass()){
                Edificacion MaquinaVehiculoMaster = (Edificacion) lista.get(i);
                if(MaquinaVehiculoMaster.isDisponibilidad()==false){
                    Vehiculo vehiculo=MaquinaVehiculoMaster.GenerarVehiculo();
                    if(vehiculo != null){
                        Vehiculos.add(vehiculo);
                    }
                }
                
            }    
        }
    }
     
    public static void ViajarMaster(ArrayList lista){
        for(int i=0;i<lista.size();i++){
            Tropa tropaMaster = (Tropa) lista.get(i);
            if(tropaMaster.isViajando()){
                tropaMaster.Viajar(getFase());
            }
        }
    }
    
    public static void AtacarMaster(ArrayList lista){
        for(int i=0;i<lista.size();i++){
            Tropa tropaMaster = (Tropa) lista.get(i);
            if(tropaMaster.isAtacando()){
                if(tropaMaster.getObjetivos().get(tropaMaster.getObjetivo()).isVivo()){
                    tropaMaster.getObjetivos().get(tropaMaster.getObjetivo()).RecibirDamage(tropaMaster.Atacar());
                    if(tropaMaster.getObjetivos().get(tropaMaster.getObjetivo()).isVivo()==false){
                        tropaMaster.getObjetivos().remove(tropaMaster.getObjetivo());
                        tropaMaster.setAtacando(false);
                    }
                }
            }
        }
    }

    
    //Gets and Sets globales. ¿?
    public static int getFase() {
        return fase;
    }

    public static void setFase(int fase) {
        Auxiliar.fase = fase;
    }
    

}
