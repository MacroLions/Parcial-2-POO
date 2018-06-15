/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_2_POO;

import Razas.Raza;
import Razas.RazaFactory;
import java.util.Scanner;

/**
 *
 * @author Mai Perez
 */
public class MenuInicial {
    static public Jugador Jugador1=null;
    static public Jugador Jugador2=null;
    static public Jugador JugadorDebug = new Jugador("Gato");
    
    public static void MenuInicio(){
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido a MaitreyiPérez's World");
        System.out.println("1. Iniciar juego");
        System.out.println("2. Debug tests");
        System.out.println("3. Salir de juego");
        System.out.print("Opcion: ");
        int opmenu=-1;
        try{
            opmenu = input.nextInt();
        }catch(Exception ex){
            System.out.println("");
            System.out.println("Ninguna opcion valida fue escogida. Por favor vuelva a ejecutar el juego.");
        }
        switch(opmenu){
                case 1:
                    System.out.println("///////////////////////////////////////");
                    System.out.println(">>Creacion de jugadores para el juego<<");
                    System.out.println("");
                    while(Jugador1==null){
                        System.out.println(">Creacion Jugador 1:");
                        Jugador1 = JugadorCreator();
                    }
                    System.out.println("");
                    while(Jugador2==null){
                        System.out.println(">Creacion Jugador 2:");
                        Jugador2 = JugadorCreator();
                    }
                    Jugador1.setObjetivos(Jugador2.getEdificaciones());
                    Jugador2.setObjetivos(Jugador1.getEdificaciones());
                    Jugador1.setTropasEnemigas(Jugador2.getTropas());
                    Jugador2.setTropasEnemigas(Jugador1.getTropas());
                    JuegoComenzar();
                    break;
                case 2:
                    Debug();
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Gracias por ejecutar el programa! :3");
                    break;
            }
    }
    public static Jugador JugadorCreator(){
        String nombre;
        Raza raza;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Nombre del jugador:"); 
        nombre = input.next();
        int RazaOpcion=-1;
        System.out.println("Tipos de Raza: 1) Mago  2) Tanuki  3) Humano ");
        System.out.print("Raza: ");
        
        try{
            RazaOpcion = input.nextInt();
        }catch(Exception ex){
            System.out.println("Solo se pueden usar números para escoger la raza. Se volverá a intentar crear al jugador.");
            return null;
        }
        raza = RazaFactory.getRaza(RazaOpcion);
        if(raza==null){
            System.out.println("Raza no valida. Se volverá a intentar crear al jugador.");
            return null;
        }
        else{
            return new Jugador(nombre,raza);
        }
    }
    
    public static void JuegoComenzar(){
        boolean TurnoJugador1= true;
        boolean TurnoJugador2= true;
        
        boolean Start = true;
        System.out.println("///////////////////////////////////////");
        System.out.println(">>¡Inicio del juego!<<");
        while(Start){
            System.out.println(">>>>Fase #"+Auxiliar.getFase()+"<<<<");
            Auxiliar.ViajarMaster(Jugador1.getTropas());
            Auxiliar.AtacarMaster(Jugador1.getTropas());
            Auxiliar.ViajarMaster(Jugador2.getTropas());
            Auxiliar.AtacarMaster(Jugador2.getTropas());
            System.out.println("");
            while(TurnoJugador1){
                System.out.println("Turno de "+Jugador1.getNombre());
                TurnoJugador1= Jugador1.MenuJugador();
                System.out.println("");
            }

            while(TurnoJugador2){
                System.out.println("Turno de "+Jugador2.getNombre());
                TurnoJugador2= Jugador2.MenuJugador();
                System.out.println("");
            }
            
            if(Jugador1.getEdificaciones().isEmpty()){
                System.out.println("¡"+Jugador2.getNombre()+" ha destruido el HQ de "+Jugador1.getNombre()+"!");
                System.out.println("¡"+Jugador2.getNombre()+" ha ganado!");
                break;
            }
            else if(Jugador2.getEdificaciones().isEmpty()){
                System.out.println("¡"+Jugador1.getNombre()+" ha destruido el HQ de "+Jugador2.getNombre()+"!");
                System.out.println("¡"+Jugador1.getNombre()+" ha ganado!");
                break;
            }
            
            Auxiliar.setFase(Auxiliar.getFase()+1);
            TurnoJugador1=true;
            TurnoJugador2=true;
        }
    }
    
    public static void Debug(){
        boolean TurnoJugadorDebug = true;
        boolean Start = true;
        JugadorDebug.setObjetivos(JugadorDebug.getEdificaciones());
        JugadorDebug.setTropasEnemigas(JugadorDebug.getTropas());
        JugadorDebug.getHQ().setRecursoTotal1(10000);
        JugadorDebug.getHQ().setRecursoTotal2(10000);
        JugadorDebug.getHQ().setRecursoTotal3(10000);
        while(Start){
            System.out.println(">>>>Fase #"+Auxiliar.getFase()+"<<<<");
            Auxiliar.ViajarMaster(JugadorDebug.getTropas());
            Auxiliar.AtacarMaster(JugadorDebug.getTropas());
            System.out.println("");
            while(TurnoJugadorDebug){
                System.out.println("Turno de "+JugadorDebug.getNombre());
                TurnoJugadorDebug= JugadorDebug.MenuJugador();
            }
            if(JugadorDebug.getEdificaciones().isEmpty()){
                System.out.println("¡"+JugadorDebug.getNombre()+" ha destruido el HQ de "+JugadorDebug.getNombre()+"!");
                System.out.println("¡"+JugadorDebug.getNombre()+" ha ganado!");
                break;
            }
            TurnoJugadorDebug=true;
            Auxiliar.setFase(Auxiliar.getFase()+1);
        }
    }
    
}
