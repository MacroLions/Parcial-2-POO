/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificacion;

import Parcial_2_POO.Jugador;
import Tropa.Tropa;
import Vehiculos.Vehiculo;

/**
 *
 * @author Mai Perez
 */
public class HQ implements Edificacion{
    private String Nombre = "HQ";
    private Jugador propitario;
    private int Vida=10000;
    private boolean Vivo=true;
    private int RecursoTotal1=1000;
    private int LimiteRecurso1=10000;
    private int RecursoTotal2=1000;
    private int LimiteRecurso2=5000;
    private int RecursoTotal3=5;
    private int LimiteRecurso3=3000;

    @Override
    public void RecibirDamage(int damage) {
        System.out.println("El HQ de "+this.propitario.getNombre()+" recibio "+damage+" de daño");
        Vida=Vida-damage;
        if(Vida<=0){
            Vivo=false;
            //destroy();
        }
        
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Jugador getPropitario() {
        return propitario;
    }

    public void setPropitario(Jugador propitario) {
        this.propitario = propitario;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int Vida) {
        this.Vida = Vida;
    }

    public boolean isVivo() {
        return Vivo;
    }

    public void setVivo(boolean Vivo) {
        this.Vivo = Vivo;
    }

    public int getRecursoTotal1() {
        return RecursoTotal1;
    }

    public void setRecursoTotal1(int RecursoTotal1) {
        this.RecursoTotal1 = RecursoTotal1;
    }

    public int getLimiteRecurso1() {
        return LimiteRecurso1;
    }

    public void setLimiteRecurso1(int LimiteRecurso1) {
        this.LimiteRecurso1 = LimiteRecurso1;
    }

    public int getRecursoTotal2() {
        return RecursoTotal2;
    }

    public void setRecursoTotal2(int RecursoTotal2) {
        this.RecursoTotal2 = RecursoTotal2;
    }

    public int getLimiteRecurso2() {
        return LimiteRecurso2;
    }

    public void setLimiteRecurso2(int LimiteRecurso2) {
        this.LimiteRecurso2 = LimiteRecurso2;
    }

    public int getRecursoTotal3() {
        return RecursoTotal3;
    }

    public void setRecursoTotal3(int RecursoTotal3) {
        this.RecursoTotal3 = RecursoTotal3;
    }

    public int getLimiteRecurso3() {
        return LimiteRecurso3;
    }

    public void setLimiteRecurso3(int LimiteRecurso3) {
        this.LimiteRecurso3 = LimiteRecurso3;
    }

    @Override
    public int EntregarRecursos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tropa GenerarTropa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDisponibilidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vehiculo GenerarVehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}