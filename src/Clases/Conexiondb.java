/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author administador
 */
public class Conexiondb {

    public Connection conexion;
    public Statement st;
    public ResultSet rs;

    private final String servidor = "jdbc:mysql://localhost/park";
    private final String user = "root";
    private final String password = "";
    private final String driver = "com.mysql.jdbc.Driver";

    public Conexiondb() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(servidor, user, password);
            st = conexion.createStatement();
            System.out.println("Conexion Realizada con Exito");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conexion Fallida");
//             System.out.println("Conexion a base de datos"+servidor+"...ok");
//             JOptionPane.showConfirmDialog(null,"Conexion con Exito",
//                     "Bienvenidos",JOptionPane.INFORMATION_MESSAGE);
        }
//    JOptionPane.showMessageDialog(null,"Conexion con Exito");
    }

    public Connection getConnection() {
        return conexion;
    }

    public boolean busqueda(String query) {
        try {
            st = conexion.createStatement();
            rs = st.executeQuery(query);
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

    public ResultSet listar_datos(String consulta) {
        try {
            st = conexion.createStatement(ResultSet.CONCUR_READ_ONLY,
                    ResultSet.TYPE_SCROLL_INSENSITIVE);
            rs = st.executeQuery(consulta);
        } catch (SQLException ex) {
            System.out.println(consulta);
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return rs;

    }

    /**
     * Metodos de la tabla tarifa
     */
    public double obtenerTarifa(char c) {
        double tarifa = 0;
        String pedido = "select * from tarifas where tipo_auto ='" + c + "'";
        try {
            ResultSet rs = st.executeQuery(pedido);
            if (rs.next()) {
                tarifa = (double) rs.getObject("tarifa");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarifa;
    }

    public ResultSet listarTarifas() {
        ResultSet rs = null;
        String pedido = "select * from tarifas";
        try {
            rs = st.executeQuery(pedido);
        } catch (SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    /**
     * Metodos de la tabla cochera
     */
    public ResultSet listarCocheras() {
        ResultSet rs = null;
        String pedido = "select * from cocheras";
        try {
            rs = st.executeQuery(pedido);
        } catch (SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int numCochesEnCocheras(int piso) {
        int total = 0;
        ResultSet rs = null;
        String pedido = "select count(*) as total from cocheras where piso=" + piso;
        try {
            rs = st.executeQuery(pedido);
            while (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public Historial obtenerCoche(String patente) {
        Historial bean = new Historial();
        try {
            String query = "select * from cocheras where patente='" + patente + "'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                bean.setPatente(rs.getString("patente"));
                bean.setHora_ocupacion(rs.getDouble("hora_ocupacion"));
                String cad = (String) rs.getObject("tipo_auto");
                char c = cad.charAt(0);
                bean.setTipo_auto(c);
                bean.setPiso(rs.getInt("piso"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bean;
    }

    public ArrayList<Historial> obtenerCoche(int piso) {
        ArrayList<Historial> beanes = new ArrayList<Historial>();
        try {
            String query = "select * from cocheras where piso=" + piso;
            ResultSet rs = st.executeQuery(query);
            rs.beforeFirst();
            while (rs.next()) {
                Historial bean = new Historial();
                bean.setPatente(rs.getString("patente"));
                bean.setHora_ocupacion(rs.getDouble("hora_ocupacion"));
                String cad = (String) rs.getObject("tipo_auto");
                char c = cad.charAt(0);
                bean.setTipo_auto(c);
                bean.setPiso(rs.getInt("piso"));
                beanes.add(bean);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }

        return beanes;
    }

    public void agregarCocheras(String patente, int piso, char tipo) {
        Date date = new Date();
        double fecha = date.getTime();
        String query = "insert into cocheras (patente,hora_ocupacion,tipo_auto,piso) ";
        query += "values('" + patente + "','" + fecha + "','" + tipo + "','" + piso + "')";
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificarCocheras(String patente, int piso, char tipo) {
        Date date = new Date();
        double fecha = date.getTime();
        String query = "insert into cocheras (patente,hora_ocupacion,tipo_auto,piso) ";
        query += "values('" + patente + "','" + fecha + "','" + tipo + "','" + piso + "')";
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarCocheras(String patente) {
        String query = "delete from cocheras where patente = '" + patente + "'";
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodos de la tabla historico
     */
    public ResultSet listarHistorico() {
        ResultSet rs = null;
        String query = "select * from historico";
        try {
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void grabarHistorico(String patente, double hora_ocupacion, char tipo, int piso) {
        Date date = new Date();
        double fecha = date.getTime();
        String query = "";
        query += "insert into historico (patente,hora_ocupacion,tipo_auto,piso,hora_salida) ";
        query += "values('" + patente + "','" + hora_ocupacion + "','" + tipo + "','" + piso + "','" + fecha + "')";
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
