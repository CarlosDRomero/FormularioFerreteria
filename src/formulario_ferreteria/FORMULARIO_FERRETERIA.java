package formulario_ferreteria;

/**
 *
 * @author Lenovo
 */

import modelo.*;
import modelo.conector;
import java.sql.*;
import java.util.ArrayList;

public class FORMULARIO_FERRETERIA {

    
    public static void main(String[] args) throws SQLException{
        ProductoDAO pd = new ProductoDAO();
       ArrayList<Producto> p = pd.obtenerProductos();
       
       for (Producto pr : p){
           System.out.print(pr.getId()+" ");
           System.out.print(pr.getNombre()+" ");
           System.out.print(pr.getPrecio_compra()+" ");
           System.out.print(pr.getPrecio_venta()+" ");
           System.out.print(pr.getRutProveedor()+"\n");
       }
    }
    
}
