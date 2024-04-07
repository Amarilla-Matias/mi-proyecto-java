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

public class ciudad {

    private String idciudad;
    private String descri_ciu;
    ResultSet rs, rs1, rs2;
    Conexiondb cc = new Conexiondb();
    Connection cn = cc.conexion;

    public ciudad(String idciudad, String descri_ciu) {
        this.idciudad = idciudad;
        this.descri_ciu = descri_ciu;
    }

    public ciudad() {

    }

    public String getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(String idciudad) {
        this.idciudad = idciudad;
    }

    public String getDescri_ciu() {
        return descri_ciu;
    }

    public void setDescri_ciu(String descri_ciu) {
        this.descri_ciu = descri_ciu;
    }

    public void llenar_combo_ciudad(JComboBox combo_ciudad) {
        try {
//            rs = cc.listar_datos("SELECT  `idCiudad`, `Ciu_Nombre` FROM `ciudad` ORDER BY `idCiudad`");
              rs = cc.st.executeQuery("SELECT  `idCiudad`, `Ciu_Nombre` FROM `ciudad` ORDER BY `idCiudad`");
//            combo_ciudad.removeAllItems();
            while (rs.next()) {
                combo_ciudad.addItem(
                        new ciudad(
                                rs.getString("idCiudad"),
                                rs.getString("Ciu_Nombre")
                        )
                );

            }
        } catch (SQLException ex) {
            Logger.getLogger(ciudad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LAS CIUDADES");
        }
    }
public void borrar_combo_ciudad(JComboBox<ciudad> combo_ciudad) {
        try {
            combo_ciudad.removeAllItems();

        } catch (Exception ex) {
            Logger.getLogger(ciudad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL LIMPIAR LAS CIUDADES");
        }
    }

    ;
    
 
    @Override
    public String toString() {
        return descri_ciu;
    }

    @Override
    @SuppressWarnings("FinalizeDeclaration")
    protected void finalize() throws Throwable {
        try {
            cc.conexion.close();
        } finally {
            super.finalize();
        }
    }
}
