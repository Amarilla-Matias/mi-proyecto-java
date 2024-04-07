/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registros;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;

/**
 *
 * @author administrdor
 */
public class TicketSalida implements Printable {

    private final String hora_entrada;
    private final int piso;
    private final char tipo;
    private final String patente;
    private final String hora_salida;
    

    public TicketSalida(String hora, int piso, char tipo, String patente, String hora_salida ) {
        this.hora_entrada = hora;
        this.piso = piso;
        this.tipo = tipo;
        this.patente = patente;
        this.hora_salida = hora_salida;
       
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        if (pageIndex == 0) {
            graphics.drawString("TICKET SALIDA", 200, 80);
            graphics.drawString("Entrada", 120, 120);
            graphics.drawString(hora_entrada, 180, 120);
            graphics.drawString("Piso", 120, 140);
            graphics.drawString("" + piso, 180, 140);
            graphics.drawString("Tipo", 120, 160);
            graphics.drawString("" + tipo, 180, 160);
            graphics.drawString("Patente", 120, 180);
            graphics.drawString(patente, 180, 180);
            graphics.drawString("Salida", 120, 200);
            graphics.drawString(hora_salida, 180, 200);
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }

}
