/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author administador
 */
public class Historial {
  
    private String patente;
    private double hora_ocupacion;
    private char tipo_auto;
    private int piso;
    private double hora_salida;
    
    
    
  public String getPatente() {
        return patente;
  }
  
    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getHora_ocupacion() {
        return hora_ocupacion;
    }

    
    public void setHora_ocupacion(double hora_ocupacion) {
        this.hora_ocupacion = hora_ocupacion;
    }

    
    public char getTipo_auto() {
        return tipo_auto;
    }

  
    public void setTipo_auto(char tipo_auto) {
        this.tipo_auto = tipo_auto;
    }

   
    public int getPiso() {
        return piso;
    }

    
    public void setPiso(int piso) {
        this.piso = piso;
    }

   
    public double getHora_salida() {
        return hora_salida;
    }

   
    public void setHora_salida(double hora_salida) {
        this.hora_salida = hora_salida;
    }

   
}
