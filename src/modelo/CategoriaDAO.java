
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoriaDAO {
    Connection con;
    PreparedStatement ps;
    
    public CategoriaDAO(){
        con = conector.getConexion();
    }
    
    public ArrayList<Categoria> cargarProveedores() throws SQLException{
        String sql = "SELECT ID_CATEGORIA, DENOMINACION FROM CATEGORIA";
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(sql);
        ArrayList<Categoria> cats = new ArrayList<>();
        while (rs.next()) {
            int id;
            String denominacion;
            id = rs.getInt("ID_CATEGORIA");
            denominacion = rs.getString("DENOMINACION");
            Categoria p = new Categoria(id, denominacion);
            cats.add(p);
            
        }
        return cats;
    }
}
