/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificacion;

/**
 *
 * @author Maishi
 */
public interface Edificacion {
    public void GenerarRecursos();
    public int EntregarRecursos();
    
    public void GenerarTropa();
    
    public void GenerarVehiculo();
    public void RecibirDamage(int damage);

    public void run();
    
}
