
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Lenovo
 */
public class ProveedorDAO {
    Connection con;
    PreparedStatement ps;
    ArrayList<Proveedor> provs = new ArrayList<>();
    public ProveedorDAO(){
        con = conector.getConexion();
    }
    
    public ArrayList<Proveedor> cargarProveedores() throws SQLException{
        String sql = "SELECT RUT_PROVEEDOR, NOMBRE FROM PROVEEDOR";
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(sql);
        
        while (rs.next()) {
            String rut, nombre;
            rut = rs.getString("RUT_PROVEEDOR");
            nombre = rs.getString("NOMBRE");
            Proveedor p = new Proveedor(rut, nombre);
        }
    }
}
