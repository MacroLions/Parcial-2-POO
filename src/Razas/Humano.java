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
public class Humano implements Raza{
    String NombreRecurso1 = "Hierro";
    String NombreRecurso2 = "Madera";
    String NombreRecurso3 = "Dinero";
    
    String NombreMaquinaRecurso1= "Refinador de Hierro";
    String NombreMaquinaRecurso2= "Refinador de Madera";
    String NombreMaquinaRecurso3= "Creador de Dinero";
    
    String NombreEscuadron = "Escuadron";
    int AtaqueEscuadron = 100;
    int EsperaEscuadron = 2;
    
    String NombreSuperSoldado = "Super Soldado";
    int AtaqueSuperSoldado = 250;
    int EsperaSuperSoldado = 4;

    
    String NombreVehiculo1="Motocicleta";
    int EsperaVehiculo1=2;
    
    String NombreVehiculo2="Camioneta";
    int EsperaVehiculo2=3;
    @Override
    public String getNombreRecurso1() {
        return NombreRecurso1;
    }

    @Override
    public void setNombreRecurso1(String NombreRecurso1) {
        this.NombreRecurso1 = NombreRecurso1;
    }

    @Override
    public String getNombreRecurso2() {
        return NombreRecurso2;
    }

    @Override
    public void setNombreRecurso2(String NombreRecurso2) {
        this.NombreRecurso2 = NombreRecurso2;
    }

    @Override
    public String getNombreRecurso3() {
        return NombreRecurso3;
    }

    @Override
    public void setNombreRecurso3(String NombreRecurso3) {
        this.NombreRecurso3 = NombreRecurso3;
    }

    @Override
    public String getNombreMaquinaRecurso1() {
        return NombreMaquinaRecurso1;
    }

    @Override
    public void setNombreMaquinaRecurso1(String NombreMaquinaRecurso1) {
        this.NombreMaquinaRecurso1 = NombreMaquinaRecurso1;
    }

    @Override
    public String getNombreMaquinaRecurso2() {
        return NombreMaquinaRecurso2;
    }

    @Override
    public void setNombreMaquinaRecurso2(String NombreMaquinaRecurso2) {
        this.NombreMaquinaRecurso2 = NombreMaquinaRecurso2;
    }

    @Override
    public String getNombreMaquinaRecurso3() {
        return NombreMaquinaRecurso3;
    }

    @Override
    public void setNombreMaquinaRecurso3(String NombreMaquinaRecurso3) {
        this.NombreMaquinaRecurso3 = NombreMaquinaRecurso3;
    }

    @Override
    public String getNombreEscuadron() {
        return NombreEscuadron;
    }

    @Override
    public void setNombreEscuadron(String NombreEscuadron) {
        this.NombreEscuadron = NombreEscuadron;
    }

    @Override
    public int getAtaqueEscuadron() {
        return AtaqueEscuadron;
    }

    @Override
    public void setAtaqueEscuadron(int AtaqueEscuadron) {
        this.AtaqueEscuadron = AtaqueEscuadron;
    }

    @Override
    public int getEsperaEscuadron() {
        return EsperaEscuadron;
    }
    
    @Override
    public void setEsperaEscuadron(int EsperaEscuadron) {
        this.EsperaEscuadron = EsperaEscuadron;
    }

    @Override
    public String getNombreSuperSoldado() {
        return NombreSuperSoldado;
    }

    @Override
    public void setNombreSuperSoldado(String NombreSuperSoldado) {
        this.NombreSuperSoldado = NombreSuperSoldado;
    }

    @Override
    public int getAtaqueSuperSoldado() {
        return AtaqueSuperSoldado;
    }

    @Override
    public void setAtaqueSuperSoldado(int AtaqueSuperSoldado) {
        this.AtaqueSuperSoldado = AtaqueSuperSoldado;
    }
    
    @Override
    public int getEsperaSuperSoldado() {
        return EsperaSuperSoldado;
    }
    
    @Override
    public void setEsperaSuperSoldado(int EsperaSuperSoldado) {
        this.EsperaSuperSoldado = EsperaSuperSoldado;
    }
    
    public String getNombreVehiculo1() {
        return NombreVehiculo1;
    }

    public void setNombreVehiculo1(String NombreVehiculo1) {
        this.NombreVehiculo1 = NombreVehiculo1;
    }

    public int getEsperaVehiculo1() {
        return EsperaVehiculo1;
    }

    public void setEsperaVehiculo1(int EsperaVehiculo1) {
        this.EsperaVehiculo1 = EsperaVehiculo1;
    }

    public String getNombreVehiculo2() {
        return NombreVehiculo2;
    }

    public void setNombreVehiculo2(String NombreVehiculo2) {
        this.NombreVehiculo2 = NombreVehiculo2;
    }

    public int getEsperaVehiculo2() {
        return EsperaVehiculo2;
    }

    public void setEsperaVehiculo2(int EsperaVehiculo2) {
        this.EsperaVehiculo2 = EsperaVehiculo2;
    }
}
