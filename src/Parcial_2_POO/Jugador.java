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
import Tropa.TropaFactory;
import Vehiculos.Vehiculo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mai Perez
 */
public class Jugador {
    private final String nombre;
    private Raza raza;
    private int OroTotal=2000;
    private int MagiaTotal=2000;
    private int Diamantes=10;
    private final ArrayList<Tropa> Tropas = new ArrayList();
    private final ArrayList<Edificacion> Edificaciones = new ArrayList();
    private final ArrayList<Cuartel> Cuarteles = new ArrayList();
    private final ArrayList<Vehiculo> Vehiculos = new ArrayList();
    private ArrayList<Edificacion> Objetivos = new ArrayList();
    

    
    
    Jugador(String nombre){
        this.nombre=nombre;
    }
    
    
    public boolean MenuJugador(){
        Scanner input = new Scanner(System.in);
        

        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(1));
        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(2));
        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(3));
        Auxiliar.TropaCreatorMaster(Cuarteles, EdificacionFactory.getEdificacion(4),Tropas);
        Auxiliar.AtacarMaster(Tropas, TropaFactory.getTropa(1));
        Auxiliar.AtacarMaster(Tropas, TropaFactory.getTropa(2));

        
        System.out.println("////Hola "+this.nombre+" ¿Que quieres en este turno?////");
        System.out.println("Recursos disponibles: Oro: "+this.OroTotal+" Magia: "+this.MagiaTotal+" Diamantes: "+this.Diamantes);
        System.out.println("1. Construir            4. Revisar Tropas");
        System.out.println("2. Recolectar Recursos  5. Atacar");
        System.out.println("3. Entrenar Tropa       6. Terminar Turno");

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
                RevisarTropas();
                break;
            case 5:
                Atacar();
                break;
            case 6:
                return false;
        }
        return true;
    }
    
    public void Construir(){
        Scanner input = new Scanner(System.in);
        System.out.println(">>Construir!");
        System.out.println("");
        System.out.println("Construcciones disponibles: ");
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
                    Cuartel cuartel = (Cuartel) EdificacionFactory.getEdificacion(op);
                    cuartel.setTropas(this.Tropas);
                    cuartel.setPropitario(this);
                    Cuarteles.add(cuartel);
                    Edificaciones.add(cuartel);
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
        System.out.println(">>Recolectar recursos!");
        System.out.println("");
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
        if(Cuarteles.isEmpty()){
                System.out.println("No hay Cuarteles ningún cuartel en la base");
        } 
        else{
            System.out.println(">>Entrenar tropa!");
            System.out.println("");
            for(int i = 0; i<this.Cuarteles.size() ;i++){
                Cuartel cuartel = Cuarteles.get(i);
                System.out.print((i+1)+") "+cuartel.getNombre());
                if(cuartel.isDisponibilidad()){
                    System.out.println(" Disponible: Si");    
                }
                else{
                    System.out.println(" Disponible: No");    
                }
            }
            System.out.println("");
            System.out.print("¿Cuál cuartel usará? Opcion: ");
            int NumCuartelElegido = input.nextInt();
            try{ 
                Cuartel CuartelElegido = Cuarteles.get(NumCuartelElegido-1);
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
                        CuartelElegido.setEsperaDeTropa(2);
                        CuartelElegido.start();
                        System.out.println("Se está entrenando un escuadron!");
                    }
                    else if(TropaElegida==2){
                        CuartelElegido.setDisponibilidad(false);
                        CuartelElegido.setTipoDeTropa(TropaElegida);
                        CuartelElegido.setEsperaDeTropa(4);
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
    };
    
    public void RevisarTropas(){
        if(this.Tropas.isEmpty()){
            System.out.println("No hay ningún tipo de tropa en la base.");
        }
        else{
            System.out.println("Tropas disponibles:");
            for(int i=1;i<=this.Tropas.size();i++){
                System.out.print(i+") "+this.Tropas.get(i-1).getNombre()+" ");
            }
            System.out.println("");
        }
    }
    
    public void Atacar(){
        if(this.Tropas.isEmpty()){
            System.out.println("No hay tropa disponible o vehiculos disponibles.");
        }
        else{
            if(this.Objetivos.isEmpty()){
                System.out.println("No hay objetivos disponibles (Esta funcion se quitará despues)");
            }
            else{
                System.out.println(">>Atacar!");
                System.out.println("");
                System.out.println("Objetivos disponibles: ");
                for(int i=0;i<this.Objetivos.size();i++){
                    System.out.println("Posicion: "+(i+1)+" Nombre del objetivo: "+this.Objetivos.get(i).getNombre());
                }
                Scanner input = new Scanner(System.in);
                System.out.print("Posición del objetivo a atacar: ");
                int objetivo = input.nextInt();
                System.out.println("");
                RevisarTropas();
                System.out.print("Tropa a mandar a atacar: ");
                int Tropa = input.nextInt();
                this.Tropas.get(Tropa-1).setObjetivo(objetivo);
                this.Tropas.get(Tropa-1).setViajando(true);
                this.Tropas.get(Tropa-1).setAtacando(true);
                
            }
            
        }
    
    }
    
    
    //Gets and Sets luego de esta linea. 

    public String getNombre() {
        return nombre;
    } 

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public int getOroTotal() {
        return OroTotal;
    }

    public void setOroTotal(int OroTotal) {
        this.OroTotal = OroTotal;
    }

    public int getMagiaTotal() {
        return MagiaTotal;
    }

    public void setMagiaTotal(int MagiaTotal) {
        this.MagiaTotal = MagiaTotal;
    }

    public int getDiamantes() {
        return Diamantes;
    }

    public void setDiamantes(int Diamantes) {
        this.Diamantes = Diamantes;
    }

    public ArrayList<Edificacion> getObjetivos() {
        return Objetivos;
    }

    public void setObjetivos(ArrayList<Edificacion> Objetivos) {
        this.Objetivos = Objetivos;
    }

    public ArrayList<Edificacion> getEdificaciones() {
        return Edificaciones;
    }
    

}
