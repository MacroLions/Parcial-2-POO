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
import Razas.RazaFactory;
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
    private Raza raza = RazaFactory.getRaza(1);
    private int RecursoTotal1=2000;
    private int RecursoTotal2=2000;
    private int RecursoTotal3=10;
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
        System.out.println("Recursos disponibles: "+raza.getNombreRecurso1()+": "+RecursoTotal1+" "+raza.getNombreRecurso2()+": "+this.RecursoTotal2+" " +raza.getNombreRecurso3()+": "+this.RecursoTotal3);
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
        System.out.println("1. "+raza.getNombreMaquinaRecurso1()+" (200 de "+raza.getNombreRecurso2()+")");
        System.out.println("2. "+raza.getNombreMaquinaRecurso2()+" (200 de "+raza.getNombreRecurso1()+")");
        System.out.println("3. "+raza.getNombreMaquinaRecurso3()+" (600 de "+raza.getNombreRecurso1()+", 600 de "+raza.getNombreRecurso2()+")");
        System.out.println("4. Cuartel de tropas (300 de " + raza.getNombreRecurso2()+", 2 "+raza.getNombreRecurso3()+")");
        
        System.out.print("Opcion: ");
        int op = input.nextInt();
        System.out.println("");
        
        switch(op){
            case 1:
                if(this.RecursoTotal2>=200){
                    this.RecursoTotal2=this.RecursoTotal2-200;
                    Edificaciones.add(EdificacionFactory.getEdificacion(op));
                    System.out.println("Se construyó "+raza.getNombreMaquinaRecurso1());
                    break;
                }
                else{
                    System.out.println("No hay suficiente "+raza.getNombreRecurso2());
                    break;
                }
            case 2:
                if(this.RecursoTotal1>=200){
                    this.RecursoTotal1=this.RecursoTotal1-200;
                    Edificaciones.add(EdificacionFactory.getEdificacion(op));
                    System.out.println("Se construyó "+raza.getNombreMaquinaRecurso2());
                    break;
                }
                else{
                    System.out.println("No hay suficiente "+raza.getNombreRecurso1());
                    break;
                }
            case 3:
                if(this.RecursoTotal1>=600&&this.RecursoTotal2>=600){
                    this.RecursoTotal1=this.RecursoTotal1-600;
                    this.RecursoTotal2=this.RecursoTotal2-600;
                    Edificaciones.add(EdificacionFactory.getEdificacion(op));
                    System.out.println("Se construyó "+raza.getNombreMaquinaRecurso3());
                    break;
                }
                else{
                    System.out.println("No hay suficiente "+raza.getNombreRecurso1()+" o "+raza.getNombreRecurso2()+" suficiente.");
                    break;
                }
            case 4:
                if(this.RecursoTotal2>=300&&this.RecursoTotal3>=2){
                    this.RecursoTotal2=this.RecursoTotal2-300;
                    this.RecursoTotal3=this.RecursoTotal3-2;
                    Cuartel cuartel = (Cuartel) EdificacionFactory.getEdificacion(op);
                    cuartel.setTropas(this.Tropas);
                    cuartel.setPropitario(this);
                    cuartel.setNombreEscuadron(raza.getNombreEscuadron());
                    cuartel.setNombreSuperSoldado(raza.getNombreSuperSoldado());
                    Cuarteles.add(cuartel);
                    Edificaciones.add(cuartel);
                    System.out.println("Se construyó Cuartel");
                    break;
                }
                else{
                    System.out.println("No hay suficiente "+raza.getNombreRecurso1()+" o "+raza.getNombreRecurso3()+" suficiente.");
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
                System.out.println(raza.getNombreMaquinaRecurso1()+" x"+Comprobador_1);
            }
            if(Comprobador_2!=0){
                System.out.println(raza.getNombreMaquinaRecurso2()+" x"+Comprobador_2);
            }
            if(Comprobador_3!=0){
                System.out.println(raza.getNombreMaquinaRecurso3()+" x"+Comprobador_3);
            }
            
            if(Comprobador_1==0&&Comprobador_2==0&&Comprobador_3==0){
                System.out.println("No hay Maquinas de recursos, solo otro tipo de edificaciones.");
            }
            if(Comprobador_1!=0||Comprobador_2!=0||Comprobador_3!=0){
                this.RecursoTotal1 = this.RecursoTotal1 + Auxiliar.RecolectorMaster(Edificaciones, EdificacionFactory.getEdificacion(1));
                this.RecursoTotal2 = this.RecursoTotal2 + Auxiliar.RecolectorMaster(Edificaciones, EdificacionFactory.getEdificacion(2));
                this.RecursoTotal3 = this.RecursoTotal3 + Auxiliar.RecolectorMaster(Edificaciones, EdificacionFactory.getEdificacion(3));
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
                    System.out.println("1. "+raza.getNombreEscuadron());
                    System.out.println("2. "+raza.getNombreSuperSoldado());
                    System.out.print("Opcion: ");
                    int TropaElegida=input.nextInt();
                    if(TropaElegida==1){
                        CuartelElegido.setDisponibilidad(false);
                        CuartelElegido.setTipoDeTropa(TropaElegida);
                        CuartelElegido.setEsperaDeTropa(2);
                        CuartelElegido.start();
                        System.out.println("Se está entrenando un "+raza.getNombreEscuadron());
                    }
                    else if(TropaElegida==2){
                        CuartelElegido.setDisponibilidad(false);
                        CuartelElegido.setTipoDeTropa(TropaElegida);
                        CuartelElegido.setEsperaDeTropa(4);
                        CuartelElegido.start();
                        System.out.println("Se está generando un "+raza.getNombreSuperSoldado());
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

    public int getRecursoTotal1() {
        return RecursoTotal1;
    }

    public void setRecursoTotal1(int RecursoTotal1) {
        this.RecursoTotal1 = RecursoTotal1;
    }

    public int getRecursoTotal2() {
        return RecursoTotal2;
    }

    public void setRecursoTotal2(int RecursoTotal2) {
        this.RecursoTotal2 = RecursoTotal2;
    }

    public int getRecursoTotal3() {
        return RecursoTotal3;
    }

    public void setRecursoTotal3(int RecursoTotal3) {
        this.RecursoTotal3 = RecursoTotal3;
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
