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
 * @author MATIAS
 */
public class cargo {

    private String idcargo;
    private String descri_cargo;

    ResultSet rs;
    Conexiondb cc = new Conexiondb();
    Connection cn = cc.conexion;

    public cargo(String idcargo, String descri_cargo) {
        this.idcargo = idcargo;
        this.descri_cargo = descri_cargo;

    }

    public cargo() {

    }

    public String getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(String idcargo) {
        this.idcargo = idcargo;
    }

    public String getDescri_cargo() {
        return descri_cargo;
    }

    public void setDescri_cargo(String descri_cargo) {
        this.descri_cargo = descri_cargo;
    }

    public void llenar_cmb_cargo(JComboBox cmb_cargo) {
        try {
            rs = cc.listar_datos("SELECT `idCargo`, `Nombre_Cargo` FROM `cargo` ORDER BY `idCargo`");
            cmb_cargo.removeAllItems();
            while (rs.next()) {
                cmb_cargo.addItem(
                        new cargo(
                                rs.getString("idCargo"),
                                rs.getString("Nombre_Cargo")
                        ));

            }
        } catch (SQLException ex) {
            Logger.getLogger(cargo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS CARGOS");
        }
    }

    public void para_modificar(JComboBox<cargo> combo_cargo, int id) {
        try {
            combo_cargo.setSelectedIndex(id);

        } catch (Exception e) {
            Logger.getLogger(cargo.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS CARGOS");
        }
    }

    @Override

    public String toString() {
        return descri_cargo;
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
