/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_2_POO;

import Edificacion.Cuartel;
import Edificacion.MaquinadeOro;
import Edificacion.MaquinadeMagia;
import Edificacion.MaquinadeDiamantes;
import Edificacion.Edificacion;
import Edificacion.EdificacionFactory;
import Edificacion.GeneradordeVehiculos;
import Razas.Raza;
import Razas.RazaFactory;
import Tropa.Tropa;
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
    private final ArrayList<GeneradordeVehiculos> GeneradoresDeVehiculos = new ArrayList();
    private final ArrayList<Vehiculo> Vehiculos = new ArrayList();
    private ArrayList<Edificacion> Objetivos = new ArrayList();
    

    
    
    Jugador(String nombre){
        this.nombre=nombre;
    }
    Jugador(String nombre, Raza raza){
        this.nombre=nombre;
        this.raza=raza;
    }
    
    
    public boolean MenuJugador(){
        Scanner input = new Scanner(System.in);
        

        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(1));
        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(2));
        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(3));
        Auxiliar.TropaCreatorMaster(Cuarteles, EdificacionFactory.getEdificacion(4),Tropas);
        Auxiliar.VehiculoCreatorMaster(GeneradoresDeVehiculos,EdificacionFactory.getEdificacion(5),Vehiculos);
        

        
        System.out.println("////¿Que haras ahora?////");
        System.out.println("Recursos disponibles: "+raza.getNombreRecurso1()+": "+RecursoTotal1+" //"+raza.getNombreRecurso2()+": "+this.RecursoTotal2+" //" +raza.getNombreRecurso3()+": "+this.RecursoTotal3);
        System.out.println("1. Construir            5. Revisar Tropas");
        System.out.println("2. Recolectar Recursos  6. Revisar Edificaciones");
        System.out.println("3. Entrenar Tropa       7. Atacar");
        System.out.println("4. Crear Vehiculo       8. Terminar Turno");

        System.out.print("Opcion: ");
        int op = 8;
        try{
            op = input.nextInt();
        }catch(Exception ex){}
        
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
                CrearVehiculo();
                break;
            case 5:
                RevisarTropas();
                break;
            case 6:
                RevisarEdificaciones();
                break;
            case 7:
                Atacar();
                break;
            case 8:
                return false;
            default:
                System.out.println("Escoja una opcion valida.");
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
        System.out.println("5. Generador de Vehiculos (200 de " + raza.getNombreRecurso1()+", 1 "+raza.getNombreRecurso3()+")");
        
        System.out.print("Opcion: ");
        try{
            int op = input.nextInt();
            System.out.println("");
            switch(op){
                case 1:
                    if(this.RecursoTotal2>=200){
                        this.RecursoTotal2=this.RecursoTotal2-200;
                        MaquinadeOro MaquinaRecurso1 = (MaquinadeOro) EdificacionFactory.getEdificacion(op);
                        MaquinaRecurso1.setPropitario(this);
                        Edificaciones.add(MaquinaRecurso1);
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
                        MaquinadeMagia MaquinaRecurso2 = (MaquinadeMagia) EdificacionFactory.getEdificacion(op);
                        MaquinaRecurso2.setPropitario(this);
                        Edificaciones.add(MaquinaRecurso2);
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
                        MaquinadeDiamantes MaquinaRecurso3 = (MaquinadeDiamantes) EdificacionFactory.getEdificacion(op);
                        MaquinaRecurso3.setPropitario(this);
                        Edificaciones.add(MaquinaRecurso3);
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
                        cuartel.setDamageEscuadron(raza.getAtaqueEscuadron());
                        cuartel.setDamageSuperSoldado(raza.getAtaqueSuperSoldado());
                        Cuarteles.add(cuartel);
                        Edificaciones.add(cuartel);
                        System.out.println("Se construyó Cuartel");
                        break;
                    }
                    else{
                        System.out.println("No hay suficiente "+raza.getNombreRecurso1()+" o "+raza.getNombreRecurso3()+" suficiente.");
                        break;
                    }
                case 5:
                    if(this.RecursoTotal2>=200&&this.RecursoTotal3>=1){
                        this.RecursoTotal2=this.RecursoTotal2-200;
                        this.RecursoTotal3=this.RecursoTotal3-1;
                        GeneradordeVehiculos generadordevehiculos = (GeneradordeVehiculos) EdificacionFactory.getEdificacion(op);
                        generadordevehiculos.setVehiculos(this.Vehiculos);
                        generadordevehiculos.setPropitario(this);
                        generadordevehiculos.setNombreVehiculo1(raza.getNombreVehiculo1());
                        generadordevehiculos.setNombreVehiculo1(raza.getNombreVehiculo2());
                        Edificaciones.add(generadordevehiculos);
                        GeneradoresDeVehiculos.add(generadordevehiculos);
                        System.out.println("Se construyó Generador de vehiculos");
                        break;
                    }
                    else{
                        System.out.println("No hay suficiente "+raza.getNombreRecurso1()+" o "+raza.getNombreRecurso3()+" suficiente.");
                        break;
                    }
                default:
                    System.out.println("Edificacion no existente.");
            }
        }catch(Exception ex){
            System.out.println("");
            System.out.println("Edificacion no valida");
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
                System.out.println("No hay Cuarteles en la base");
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
            try{ 
                int NumCuartelElegido = input.nextInt();
                Cuartel CuartelElegido = Cuarteles.get(NumCuartelElegido-1);
                if(CuartelElegido.isDisponibilidad()){
                    System.out.println("");
                    System.out.println("Tipo de tropa a entrenar:");
                    System.out.println("1. "+raza.getNombreEscuadron()+" (400 de "+raza.getNombreRecurso1()+", 300 de "+raza.getNombreRecurso2()+")");
                    System.out.println("2. "+raza.getNombreSuperSoldado()+" (600 de "+raza.getNombreRecurso2()+", 10 de "+raza.getNombreRecurso3()+")");
                    System.out.print("Opcion: ");
                    int TropaElegida=input.nextInt();
                    switch(TropaElegida){
                        case 1:
                            if(this.RecursoTotal1>=400&&this.RecursoTotal2>=300){
                                this.RecursoTotal1=this.RecursoTotal1-400;
                                this.RecursoTotal2=this.RecursoTotal2-300;
                                CuartelElegido.setDisponibilidad(false);
                                CuartelElegido.setTipoDeTropa(TropaElegida);
                                CuartelElegido.setEsperaDeTropa(raza.getEsperaEscuadron());
                                CuartelElegido.start();
                                System.out.println("Se está entrenando un "+raza.getNombreEscuadron());
                                break;
                            }
                            else{
                                System.out.println("No hay suficiente "+raza.getNombreRecurso1()+" o "+raza.getNombreRecurso2()+" suficiente.");
                                break;
                            }
                        case 2:
                            if(this.RecursoTotal2>=600&&this.RecursoTotal3>=10){
                                this.RecursoTotal2=this.RecursoTotal1-600;
                                this.RecursoTotal3=this.RecursoTotal2-10;
                                CuartelElegido.setDisponibilidad(false);
                                CuartelElegido.setTipoDeTropa(TropaElegida);
                                CuartelElegido.setEsperaDeTropa(raza.getEsperaSuperSoldado());
                                CuartelElegido.start();
                                System.out.println("Se está generando un "+raza.getNombreSuperSoldado());
                                break;
                            }
                            else{
                                System.out.println("No hay suficiente "+raza.getNombreRecurso2()+" o "+raza.getNombreRecurso3()+" suficiente.");
                                break;
                            }
                        default:
                            System.out.println("");
                            System.out.println("Ese tipo de tropa no existe.");
                    }
                }
                else{
                    System.out.println("El Cuartel Elegido no está disponible.");
                }
            }catch(Exception ex){
                System.out.println("Ese cuartel no existe o no es valido.");
            }     
        }
    };
    
    public void CrearVehiculo(){
        Scanner input = new Scanner(System.in);
        if(GeneradoresDeVehiculos.isEmpty()){
                System.out.println("No hay Cuarteles en la base");
        } 
        else{
            System.out.println(">>Generar vehiculos!");
            System.out.println("");
            for(int i = 0; i<this.GeneradoresDeVehiculos.size() ;i++){
                GeneradordeVehiculos generadordevehiculos = GeneradoresDeVehiculos.get(i);
                System.out.print((i+1)+") "+generadordevehiculos.getNombre());
                if(generadordevehiculos.isDisponibilidad()){
                    System.out.println(" Disponible: Si");    
                }
                else{
                    System.out.println(" Disponible: No");    
                }
            }
            System.out.println("");
            System.out.print("¿Cuál generador de vehiculos usará? Opcion: ");
            try{ 
                int NumGeneradorElegido = input.nextInt();
                GeneradordeVehiculos GeneradorElegido = GeneradoresDeVehiculos.get(NumGeneradorElegido-1);
                if(GeneradorElegido.isDisponibilidad()){
                    System.out.println("");
                    System.out.println("Tipo de vehiculo a entrenar:");
                    System.out.println("1. "+raza.getNombreVehiculo1()+" (400 de "+raza.getNombreRecurso1()+", 300 de "+raza.getNombreRecurso2()+")");
                    System.out.println("2. "+raza.getNombreVehiculo2()+" (600 de "+raza.getNombreRecurso2()+", 10 de "+raza.getNombreRecurso3()+")");
                    System.out.print("Opcion: ");
                    int VehiculoElegido=input.nextInt();
                    switch(VehiculoElegido){
                        case 1:
                            if(this.RecursoTotal1>=400&&this.RecursoTotal2>=300){
                                this.RecursoTotal1=this.RecursoTotal1-400;
                                this.RecursoTotal2=this.RecursoTotal2-300;
                                GeneradorElegido.setDisponibilidad(false);
                                GeneradorElegido.setTipoDeVehiculo(VehiculoElegido);
                                GeneradorElegido.setEsperaDeVehiculo(raza.getEsperaVehiculo1());
                                GeneradorElegido.start();
                                System.out.println("Se está generando un "+raza.getNombreVehiculo1());
                                break;
                            }
                            else{
                                System.out.println("No hay suficiente "+raza.getNombreRecurso1()+" o "+raza.getNombreRecurso2()+" suficiente.");
                                break;
                            }
                        case 2:
                            if(this.RecursoTotal2>=600&&this.RecursoTotal3>=10){
                                this.RecursoTotal2=this.RecursoTotal1-600;
                                this.RecursoTotal3=this.RecursoTotal2-10;
                                GeneradorElegido.setDisponibilidad(false);
                                GeneradorElegido.setTipoDeVehiculo(VehiculoElegido);
                                GeneradorElegido.setEsperaDeVehiculo(raza.getEsperaVehiculo2());
                                GeneradorElegido.start();
                                System.out.println("Se está generando un "+raza.getNombreVehiculo2());
                                break;
                            }
                            else{
                                System.out.println("No hay suficiente "+raza.getNombreRecurso2()+" o "+raza.getNombreRecurso3()+" suficiente.");
                                break;
                            }
                        default:
                            System.out.println("");
                            System.out.println("Ese tipo de vehiculo no existe.");
                    }
                }
                else{
                    System.out.println("El Generador Elegido no está disponible.");
                }
            }catch(Exception ex){
                System.out.println("Ese Generador no existe o no es valido.");
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
                System.out.print("Se encuentra en la base:");
                if(this.Tropas.get(i-1).getFaseUbicacion()==2){
                    System.out.println(" No, está en la base enemiga");
                }
                else if(this.Tropas.get(i-1).isViajando()){
                    System.out.println(" No, está viajando");
                }
                else{
                    System.out.println(" Si");
                }
            }
            System.out.println("");
        }
    }
    
    public void RevisarEdificaciones(){
        if(this.Edificaciones.isEmpty()){
            System.out.println("No hay edificaciones (Esto no debe estar cuando se agrege el HQ) Ya que implica que el otro jugado ganó.");
        }
        else{
            System.out.println("Edificaciones:");
            for(int i=1;i<=this.Edificaciones.size();i++){
                System.out.print(i+") "+this.Edificaciones.get(i-1).getNombre()+" Vida: "+this.Edificaciones.get(i-1).getVida()+"  ");
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
                try{
                    int Tropa = input.nextInt();
                    if(Tropas.get(Tropa-1).isViajando()){
                        System.out.println("Esa tropa ya se encuentra viajando y no puede cambiar de objetivo aún.");
                    }
                    else if(Tropas.get(Tropa-1).getFaseUbicacion()==2){
                        this.Tropas.get(Tropa-1).setObjetivos(Objetivos);
                        this.Tropas.get(Tropa-1).setObjetivo(objetivo-1);
                        System.out.println(this.Tropas.get(Tropa-1).getNombre()+" cambio su objetivo a "+this.Objetivos.get(objetivo-1).getNombre());
                        this.Tropas.get(Tropa-1).setAtacando(true);
                    }
                    else{
                        this.Tropas.get(Tropa-1).setFaseInicial(Auxiliar.getFase());
                        this.Tropas.get(Tropa-1).setObjetivos(Objetivos);
                        this.Tropas.get(Tropa-1).setObjetivo(objetivo-1);
                        this.Tropas.get(Tropa-1).setViajando(true);
                        System.out.println(this.Tropas.get(Tropa-1).getNombre()+" Comenzó su viaje a la base enemiga!");
                    }
                }catch(Exception ex){
                    System.out.println("Tropa u objetivo inexistente. ");
                }
                
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

    public ArrayList<Tropa> getTropas() {
        return Tropas;
    }
    

}
