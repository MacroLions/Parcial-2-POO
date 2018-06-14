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
import Edificacion.HQ;
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
    private HQ HQ;
    private final ArrayList<Tropa> Tropas = new ArrayList();
    private final ArrayList<Edificacion> Edificaciones = new ArrayList();
    private final ArrayList<Cuartel> Cuarteles = new ArrayList();
    private final ArrayList<GeneradordeVehiculos> GeneradoresDeVehiculos = new ArrayList();
    private final ArrayList<Vehiculo> Vehiculos = new ArrayList();
    private ArrayList<Edificacion> Objetivos = new ArrayList();
    
    
    
    Jugador(String nombre){
        this.nombre=nombre;
        HQ = new HQ();
        HQ.setPropitario(this);
        Edificaciones.add(HQ);
    }
    Jugador(String nombre, Raza raza){
        this.nombre=nombre;
        this.raza=raza;
        HQ = new HQ();
        HQ.setPropitario(this);
        Edificaciones.add(HQ);
    }
    
    
    public boolean MenuJugador(){
        Scanner input = new Scanner(System.in);
        

        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(1));
        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(2));
        Auxiliar.RecursosCreatorMaster(Edificaciones, EdificacionFactory.getEdificacion(3));
        Auxiliar.TropaCreatorMaster(Cuarteles, EdificacionFactory.getEdificacion(4),Tropas);
        Auxiliar.VehiculoCreatorMaster(GeneradoresDeVehiculos,EdificacionFactory.getEdificacion(5),Vehiculos);
        

        
        System.out.println("////¿Que haras ahora?////");
        System.out.println("Recursos disponibles: "+raza.getNombreRecurso1()+": "+HQ.getRecursoTotal1()+" //"+raza.getNombreRecurso2()+": "+HQ.getRecursoTotal2()+" //" +raza.getNombreRecurso3()+": "+HQ.getRecursoTotal3());
        System.out.println("1. Construir            5. Revisar Tropas");
        System.out.println("2. Recolectar Recursos  6. Revisar Edificaciones y Vehiculos");
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
                RevisarVehiculos();
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
                    if(HQ.getRecursoTotal2()>=200){
                        HQ.setRecursoTotal2(HQ.getRecursoTotal2()-200);
                        MaquinadeOro MaquinaRecurso1 = (MaquinadeOro) EdificacionFactory.getEdificacion(op);
                        MaquinaRecurso1.setPropitario(this);
                        Edificaciones.add(MaquinaRecurso1);
                        System.out.println("Se construyó "+raza.getNombreMaquinaRecurso1());
                        System.out.println("");
                        break;
                    }
                    else{
                        System.out.println("No hay suficiente "+raza.getNombreRecurso2());
                        break;
                    }
                case 2:
                    if(HQ.getRecursoTotal1()>=200){
                        HQ.setRecursoTotal1(HQ.getRecursoTotal1()-200);
                        MaquinadeMagia MaquinaRecurso2 = (MaquinadeMagia) EdificacionFactory.getEdificacion(op);
                        MaquinaRecurso2.setPropitario(this);
                        Edificaciones.add(MaquinaRecurso2);
                        System.out.println("Se construyó "+raza.getNombreMaquinaRecurso2());
                        System.out.println("");
                        break;
                    }
                    else{
                        System.out.println("No hay suficiente "+raza.getNombreRecurso1());
                        break;
                    }
                case 3:
                    if(HQ.getRecursoTotal1()>=600&&HQ.getRecursoTotal2()>=600){
                        HQ.setRecursoTotal1(HQ.getRecursoTotal1()-600);
                        HQ.setRecursoTotal2(HQ.getRecursoTotal2()-600);
                        MaquinadeDiamantes MaquinaRecurso3 = (MaquinadeDiamantes) EdificacionFactory.getEdificacion(op);
                        MaquinaRecurso3.setPropitario(this);
                        Edificaciones.add(MaquinaRecurso3);
                        System.out.println("Se construyó "+raza.getNombreMaquinaRecurso3());
                        System.out.println("");
                        break;
                    }
                    else{
                        System.out.println("No hay suficiente "+raza.getNombreRecurso1()+" o "+raza.getNombreRecurso2()+" suficiente.");
                        break;
                    }
                case 4:
                    if(HQ.getRecursoTotal2()>=300&&HQ.getRecursoTotal3()>=2){
                        HQ.setRecursoTotal2(HQ.getRecursoTotal2()-300);
                        HQ.setRecursoTotal3(HQ.getRecursoTotal3()-2);
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
                        System.out.println("");
                        break;
                    }
                    else{
                        System.out.println("No hay suficiente "+raza.getNombreRecurso1()+" o "+raza.getNombreRecurso3()+" suficiente.");
                        break;
                    }
                case 5:
                    if(HQ.getRecursoTotal2()>=200&&HQ.getRecursoTotal3()>=1){
                        HQ.setRecursoTotal2(HQ.getRecursoTotal2()-200);
                        HQ.setRecursoTotal3(HQ.getRecursoTotal3()-1);
                        GeneradordeVehiculos generadordevehiculos = (GeneradordeVehiculos) EdificacionFactory.getEdificacion(op);
                        generadordevehiculos.setVehiculos(this.Vehiculos);
                        generadordevehiculos.setPropitario(this);
                        generadordevehiculos.setNombreVehiculo1(raza.getNombreVehiculo1());
                        generadordevehiculos.setNombreVehiculo2(raza.getNombreVehiculo2());
                        Edificaciones.add(generadordevehiculos);
                        GeneradoresDeVehiculos.add(generadordevehiculos);
                        System.out.println("Se construyó Generador de vehiculos");
                        System.out.println("");
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
                HQ.setRecursoTotal1(HQ.getRecursoTotal1() + Auxiliar.RecolectorMaster(Edificaciones, EdificacionFactory.getEdificacion(1)));
                HQ.setRecursoTotal2(HQ.getRecursoTotal2() + Auxiliar.RecolectorMaster(Edificaciones, EdificacionFactory.getEdificacion(2)));
                HQ.setRecursoTotal3(HQ.getRecursoTotal3() + Auxiliar.RecolectorMaster(Edificaciones, EdificacionFactory.getEdificacion(3)));
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
                            if(HQ.getRecursoTotal1()>=400&&HQ.getRecursoTotal2()>=300){
                                HQ.setRecursoTotal1(HQ.getRecursoTotal1()-400);
                                HQ.setRecursoTotal2(HQ.getRecursoTotal2()-300);
                                CuartelElegido.setDisponibilidad(false);
                                CuartelElegido.setTipoDeTropa(TropaElegida);
                                CuartelElegido.setEsperaDeTropa(raza.getEsperaEscuadron());
                                CuartelElegido.start();
                                System.out.println("Se está entrenando un "+raza.getNombreEscuadron());
                                System.out.println("");
                                break;
                            }
                            else{
                                System.out.println("No hay suficiente "+raza.getNombreRecurso1()+" o "+raza.getNombreRecurso2()+" suficiente.");
                                System.out.println("");
                                break;
                            }
                        case 2:
                            if(HQ.getRecursoTotal2()>=600&&HQ.getRecursoTotal3()>=10){
                                HQ.setRecursoTotal2(HQ.getRecursoTotal2()-600);
                                HQ.setRecursoTotal3(HQ.getRecursoTotal3()-10);
                                CuartelElegido.setDisponibilidad(false);
                                CuartelElegido.setTipoDeTropa(TropaElegida);
                                CuartelElegido.setEsperaDeTropa(raza.getEsperaSuperSoldado());
                                CuartelElegido.start();
                                System.out.println("Se está entrenando un "+raza.getNombreSuperSoldado());
                                System.out.println("");
                                break;
                            }
                            else{
                                System.out.println("No hay suficiente "+raza.getNombreRecurso2()+" o "+raza.getNombreRecurso3()+" suficiente.");
                                System.out.println("");
                                break;
                            }
                        default:
                            System.out.println("");
                            System.out.println("Ese tipo de tropa no existe.");
                            System.out.println("");
                    }
                }
                else{
                    System.out.println("");
                    System.out.println("El Cuartel Elegido no está disponible.");
                    System.out.println("");
                }
            }catch(Exception ex){
                System.out.println("");
                System.out.println("Ese cuartel o tropa no es valido.");
                System.out.println("");
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
                            if(HQ.getRecursoTotal1()>=400&&HQ.getRecursoTotal2()>=300){
                                HQ.setRecursoTotal1(HQ.getRecursoTotal1()-400);
                                HQ.setRecursoTotal2(HQ.getRecursoTotal2()-300);
                                GeneradorElegido.setDisponibilidad(false);
                                GeneradorElegido.setTipoDeVehiculo(VehiculoElegido);
                                GeneradorElegido.setEsperaDeVehiculo(raza.getEsperaVehiculo1());
                                GeneradorElegido.start();
                                System.out.println("Se está generando un "+raza.getNombreVehiculo1());
                                System.out.println("");
                                break;
                            }
                            else{
                                System.out.println("No hay suficiente "+raza.getNombreRecurso1()+" o "+raza.getNombreRecurso2()+" suficiente.");
                                System.out.println("");
                                break;
                            }
                        case 2:
                            if(HQ.getRecursoTotal2()>=600&&HQ.getRecursoTotal3()>=10){
                                HQ.setRecursoTotal2(HQ.getRecursoTotal2()-600);
                                HQ.setRecursoTotal3(HQ.getRecursoTotal3()-10);
                                GeneradorElegido.setDisponibilidad(false);
                                GeneradorElegido.setTipoDeVehiculo(VehiculoElegido);
                                GeneradorElegido.setEsperaDeVehiculo(raza.getEsperaVehiculo2());
                                GeneradorElegido.start();
                                System.out.println("Se está generando un "+raza.getNombreVehiculo2());
                                System.out.println("");
                                break;
                            }
                            else{
                                System.out.println("No hay suficiente "+raza.getNombreRecurso2()+" o "+raza.getNombreRecurso3()+" suficiente.");
                                System.out.println("");
                                break;
                            }
                        default:
                            System.out.println("");
                            System.out.println("Ese tipo de vehiculo no existe.");
                            System.out.println("");
                    }
                }
                else{
                    System.out.println("");
                    System.out.println("El Generador Elegido no está disponible.");
                    System.out.println("");
                }
            }catch(Exception ex){
                System.out.println("");
                System.out.println("Ese Generador o Vehiculo no es valido.");
                System.out.println("");
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
    
    public void RevisarVehiculos(){
        if(this.Vehiculos.isEmpty()){
            System.out.println("No hay ningún tipo de vehiculo en la base.");
        }
        else{
            System.out.println("Vehiculos disponibles:");
            for(int i=1;i<=this.Vehiculos.size();i++){
                System.out.print(i+") "+this.Vehiculos.get(i-1).getNombre()+" ");
                System.out.print("Se encuentra en la base:");
                if(this.Vehiculos.get(i-1).isDisponibilidad()){
                    System.out.println(" Si");
                }
                else{
                    System.out.println(" No");
                }
            }
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
        if(this.Tropas.isEmpty()||this.Vehiculos.isEmpty()){
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
                int objetivo=-1;
                boolean ObjetivoExiste = false;
                try{
                    while(ObjetivoExiste==false){
                        System.out.print("Posición del objetivo a atacar: ");
                        objetivo = input.nextInt();
                        if(objetivo == 1 && Objetivos.size()>1){
                            System.out.println("HQ no se puede atacar porque hay más edificaciones.");
                            System.out.println("");
                        }
                        else if(objetivo > Objetivos.size()){
                            System.out.println("Objetivo no valido, escoja otro objetivo");
                            System.out.println("");
                        }
                        else if(objetivo<=0){
                            System.out.println("Objetivo no valido, escoja otro objetivo");
                            System.out.println("");
                        }
                        else{
                            ObjetivoExiste=true;
                        }
                    }
                }catch(Exception ex){
                    System.out.println("");
                    System.out.println("Objetivo no existente, vuelva a intentar realizar su ataque.");
                }
                
                
                //Aqui se escogerian las tropas
  
                if(ObjetivoExiste){
                    System.out.println("");
                    RevisarTropas();
                    System.out.print("Tropa a mandar a atacar: ");
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
                            System.out.println("");
                            RevisarVehiculos();
                            try{
                                int Vehiculo = -1;
                                boolean VehiculoExiste = false;
                            while(VehiculoExiste==false){
                                System.out.print("Vehiculo ha utilizar: ");
                                Vehiculo = input.nextInt();
                                if(Vehiculos.get(Vehiculo-1).isDisponibilidad()){
                                    Vehiculos.get(Vehiculo-1).setDisponibilidad(false);
                                    VehiculoExiste = true;
                                }
                                else{
                                    System.out.println("El vehiculo elegido no está disponible, vuelva a intentar su ataque.");
                                    break;
                                }
                            }
                            }catch(Exception ex){
                            System.out.println("Tipo de vehiculo no existente, vuelva a intentar realizar su ataque.");
                            }
                            this.Tropas.get(Tropa-1).setFaseInicial(Auxiliar.getFase());
                            this.Tropas.get(Tropa-1).setObjetivos(Objetivos);
                            this.Tropas.get(Tropa-1).setObjetivo(objetivo-1);
                            this.Tropas.get(Tropa-1).setViajando(true);
                            System.out.println(this.Tropas.get(Tropa-1).getNombre()+" Comenzó su viaje a la base enemiga!");
                        }
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
