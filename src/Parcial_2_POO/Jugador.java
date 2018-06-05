/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_2_POO;

import Edificacion.Edificacion;
import Edificacion.EdificacionFactory;
import Razas.Raza;
import Tropa.Tropa;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mai Perez
 */
public class Jugador {
    private final String nombre;
    private Raza raza;
    private int OroTotal=1000;
    private int MagiaTotal=1000;
    private int Diamantes=1;
    private final ArrayList<Tropa> Tropas = new ArrayList();
    private final ArrayList<Edificacion> Edificaciones = new ArrayList();
    
    
    Jugador(String nombre){
        this.nombre=nombre;
    }
    
    
    public void MenuJugador(){
        Scanner input = new Scanner(System.in);
        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(1));
        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(2));
        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(3));
        
        System.out.println("////Hola "+this.nombre+" ¿Que quieres en este turno?////");
        System.out.println("Recursos disponibles: Oro: "+this.OroTotal+" Magia: "+this.MagiaTotal+" Diamantes: "+this.Diamantes);
        System.out.println("1. Construir");
        System.out.println("2. Recolectar Recursos");
        
        System.out.print("Opcion: ");
        int op = input.nextInt();
        System.out.println("");
        
        switch(op){
            case 1:
                Construir();
                break;
            case 2:
                RecolectarRecursos();
                break;
        }
    }
    
    public void Construir(){
        Scanner input = new Scanner(System.in);
        System.out.println("Construir:");
        System.out.println("1. Maquina de Oro");
        System.out.println("2. Maquina de Magia");
        System.out.println("3. Maquina de Diamantes");
        
        System.out.print("Opcion: ");
        int op = input.nextInt();
        System.out.println("");
        
        switch(op){
            case 1:
                Edificaciones.add(EdificacionFactory.getEdificacion(op));
                System.out.println("Se construyó maquina de Oro");
                break;
            case 2:
                Edificaciones.add(EdificacionFactory.getEdificacion(op));
                System.out.println("Se construyó maquina de Magia");
                break;
            case 3:
                Edificaciones.add(EdificacionFactory.getEdificacion(op));
                System.out.println("Se construyó maquina de diamantes");
                break;
        }
        
    };
    
    
    public void RecolectarRecursos(){
        Scanner input = new Scanner(System.in);
        if(Edificaciones.isEmpty()==false){
            System.out.println("Maquinas disponibles:");
            int Comprobador_1 = Auxiliar.RevisarEdificaciones(Edificaciones, EdificacionFactory.getEdificacion(1));
            int Comprobador_2 = Auxiliar.RevisarEdificaciones(Edificaciones, EdificacionFactory.getEdificacion(2));
            int Comprobador_3 = Auxiliar.RevisarEdificaciones(Edificaciones, EdificacionFactory.getEdificacion(3));
            
            if(Comprobador_1!=0){
                System.out.println("Maquina de Oro x"+Comprobador_1);
            }
            if(Comprobador_2!=0){
                System.out.println("Maquina de Magia x"+Comprobador_2);
            }
            if(Comprobador_3!=0){
                System.out.println("Maquina de Diamantes x"+Comprobador_3);
            }
            
            if(Comprobador_1==0&&Comprobador_2==0&&Comprobador_3==0){
                System.out.println("No hay Maquinas de recursos, solo otro tipo de edificaciones.");
            }
            if(Comprobador_1!=0||Comprobador_2!=0||Comprobador_3!=0){
                this.OroTotal = this.OroTotal + Auxiliar.RecolectorMaster(Edificaciones, EdificacionFactory.getEdificacion(1));
                this.MagiaTotal = this.MagiaTotal + Auxiliar.RecolectorMaster(Edificaciones, EdificacionFactory.getEdificacion(2));
                this.Diamantes = this.Diamantes + Auxiliar.RecolectorMaster(Edificaciones, EdificacionFactory.getEdificacion(3));
                System.out.println("Se ha recolectado todo lo posible");
                
            }
        }
        
        else if(Edificaciones.isEmpty()){
                System.out.println("No hay edificaciones");    
        }
           
    };
    
    public void Atacar(){};
    
    
}
