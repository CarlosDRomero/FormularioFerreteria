package formulario_ferreteria;

/**
 *
 * @author Lenovo
 */

import Interfaz.Diseño;
import modelo.*;
import modelo.conector;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;

public class FORMULARIO_FERRETERIA {

    
    public static void main(String[] args) throws SQLException{
        Diseño i =new Diseño();
        i.setVisible(true);
         i.setSize(1100, 700);
        i.setResizable(false);
        i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
