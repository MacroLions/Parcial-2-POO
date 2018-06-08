/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_2_POO;

/**
 *
 * @author Mai Perez
 */
public class Parcial_2_POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          
        Jugador Mai = new Jugador("Mai");
        Jugador Mako = new Jugador("Mako");
        boolean TurnoJugador1= true;
        boolean TurnoJugador2= true;
        
        boolean Start = true;
        
        while(Start){
            System.out.println("Fase #"+Auxiliar.getFase());
            while(TurnoJugador1){
                TurnoJugador1= Mai.MenuJugador();
                System.out.println("");
            }
            while(TurnoJugador2){
                TurnoJugador2= Mako.MenuJugador();
                System.out.println("");
            }
            Auxiliar.setFase(Auxiliar.getFase()+1);
            TurnoJugador1=true;
            TurnoJugador2=true;
            
        }
      
    }
    
}
