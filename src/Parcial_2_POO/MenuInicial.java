/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_2_POO;

import Razas.Raza;
import java.util.Scanner;

/**
 *
 * @author Mai Perez
 */
public class MenuInicial {
    static public Jugador Jugador1;
    static public Jugador Jugador2;
    
    public static void MenuInicio(){
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido a MaitreyiPérez's World");
        System.out.println("1. Iniciar juego");
        System.out.println("2. Salir de juego");
        int opmenu = input.nextInt();
        switch(opmenu){
            case 1:
                Jugador1 = JugadorCreator();
                Jugador2 = JugadorCreator();
                Jugador1.setObjetivos(Jugador2.getObjetivos());
                Jugador2.setObjetivos(Jugador1.getObjetivos());
                JuegoComenzar();
            case 2:
        }
    }
    public static Jugador JugadorCreator(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nombre del jugador:"); 
        String nombre = input.next();
        Raza raza; 
        return new Jugador(nombre);
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
    
}
