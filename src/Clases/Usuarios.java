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

public class Usuarios {
    private String id_usu;
    private String usu_descri;

    ResultSet rs, rs1, rs2;
    Conexiondb cc = new Conexiondb();
    Connection cn = cc.conexion;

    public Usuarios() {
    }

    public Usuarios(String id_usu, String usu_descri) {
        this.id_usu = id_usu;
        this.usu_descri = usu_descri;
    }

    public String getId_usu() {
        return id_usu;
    }

    public void setId_usu(String id_usu) {
        this.id_usu = id_usu;
    }

    public String getUsu_descri() {
        return usu_descri;
    }

    public void setUsu_descri(String usu_descri) {
        this.usu_descri = usu_descri;
    }

    public void llenar_combo_usuario(JComboBox combo_usuario) {
        try {
            rs = cc.listar_datos("SELECT\n"+ "  `idUsuario`,\n" + "  `Nombre_Usuario`,\n"
                    + "  `Nick`,\n"
                    + "  `Roll`,\n"
                    + "  `Contrase`\n"
                    + "FROM `usuario`");
            while (rs.next()) {
                combo_usuario.addItem(
                        new Usuarios(
                                rs.getString("idUsuario"),
                                rs.getString("Nick")
                        )
                );

            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS USUARIOS");
        }
    }
@Override

    public String toString() {
        return usu_descri;
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
