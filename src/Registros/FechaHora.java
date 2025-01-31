/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registros;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author administador
 */
public class FechaHora {
    private final Date date;
    private String fecha_hora;

    public FechaHora(Date date) {
        this.date = date;
    }

    public String obtenerFechaHora() {
        fecha_hora = "";
        String formato = "dd";
        SimpleDateFormat dateFormat3 = new SimpleDateFormat(formato);
        fecha_hora += Integer.parseInt(dateFormat3.format(date));
        fecha_hora += "/";
        formato = "MM";
        SimpleDateFormat dateFormat2 = new SimpleDateFormat(formato);
        fecha_hora += Integer.parseInt(dateFormat2.format(date));
        fecha_hora += "/";
        formato = "yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        fecha_hora += Integer.parseInt(dateFormat.format(date));
        fecha_hora += " ";
        if (date.getHours() < 0) {
            fecha_hora += "0";
        }
        fecha_hora += date.getHours();
        fecha_hora += ":";
        if (date.getMinutes() < 0) {
            fecha_hora += "0";
        }
        fecha_hora += date.getMinutes();
        fecha_hora += ":";
        if (date.getSeconds() < 0) {
            fecha_hora += "0";
        }
        fecha_hora += date.getSeconds();
        return fecha_hora;
    }
}
