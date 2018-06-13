/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificacion;

/**
 *
 * @author Mai Perez
 */
public class EdificacionFactory {
    public static Edificacion getEdificacion(int opcion) {
        switch(opcion){
            case 1:
                return new MaquinadeOro();
                
            case 2:
                return new MaquinadeMagia();
                
            case 3:
                return new MaquinadeDiamantes();
            case 4:
                return new Cuartel();
            case 5:
                return new GeneradordeVehiculos();
        }
        return null;
    }
    
}
