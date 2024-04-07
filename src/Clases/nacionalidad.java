/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author PHP
 */
public class nacionalidad {

    private String idnacion;
    private String descri_nacion;

    ResultSet rs, rs1, rs2;
    Conexiondb cc = new Conexiondb();
    Connection cn = cc.conexion;

    public nacionalidad(String idnacion, String descri_nacion) {
        this.idnacion = idnacion;
        this.descri_nacion = descri_nacion;
    }

    public nacionalidad() {

    }

    public String getIdnacion() {
        return idnacion;
    }

    public void setIdnacion(String idnacion) {
        this.idnacion = idnacion;
    }

    public String getDescri_nacion() {
        return descri_nacion;
    }

    public void setDescri_nacion(String descri_nacion) {
        this.descri_nacion = descri_nacion;
    }

    public void llenar_combo_nacion(JComboBox combo_nacionalidad) {
        try {
//            rs = cc.listar_datos("SELECT `idNacionalidad`,`Nombre_Nacion` FROM `nacionalidad` ORDER BY `idNacionalidad`");
             rs = cc.st.executeQuery("SELECT `idNacionalidad`,`Nombre_Nacion` FROM `nacionalidad` ORDER BY `idNacionalidad`");
           
//            combo_nacionalidad.removeAllItems();
            while (rs.next()) {
                combo_nacionalidad.addItem(
                        new nacionalidad(
                                rs.getString("idNacionalidad"),
                                rs.getString("Nombre_Nacion")
                        )
                );

            }
        } catch (SQLException ex) {
            Logger.getLogger(nacionalidad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LAS NACIONALIDADES");
        }
    }
       public void borrar_nacion(JComboBox<nacionalidad> combo_nacionalidad) {

        try {
            combo_nacionalidad.removeAllItems();
            
        } catch (Exception ex) {
//            Logger.getLogger(seccion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL LIMPIAR LAS NACIONALIDADES ");
        }
    }

    @Override
    public String toString() {
        return descri_nacion;
    }
       @Override
    protected void finalize() throws Throwable {
        try {
            cc.conexion.close();
        } finally {
            super.finalize();
        }
    }

}

