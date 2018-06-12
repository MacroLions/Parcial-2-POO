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
    static public Jugador Jugador1;
    static public Jugador Jugador2;
    static public Jugador JugadorDebug = new Jugador("gato");
    
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
                    Jugador1 = JugadorCreator();
                    Jugador2 = JugadorCreator();
                    Jugador1.setObjetivos(Jugador2.getEdificaciones());
                    Jugador2.setObjetivos(Jugador1.getEdificaciones());
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
        System.out.println("");
        int RazaOpcion=-1;
        System.out.println("Tipos de Raza: 1) Mago  2) Tanuki  3) Humano ");
        System.out.print("Raza: ");
        
        try{
            RazaOpcion = input.nextInt();
        }catch(Exception ex){
            throw new UnsupportedOperationException("Raza no valida.");
        }
        raza = RazaFactory.getRaza(RazaOpcion);
        
        return new Jugador(nombre,raza);
    }
    
    public static void JuegoComenzar(){
        boolean TurnoJugador1= true;
        boolean TurnoJugador2= true;
        
        boolean Start = true;
        
        while(Start){
            System.out.println("Fase #"+Auxiliar.getFase());
            while(TurnoJugador1){
                TurnoJugador1= Jugador1.MenuJugador();
                System.out.println("");
            }

            while(TurnoJugador2){
                TurnoJugador2= Jugador2.MenuJugador();
                System.out.println("");
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
        while(Start){
            System.out.println("Fase #"+Auxiliar.getFase());
            while(TurnoJugadorDebug){
                TurnoJugadorDebug= JugadorDebug.MenuJugador();
                System.out.println("");
            }
            TurnoJugadorDebug=true;
            Auxiliar.setFase(Auxiliar.getFase()+1);
        }
    }
    
}
