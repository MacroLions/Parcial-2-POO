/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tropa;

/**
 *
 * @author Mai Perez
 */
public class TropaFactory {  
    public static Tropa getTropa(int opcion) {
        switch(opcion){
            case 1:
                return new Escuadron();
                
            case 2:
                return new SuperSoldado();

        }
        return null;
    }
    
}
