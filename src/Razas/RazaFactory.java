/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Razas;

/**
 *
 * @author Mai Perez
 */
public class RazaFactory {
    public static Raza getRaza(int opcion) {
        switch(opcion){
            case 1:
                return new Mago();
            case 2:
                return new Tanuki();
            case 3:
                return new Humano();
        }
        return null;
    }
}
