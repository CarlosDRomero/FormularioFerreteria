
package Interfaz;


import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
/**
 *
 * @author LUIS
 */
public final class Diseño extends javax.swing.JFrame {
    private int fm=-1;
    ArrayList<Proveedor> proveedores;
    ArrayList<Categoria> categorias;
    ArrayList<Producto> productos;
    ProductoDAO pd;
    CategoriaDAO cd;
    ProveedorDAO prd;
    
    
    public Diseño() throws SQLException {
        initComponents();
        pd = new ProductoDAO();
        cd = new CategoriaDAO();
        prd= new ProveedorDAO();
       proveedores = prd.cargarProveedores();
       categorias = cd.cargarCategorias();
       
       for(Proveedor p: proveedores){
            JCprovedores.addItem(p.getNombre());
        }
        for(Categoria p: categorias){
            JCcategorias.addItem(p.getDenominacion());
        }
        ActualizarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBase = new javax.swing.JPanel();
        JPanelMenu = new javax.swing.JPanel();
        Insertar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        jPanelAparicion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        precio_compra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        precio_venta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        iva = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JCprovedores = new javax.swing.JComboBox<>();
        JCcategorias = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanelBase.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBase.setLayout(null);

        JPanelMenu.setBackground(new java.awt.Color(0, 102, 204));
        JPanelMenu.setForeground(new java.awt.Color(255, 51, 51));
        JPanelMenu.setLayout(null);

        Insertar.setText("INSERTAR");
        Insertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InsertarMouseClicked(evt);
            }
        });
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });
        JPanelMenu.add(Insertar);
        Insertar.setBounds(10, 110, 240, 80);

        Eliminar.setText("ELIMINAR");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        JPanelMenu.add(Eliminar);
        Eliminar.setBounds(10, 290, 240, 80);

        Modificar.setText("MODIFICAR");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        JPanelMenu.add(Modificar);
        Modificar.setBounds(10, 198, 240, 80);

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel1.setText("    MENU");
        JPanelMenu.add(jLabel1);
        jLabel1.setBounds(70, 30, 120, 40);

        Salir.setText("SALIR");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        JPanelMenu.add(Salir);
        Salir.setBounds(10, 540, 240, 80);

        jPanelBase.add(JPanelMenu);
        JPanelMenu.setBounds(0, 0, 260, 660);

        jPanelAparicion.setBackground(new java.awt.Color(0, 102, 204));
        jPanelAparicion.setLayout(null);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setText("FORMULARIO ");
        jPanelAparicion.add(jLabel2);
        jLabel2.setBounds(340, 20, 150, 50);

        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });
        jPanelAparicion.add(Nombre);
        Nombre.setBounds(180, 110, 90, 22);
        jPanelAparicion.add(precio_compra);
        precio_compra.setBounds(310, 110, 90, 22);

        jLabel3.setText("Nombre");
        jPanelAparicion.add(jLabel3);
        jLabel3.setBounds(200, 90, 100, 16);

        jLabel4.setText("precio_compra");
        jPanelAparicion.add(jLabel4);
        jLabel4.setBounds(320, 90, 100, 16);

        jLabel6.setText("Categoria");
        jPanelAparicion.add(jLabel6);
        jLabel6.setBounds(480, 160, 51, 16);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Fecha Nacimiento", "Fecha Matricula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jPanelAparicion.add(jScrollPane1);
        jScrollPane1.setBounds(30, 240, 720, 350);

        jLabel7.setText("Provedor");
        jPanelAparicion.add(jLabel7);
        jLabel7.setBounds(470, 90, 48, 16);

        precio_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio_ventaActionPerformed(evt);
            }
        });
        jPanelAparicion.add(precio_venta);
        precio_venta.setBounds(180, 180, 90, 22);

        jLabel5.setText("        precio_venta");
        jPanelAparicion.add(jLabel5);
        jLabel5.setBounds(170, 160, 100, 20);
        jPanelAparicion.add(iva);
        iva.setBounds(310, 180, 90, 22);

        jLabel8.setText("iva");
        jPanelAparicion.add(jLabel8);
        jLabel8.setBounds(350, 160, 50, 16);

        JCprovedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCprovedoresActionPerformed(evt);
            }
        });
        jPanelAparicion.add(JCprovedores);
        JCprovedores.setBounds(520, 110, 170, 22);

        jPanelAparicion.add(JCcategorias);
        JCcategorias.setBounds(520, 180, 180, 22);

        jPanelBase.add(jPanelAparicion);
        jPanelAparicion.setBounds(270, 0, 840, 660);

        getContentPane().add(jPanelBase);
        jPanelBase.setBounds(0, 0, 1110, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InsertarMouseClicked
          
    }//GEN-LAST:event_InsertarMouseClicked

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        JOptionPane.showMessageDialog(null, "GRACIAS POR USAR EL PROGRAMA MACPATO");
        System.exit(0);
                
    }//GEN-LAST:event_SalirActionPerformed

    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed

        if (!validarCampos()) {
            JOptionPane.showMessageDialog(null, "Hay algun campo queno deberia estar vacio");
            return;
        }
        String nombre = Nombre.getText();
        int precioCompra = Integer.parseInt(precio_compra.getText());
        int precioVenta = Integer.parseInt(precio_venta.getText());
        int IVA = Integer.parseInt(iva.getText());
        Proveedor pr = proveedores.get(JCprovedores.getSelectedIndex());
        String rutProveedor = pr.getRut();
        int idCategoria = JCcategorias.getSelectedIndex() + 1;
        Producto producto = new Producto(0, nombre, precioCompra, precioVenta, IVA, rutProveedor, idCategoria);
         try {
             if(pd.InsertarProducto(producto)){
              limpiar();
             ActualizarDatos();
             }
         } catch (SQLException ex) {
             Logger.getLogger(Diseño.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_InsertarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
      int a=Tabla.getSelectedRow();
         try {
             pd.eliminarProducto(productos.get(a));
             ActualizarDatos();
         } catch (SQLException ex) {
             Logger.getLogger(Diseño.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_EliminarActionPerformed

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    private void precio_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precio_ventaActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed

      if (fm==-1) {
           return; 
        }
      if(!validarCampos()){
          MostarErrores();
       return;
       }
      
      
       Producto p = productos.get(fm);
       p.setNombre(Nombre.getText());
       p.setPrecio_compra(Integer.parseInt(precio_compra.getText()));
       p.setPrecio_venta(Integer.parseInt(precio_venta.getText()));
       p.setIVA(Integer.parseInt(iva.getText()));
       int indice_prov= proveedores.stream() .map(Proveedor::getRut) .collect(java.util.stream.Collectors.toList()) .indexOf(p.getRutProveedor());;
       Proveedor pr = proveedores.get(indice_prov) ;
       p.setRutProveedor(pr.getRut());
       p.setId_categoria(JCcategorias.getSelectedIndex()+1);
       
       
    }//GEN-LAST:event_ModificarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
      
        fm= Tabla.getSelectedRow();
        
    Producto p = productos.get(fm);
    Nombre.setText(p.getNombre());
    precio_compra.setText(String.valueOf(p.getPrecio_compra()));
    precio_venta.setText(String.valueOf(p.getPrecio_venta()));
    iva.setText(String.valueOf(p.getIVA())); 
    int indice_prov= proveedores.stream() .map(Proveedor::getRut) .collect(java.util.stream.Collectors.toList()) .indexOf(p.getRutProveedor());;
    JCcategorias.setSelectedIndex(p.getId_categoria()-1);
    JCprovedores.setSelectedIndex(indice_prov);
    
    }//GEN-LAST:event_TablaMouseClicked

    private void JCprovedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCprovedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCprovedoresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Diseño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Diseño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Diseño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Diseño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Diseño i =new Diseño();
                    i.setVisible(true);
                     i.setSize(1070, 700);
                    i.setResizable(false);
                    i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } catch (SQLException ex) {
                    Logger.getLogger(Diseño.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    } 
    public String combobox(JComboBox combobox){
    Object selectedItem = combobox.getSelectedItem();
    if (selectedItem != null) {
    String selectedValue = selectedItem.toString();
    System.out.println("Valor seleccionado: " + selectedValue);
    return selectedValue;
    } else {
    System.out.println("Ningún elemento seleccionado");}
        return null;

    }
    
    public void limpiar(){
    Nombre.setText("");
    precio_venta.setText("");
    precio_compra.setText("");
    iva.setText("");
    }
//  import javax.swing.JTextField;


    public boolean validarCampos() {
        if (Nombre.getText().isEmpty() || precio_compra.getText().isEmpty()
                || precio_venta.getText().isEmpty() || iva.getText().isEmpty()) {
            return false;
        }

        try {
            double precioCompra = Double.parseDouble(precio_compra.getText());
            double precioVenta = Double.parseDouble(precio_venta.getText());
            double IVA = Double.parseDouble(iva.getText());
            
            if (precioCompra <= 0 || precioVenta <= 0 || IVA < 0 || precioCompra >= precioVenta) {
                return false; 
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }


     public void MandardDatosTabla(ArrayList<String[]>filas) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Nombre");
    model.addColumn("Precio compra");
    model.addColumn("Precio Venta");
    model.addColumn("iva");
    model.addColumn("Proveedor");
    model.addColumn("rut");
    model.addColumn("Categoria");
    Tabla.setModel(model);
         for (String[] fila : filas) {
             model.addRow(fila);
         }

}
     public void ActualizarDatos() throws SQLException{
    productos = pd.obtenerProductos();
    MandardDatosTabla(pd.obtenerDatosTabla());

}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Insertar;
    public static javax.swing.JComboBox<String> JCcategorias;
    public static javax.swing.JComboBox<String> JCprovedores;
    private javax.swing.JPanel JPanelMenu;
    private javax.swing.JButton Modificar;
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton Salir;
    public static javax.swing.JTable Tabla;
    private javax.swing.JTextField iva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanelAparicion;
    private javax.swing.JPanel jPanelBase;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField precio_compra;
    private javax.swing.JTextField precio_venta;
    // End of variables declaration//GEN-END:variables
}
