/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_2_POO;

import Edificacion.Edificacion;
import java.util.ArrayList;

/**
 *
 * @author Mai Perez
 */
public class Auxiliar {
    //Esto es como se haría una variable global xD static int contador=0;
    
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
                MaquinaRecursosMaster.GenerarRecursos();
            }    
        }
    }



}
