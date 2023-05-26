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
    
    public ProductoDAO(){
        con = conector.getConexion();
    }
    public ArrayList<Producto> obtenerProductos() throws SQLException{
        
        ArrayList<Producto> listaProductos = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("""
                                         SELECT p.ID_PRODUCTO, p.NOMBRE, p.PRECIO_COMPRA, p.PRECIO_VENTA, p.IVA, COALESCE(SUM(i.CANTIDAD), 0), p.RUT_PROVEEDOR, p.ID_CATEGORIA 
                                         FROM PRODUCTO as p
                                         LEFT JOIN INVENTARIO_FERRETERIA as i ON i.ID_PRODUCTO = p.ID_PRODUCTO
                                         GROUP BY p.ID_PRODUCTO, p.NOMBRE, p.PRECIO_COMPRA, p.PRECIO_VENTA, p.IVA,p.RUT_PROVEEDOR, p.ID_CATEGORIA
                                         ORDER BY p.ID_PRODUCTO;
                                         """);
        while (rs.next()) {
            Producto e = new Producto(
                rs.getString(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getInt(5),
                rs.getInt(6),
                rs.getString(7),
                rs.getInt(8)
            );
            listaProductos.add(e);
        }
        return listaProductos;
    }
    public boolean InsertarProducto(Producto p) throws SQLException {
        
        PreparedStatement ps1 =   con.prepareStatement("INSERT INTO PRODUCTO (ID_PRODUCTO,NOMBRE, PRECIO_COMPRA, PRECIO_VENTA, IVA, RUT_PROVEEDOR, ID_CATEGORIA) VALUES (?,?,?,?,?,?,?)");
        PreparedStatement ps2 =   con.prepareStatement("INSERT INTO INVENTARIO_FERRETERIA (ID_PRODUCTO, ID_FERRETERIA, CANTIDAD) VALUES (?,1,?)");
        
        ps1.setString(1,p.getId());
        ps1.setString(2, p.getNombre());
        ps1.setInt(3, p.getPrecio_compra());
        ps1.setInt(4, p.getPrecio_venta());
        ps1.setInt(5, p.getIVA());
        ps1.setString(6, p.getRutProveedor());
        ps1.setInt(7, p.getId_categoria());
        
        ps2.setString(1, p.getId());
        ps2.setInt(2, p.getCantidad());
        
        System.out.println(ps1.toString());
        int filasAfectadas = 0;
        filasAfectadas += ps1.executeUpdate();
        filasAfectadas += ps2.executeUpdate();
        
        return filasAfectadas > 0;

    }
    public boolean modificarProducto(Producto p) throws SQLException{
        PreparedStatement ps1 =   con.prepareStatement("UPDATE producto SET NOMBRE=?,PRECIO_COMPRA=?,PRECIO_VENTA=?,IVA=?, RUT_PROVEEDOR=?, ID_CATEGORIA=? WHERE ID_PRODUCTO=?");
        PreparedStatement ps2 =   con.prepareStatement("UPDATE inventario_ferreteria SET CANTIDAD=? WHERE ID_PRODUCTO = ? AND ID_FERRETERIA = 1");
        PreparedStatement ps3 =   con.prepareStatement("INSERT IGNORE INTO INVENTARIO_FERRETERIA (ID_PRODUCTO, ID_FERRETERIA, CANTIDAD) VALUES (?,1,?)");
        
        ps1.setString(1, p.getNombre());
        ps1.setInt(2, p.getPrecio_compra());
        ps1.setInt(3, p.getPrecio_venta());
        ps1.setInt(4, p.getIVA());
        ps1.setString(5, p.getRutProveedor());
        ps1.setInt(6, p.getId_categoria());
        ps1.setString(7, p.getId());
        
        ps2.setInt(1, p.getCantidad());
        ps2.setString(2, p.getId());
        
        ps3.setString(1, p.getId());
        ps3.setInt(2, p.getCantidad());
        
        System.out.println(ps1.toString());
        System.out.println(ps2.toString());
        System.out.println(ps3.toString());
        int filasAfectadas = 0;
        filasAfectadas += ps1.executeUpdate();
        filasAfectadas += ps2.executeUpdate();
        filasAfectadas += ps3.executeUpdate();
        return filasAfectadas > 0;

        
    }
    public boolean eliminarProducto(Producto p) throws SQLException {
        
        PreparedStatement ps1 = con.prepareStatement("DELETE FROM INVENTARIO_FERRETERIA WHERE ID_PRODUCTO = ?");
        PreparedStatement ps2 = con.prepareStatement("DELETE FROM PRODUCTOS_SOLICITUD WHERE ID_PRODUCTO = ?");
        PreparedStatement ps3 = con.prepareStatement("DELETE FROM ITEMS_FACTURA WHERE ID_PRODUCTO = ?");
        PreparedStatement ps4 = con.prepareStatement("DELETE FROM PRODUCTO WHERE ID_PRODUCTO = ?");
        ps1.setString(1, p.getId());
        ps2.setString(1, p.getId());
        ps3.setString(1, p.getId());
        ps4.setString(1, p.getId());
        int filasAfectadas =0;
        filasAfectadas += ps1.executeUpdate();
        filasAfectadas += ps2.executeUpdate();
        filasAfectadas += ps3.executeUpdate();
        filasAfectadas += ps4.executeUpdate();
        ps1.close();
        ps2.close();
        ps3.close();
        ps4.close();
        return filasAfectadas > 0;
    }
    
    
    public ArrayList<String[]> obtenerDatosTabla(){
        String[] datos= new String[9];
        ArrayList<String[]> filasColumna = new ArrayList<>();
        try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("""
                                         SELECT p.ID_PRODUCTO, p.NOMBRE, p.PRECIO_COMPRA, p.PRECIO_VENTA, p.IVA, COALESCE(SUM(i.CANTIDAD), 0), pr.NOMBRE, pr.RUT_PROVEEDOR, c.DENOMINACION 
                                         FROM producto AS p 
                                         INNER JOIN proveedor AS pr ON pr.RUT_PROVEEDOR = p.RUT_PROVEEDOR 
                                         INNER JOIN categoria AS c ON c.ID_CATEGORIA = p.ID_CATEGORIA 
                                         LEFT JOIN inventario_ferreteria AS i ON i.ID_PRODUCTO = p.ID_PRODUCTO
                                         GROUP BY p.ID_PRODUCTO, p.NOMBRE, p.PRECIO_COMPRA, p.PRECIO_VENTA, p.IVA, pr.NOMBRE, pr.RUT_PROVEEDOR, c.DENOMINACION
                                         ORDER BY p.ID_PRODUCTO;
                                         """);
        while (rs.next()) {
            String ID = rs.getString(1);
            String nombre = rs.getString(2);
            int pc = rs.getInt(3);
            int pv = rs.getInt(4);
            int iva = rs.getInt(5);
            int cantidad = rs.getInt(6);
            String prov = rs.getString(7);
            String rut = rs.getString(8);
            String categ = rs.getString(9);
            
            
            datos[0] = ID;
            datos[1] = nombre;
            datos[2] = String.valueOf(pc);
            datos[3] = String.valueOf(pv);
            datos[4] = String.valueOf(iva);
            datos[5] = String.valueOf(cantidad);
            datos[6] = prov;
            datos[7] = rut;
            datos[8] = categ;
             
            filasColumna.add(datos.clone());
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasColumna;
    }
}
