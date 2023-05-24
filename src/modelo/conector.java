
package modelo;


import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import java.sql.DriverManager;
//import java.sql.SQLException;
public class conector {
    private static conector con;
    private Connection conexion=null;

    PreparedStatement ps=null;
    ResultSet RS = null;
    private conector(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/ ferreteria", "root", "");  
//            JOptionPane.showMessageDialog(null, "Se ha conectado");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido conectar" +" "+ e.getMessage());
        }
    }    

    public static Connection getConexion(){
        if (con==null)
            con = new conector();
        return con.conexion;
    }
    
    
 }


  
