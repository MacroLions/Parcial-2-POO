/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificacion;

import Tropa.Tropa;

/**
 *
 * @author Maishi
 */
public interface Edificacion {

    public int EntregarRecursos();
    
    public Tropa GenerarTropa();
    public boolean isDisponibilidad();
    
    public void GenerarVehiculo();
    public void RecibirDamage(int damage);

    public void run();

    public void start();
    
    public String getNombre();
    public int getVida();
    public boolean isVivo();
}
