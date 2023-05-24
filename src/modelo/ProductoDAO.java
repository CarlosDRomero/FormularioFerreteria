package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO {
    Connection con;
    PreparedStatement ps;
    public ProductoDAO(){
        con = conector.getConexion();
    }
    public ArrayList<Producto> obtenerProductos() throws SQLException{
        
        ArrayList<Producto> listaProductos = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT ID_PRODUCTO, NOMBRE, PRECIO_COMPRA, PRECIO_VENTA, IVA, RUT_PROVEEDOR, ID_CATEGORIA FROM PRODUCTO");
        while (rs.next()) {
            Producto e = new Producto(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getInt(5),
                rs.getString(6),
                rs.getInt(7)
            );
            listaProductos.add(e);
        }
        return listaProductos;
    }
    
    
    
    
    public ArrayList<String[]> obtenerDatosTabla(){
        String[] datos= new String[6];
        ArrayList<String[]> filasColumna = new ArrayList<>();
        try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT p.NOMBRE, p.PRECIO_COMPRA, p.PRECIO_VENTA, p.IVA, pr.NOMBRE, c.DENOMINACION FROM producto as p INNER JOIN proveedor as pr ON pr.RUT_PROVEEDOR = p.RUT_PROVEEDOR INNER JOIN categoria as c ON c.ID_CATEGORIA=p.ID_CATEGORIA ORDER BY p.ID_PRODUCTO;");
        while (rs.next()) {
            String nombre = rs.getString(1);
            int pc = rs.getInt(2);
            int pv = rs.getInt(3);
            int iva = rs.getInt(4);
            String prov = rs.getString(5);
            String categ = rs.getString(6);
            
            datos[0] = nombre;
            datos[1] = String.valueOf(pc);
            datos[2] = String.valueOf(pv);
            datos[3] = String.valueOf(iva);
            datos[4] = prov;
            datos[5] = categ;
             
            filasColumna.add(datos.clone());
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasColumna;
    }
}
