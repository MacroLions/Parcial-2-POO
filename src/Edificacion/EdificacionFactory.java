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
                Edificacion Edificacion = new MaquinadeDiamantes();
                return Edificacion;
        }
        return null;
    }
    
}
