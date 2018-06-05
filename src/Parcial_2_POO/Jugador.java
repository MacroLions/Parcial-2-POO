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
    private final int OroTotal=1000;
    private final int MagiaTotal=1000;
    private final int Diamantes=1;
    private final ArrayList<Tropa> Tropas = new ArrayList();
    private final ArrayList<Edificacion> Edificaciones = new ArrayList();
    
    
    Jugador(String nombre){
        this.nombre=nombre;
    }
    
    
    public void MenuJugador(){
        Scanner input = new Scanner(System.in);
        System.out.println("Hola "+this.nombre+" ¿Que quieres en este turno?");
        System.out.println("1. Construir");
        System.out.println("2. Recolectar Recursos");
        int op = input.nextInt();
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
        System.out.println("Construir?");
        System.out.println("1. Maquina de Diamantes");
        int op = input.nextInt();
        switch(op){
            case 1:
                Edificaciones.add(EdificacionFactory.getEdificacion(op));
        }
        System.out.println("");
        
    };
    public void RecolectarRecursos(){
        if(Edificaciones.isEmpty()==false){
            System.out.println("Maquinas disponibles:");
            int Comprobador_1 = Auxiliar.RevisarEdificaciones(Edificaciones, EdificacionFactory.getEdificacion(1));
            if(Comprobador_1!=0){
                System.out.println("Maquina de Diamantes x"+Comprobador_1);
            }
        }
    };
    
    public void Atacar(){};
    
    
}
