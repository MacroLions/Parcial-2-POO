/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_2_POO;

import Edificacion.Cuartel;
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
    
    
    public boolean MenuJugador(){
        Scanner input = new Scanner(System.in);
        

        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(1));
        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(2));
        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(3));
        Auxiliar.TropaCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(4));

        
        System.out.println("////Hola "+this.nombre+" ¿Que quieres en este turno?////");
        System.out.println("Recursos disponibles: Oro: "+this.OroTotal+" Magia: "+this.MagiaTotal+" Diamantes: "+this.Diamantes);
        System.out.println("1. Construir");
        System.out.println("2. Recolectar Recursos");
        System.out.println("3. Entrenar Tropa");
        System.out.println("4. Terminar Turno");
        
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
            case 3:
                EntrenarTropa();
                break;
            case 4:
                return false;
        }
        return true;
    }
    
    public void Construir(){
        Scanner input = new Scanner(System.in);
        System.out.println("Construir:");
        System.out.println("1. Maquina de Oro (200 de Magia)");
        System.out.println("2. Maquina de Magia (200 de oro)");
        System.out.println("3. Maquina de Diamantes (600 de Oro, 600 de Magia)");
        System.out.println("4. Cuartel de tropas (300 de Magia,1 Diamantes)");
        
        System.out.print("Opcion: ");
        int op = input.nextInt();
        System.out.println("");
        
        switch(op){
            case 1:
                if(this.MagiaTotal>=200){
                    this.MagiaTotal=this.MagiaTotal-200;
                    Edificaciones.add(EdificacionFactory.getEdificacion(op));
                    System.out.println("Se construyó maquina de Oro");
                    break;
                }
                else{
                    System.out.println("No hay suficiente Magia.");
                    break;
                }
            case 2:
                if(this.OroTotal>=200){
                    this.OroTotal=this.OroTotal-200;
                    Edificaciones.add(EdificacionFactory.getEdificacion(op));
                    System.out.println("Se construyó maquina de Magia");
                    break;
                }
                else{
                    System.out.println("No hay suficiente Oro.");
                    break;
                }
            case 3:
                if(this.OroTotal>=600&&this.MagiaTotal>=600){
                    this.OroTotal=this.OroTotal-600;
                    this.MagiaTotal=this.MagiaTotal-600;
                    Edificaciones.add(EdificacionFactory.getEdificacion(op));
                    System.out.println("Se construyó maquina de diamantes");
                    break;
                }
                else{
                    System.out.println("No hay Magia u Oro suficiente.");
                    break;
                }
            case 4:
                if(this.MagiaTotal>=300&&this.Diamantes>=1){
                    this.MagiaTotal=this.MagiaTotal-300;
                    this.Diamantes=this.Diamantes-1;
                    Edificaciones.add(EdificacionFactory.getEdificacion(op));
                    System.out.println("Se construyó Cuartel");
                    break;
                }
                else{
                    System.out.println("No hay Magia o Diamantes suficiente.");
                    break;
                }
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
    
    
    public void EntrenarTropa(){
        Scanner input = new Scanner(System.in);
        if(Edificaciones.isEmpty()==false){
            System.out.println("Cuarteles disponibles:");
            int Comprobador_1 = Auxiliar.RevisarEdificaciones(Edificaciones, EdificacionFactory.getEdificacion(4));
        
            if(Comprobador_1==0){
                System.out.println("No hay Cuarteles, solo otro tipo de edificaciones.");
            }
            
            int contador = 1;
            for(int i = 0; i<this.Edificaciones.size() ;i++){
                Edificacion EdificacionABuscar = EdificacionFactory.getEdificacion(4);
                if(Edificaciones.get(i).getClass()==EdificacionABuscar.getClass()){
                    Cuartel cuartel = (Cuartel) Edificaciones.get(i);
                    System.out.println("Cuartel #"+i+" Disponibilidad: "+cuartel.isDisponibilidad());
                    contador= contador+1;
                }
                    
            }
            System.out.println("");
            System.out.print("¿Cuál cuartel usará? Opcion: ");
            int NumCuartelElegido = input.nextInt();
            try{
                Cuartel CuartelElegido = (Cuartel) Edificaciones.get(NumCuartelElegido);
                if(CuartelElegido.isDisponibilidad()){
                System.out.println("");
                System.out.println("Tipo de tropa a entrenar:");
                System.out.println("1. Escuadron");
                System.out.println("2. Super Soldado");
                System.out.print("Opcion: ");
                int TropaElegida=input.nextInt();
                if(TropaElegida==1){
                    CuartelElegido.setDisponibilidad(false);
                    CuartelElegido.setTipoDeTropa(TropaElegida);
                    CuartelElegido.start();
                    System.out.println("Se está entrenando un escuadron!");
                }
                else if(TropaElegida==2){
                    CuartelElegido.setDisponibilidad(false);
                    CuartelElegido.setTipoDeTropa(TropaElegida);
                    CuartelElegido.start();
                    System.out.println("Se está generando un super soldado");
                }
            }
            else{
                System.out.println("El Cuartel Elegido no está disponible.");
            }

            }catch(Exception ex){
                System.out.println("Ese cuartel no existe.");   
            }
            
        }
        
        else if(Edificaciones.isEmpty()){
                System.out.println("No hay edificaciones");    
        }
           
    };
    
    public void Atacar(){};
    
    
}
