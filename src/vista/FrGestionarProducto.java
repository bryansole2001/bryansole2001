/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import Conexion.Conexion;
import Controlador.Controlador_Categoria;
import Controlador.Controlador_Producto;
import Modelo.Categoria;
import Modelo.Producto;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bryan
 */
public class FrGestionarProducto extends javax.swing.JInternalFrame {

    private int idProducto;
    int obtenerIdCategoria = 0;

    public FrGestionarProducto() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar Producto");
        this.CargarTablaProducto();
        this.CargarComboCategoria();
        
        //insertar imagenes con codigo
        ImageIcon fondo = new ImageIcon("src/img/fondogestcat.jpg");
        Icon icono = new ImageIcon(fondo.getImage().getScaledInstance(900, 500, WIDTH));
        jLabel_fondo.setIcon(icono);
        this.repaint();
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                if (getParent() != null) {
                    setLocation((getParent().getWidth() - getWidth()) / 2, (getParent().getHeight() - getHeight()) / 2);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txt_nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        jComboBox_iva = new javax.swing.JComboBox<>();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jLabel_fondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 250, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 730, 280));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(102, 255, 51));
        jButton_actualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 30));

        jButton_eliminar.setBackground(new java.awt.Color(255, 0, 51));
        jButton_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, 30));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, 30));

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        jPanel2.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 120, 280));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 180, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Cantidad:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Precio:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 70, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Descripcion:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 90, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("IVA:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 90, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Categoria:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 90, -1));
        jPanel3.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 180, 30));
        jPanel3.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 180, 30));
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 180, 30));

        jComboBox_iva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox_iva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione iva:", "No grava iva", "12%", "15%" }));
        jPanel3.add(jComboBox_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 150, 30));

        jComboBox_categoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione categoria", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 170, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 870, 100));
        getContentPane().add(jLabel_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 890, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        Producto product = new Producto();
        Controlador_Producto controladorproducto = new Controlador_Producto();
        String iva = "";
        String categoria = "";
        iva = jComboBox_iva.getSelectedItem().toString().trim();
        categoria = jComboBox_categoria.getSelectedItem().toString().trim();

        //validar campos
        if (txt_nombre.getText().isEmpty() || txt_cantidad.getText().isEmpty() || txt_precio.getText().isEmpty()) {

            txt_nombre.setBackground(Color.red);
            txt_cantidad.setBackground(Color.red);
            txt_precio.setBackground(Color.red);
            txt_descripcion.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "complete todos los campos");
            txt_nombre.setBackground(Color.white);
            txt_cantidad.setBackground(Color.white);
            txt_precio.setBackground(Color.white);
            txt_descripcion.setBackground(Color.white);

        } else {

            if (iva.equalsIgnoreCase("Seleccione iva:")) {
                JOptionPane.showMessageDialog(null, "Seleccione iva.");

            } else {
                if (categoria.equalsIgnoreCase("seleccione categoria:")) {
                    JOptionPane.showMessageDialog(null, "Seleccione categoria.");

                } else {
                    try {

                        product.setNombre(txt_nombre.getText().trim());
                        product.setCantidad(Integer.parseInt(txt_cantidad.getText().trim()));
                        String precioTXT = "";
                        double Precio = 0.0;
                        precioTXT = txt_precio.getText().trim();
                        boolean aux = false;
                        //si el usuario ingresa (,) como punto decimal lo transformamos a punto 
                        for (int i = 0; i < precioTXT.length(); i++) {
                            if (precioTXT.charAt(i) == ',') {
                                String precioNuevo = precioTXT.replace(",", ".");
                                Precio = Double.parseDouble(precioNuevo);
                                aux = true;

                            }
                        }

                        //evaluar la condicion 
                        if (aux == true) {
                            product.setPrecio(Precio);

                        } else {
                            Precio = Double.parseDouble(precioTXT);
                            product.setPrecio(Precio);

                        }

                        product.setDescripcion(txt_descripcion.getText().trim());

                        //IVA
                        if (iva.equalsIgnoreCase("No grava iva")) {
                            product.setPorcentajeiva(0);

                        } else if (iva.equalsIgnoreCase("12%")) {
                            product.setPorcentajeiva(12);

                        } else if (iva.equalsIgnoreCase("15%")) {
                            product.setPorcentajeiva(15);

                        }

                        //llamar al metodo para obtener categoria
                        this.IdCategoria();
                        product.setIdCategoria(obtenerIdCategoria);
                        product.setEstado(1);

                        if (controladorproducto.actualizar(product, idProducto)) {
                            txt_nombre.setBackground(Color.green);
                            txt_cantidad.setBackground(Color.green);
                            txt_precio.setBackground(Color.green);
                            txt_descripcion.setBackground(Color.green);
                            JOptionPane.showMessageDialog(null, "Actualizado con exito.");
                            txt_nombre.setBackground(Color.white);
                            txt_cantidad.setBackground(Color.white);
                            txt_precio.setBackground(Color.white);
                            txt_descripcion.setBackground(Color.white);

                            this.CargarComboCategoria();
                            this.CargarTablaProducto();
                            this.jComboBox_iva.setSelectedItem("Seleccione iva:");
                            this.Limpiar();

                        } else {
                            JOptionPane.showMessageDialog(null, "Error al actualizar.");

                        }

                    } catch (HeadlessException | NumberFormatException e) {
                        System.out.println("Error en: " + e);
                    }

                }
            }

        }


    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed

        Controlador_Producto controladorProducto = new Controlador_Producto();
        if (idProducto == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else {
            if (!controladorProducto.eliminar(idProducto)) {
                JOptionPane.showMessageDialog(null, "Producto eliminado");
                this.CargarTablaProducto();
                this.CargarComboCategoria();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar producto");
            }
        }


    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.buscarProductoPorNombre();
        this.EnviarDatosProductoSeleccionada(idProducto);


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JComboBox<String> jComboBox_categoria;
    private javax.swing.JComboBox<String> jComboBox_iva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables

    //cargar categorias combo box
    private void CargarComboCategoria() {
        Connection cn = Conexion.Conectar();
        String sql = "select * from categoria";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_categoria.removeAllItems();
            jComboBox_categoria.addItem("Seleccione categoria");
            while (rs.next()) {
                jComboBox_categoria.addItem(rs.getNString("descripcion"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar categoria" + e);
        }
        
    }

    //mostrar productos registradas
    String descripcionCategoria = "";
    double precio = 0.0;
    int porcentajeIva = 0;
    double IVA = 0;

    private void CargarTablaProducto() {
        Connection con = Conexion.Conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select a.idProducto,a.nombre,a.cantidad,a.precio,a.descripcion,a.porcentajeiva,b.descripcion,a.estado from producto as a, categoria as b where a.idCategoria=b.idCategoria;";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            FrGestionarProducto.jTable_productos = new JTable(model);
            FrGestionarProducto.jScrollPane1.setViewportView(FrGestionarProducto.jTable_productos);

            model.addColumn("N°");
            model.addColumn("nombre");
            model.addColumn("cantidad");
            model.addColumn("precio");
            model.addColumn("descripcion");
            model.addColumn("iva");
            model.addColumn("categoria");
            model.addColumn("estado");

            while (rs.next()) {
                precio = rs.getDouble("precio");
                porcentajeIva = rs.getInt("porcentajeIva");

                Object fila[] = new Object[8];
                for (int i = 0; i < 8; i++) {

                    if (i == 5) {
                        this.calcularIva(precio, porcentajeIva);
                        fila[i] = IVA;
                        rs.getObject(i + 1);
                    } else {
                        fila[i] = rs.getObject(i + 1);

                    }

                }

                model.addRow(fila);
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar tabla producto" + e);
        }

        jTable_productos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_productos.rowAtPoint(e.getPoint());
                int columna_point = 0;
                int selectedRow = jTable_productos.getSelectedRow();

                if (fila_point >= 0) {
                    idProducto = (int) jTable_productos.getValueAt(selectedRow, 0);
                    //idProducto = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosProductoSeleccionada(idProducto);

                }
            }
        });

    }

    //calcular iva
    private double calcularIva(double precio, int iva) {
        int p_iva = iva;
        switch (p_iva) {
            case 0:
                IVA = 0.0;
                break;
            case 12:
                IVA = precio * 0.12;
                break;
            case 15:
                IVA = precio * 0.15;
                break;
            default:
                break;

        }
        //redondear decimales
        IVA = (double) Math.round(IVA * 100) / 100;
        return IVA;

    }

    private void EnviarDatosProductoSeleccionada(int idProducto) {
        try {
            Connection con = Conexion.Conectar();
            PreparedStatement pst = con.prepareStatement("select * from producto where idProducto='" + idProducto + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_nombre.setText(rs.getString("nombre"));
                txt_cantidad.setText(rs.getString("cantidad"));
                txt_precio.setText(rs.getString("precio"));
                txt_descripcion.setText(rs.getString("descripcion"));
                int iva = rs.getInt("porcentajeIva");
                switch (iva) {
                    case 0:
                        jComboBox_iva.setSelectedItem("No grava iva");
                        break;
                    case 12:
                        jComboBox_iva.setSelectedItem("12%");
                        break;
                    case 15:
                        jComboBox_iva.setSelectedItem("15%");
                        break;
                    default:
                        jComboBox_iva.setSelectedItem("Seleccione iva:");
                        break;

                }
                int idCate = rs.getInt("idCategoria");
                jComboBox_categoria.setSelectedItem(relacionarCategoria(idCate));

            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar producto" + e);
        }
    }

    //metodo para relacionar categoria
    private String relacionarCategoria(int idCategoria) {

        String sql = "select descripcion from categoria where idCategoria='" + idCategoria + "'";
        Statement st;

        try {
            Connection cn = Conexion.Conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                descripcionCategoria = rs.getString("descripcion");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener id categoria" + e);
        }
        return descripcionCategoria;

    }

    //metodo para limpiar
    private void Limpiar() {
        txt_nombre.setText("");
        txt_cantidad.setText("");
        txt_precio.setText("");
        txt_descripcion.setText("");
        jComboBox_iva.setSelectedItem("Seleccione iva:");
        jComboBox_categoria.setSelectedItem("Seleccione categoria");

    }

    private int IdCategoria() {
        String sql = "select * from categoria where descripcion = '" + this.jComboBox_categoria.getSelectedItem() + "'";
        Statement st;
        try {
            Connection cn = Conexion.Conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                obtenerIdCategoria = rs.getInt("idCategoria");

            }

        } catch (SQLException e) {
            System.out.println("Error al obtener id categoria" + e);
        }
        return obtenerIdCategoria;
    }

    private void buscarProductoPorNombre() {
        ;
        Connection con = Conexion.Conectar();
        String nombreProducto = txt_buscar.getText().trim(); // Obtiene el nombre del campo de texto.
        
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT a.idProducto, a.nombre, a.cantidad, a.precio, a.descripcion, a.porcentajeiva, b.descripcion, a.estado "
                + "FROM producto AS a, categoria AS b "
                + "WHERE a.idCategoria = b.idCategoria AND a.nombre LIKE ?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "%" + nombreProducto + "%"); // Búsqueda con comodín.
            ResultSet rs = pst.executeQuery();

            model.addColumn("N°");
            model.addColumn("nombre");
            model.addColumn("cantidad");
            model.addColumn("precio");
            model.addColumn("descripcion");
            model.addColumn("iva");
            model.addColumn("categoria");
            model.addColumn("estado");

            while (rs.next()) {
                Object[] fila = new Object[8];
                for (int i = 0; i < 8; i++) {
                    if (i == 5) {
                        double precio = rs.getDouble("precio");
                        int porcentajeIva = rs.getInt("porcentajeIva");
                        fila[i] = calcularIva(precio, porcentajeIva);
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }
                }
                model.addRow(fila);
            }

            jTable_productos.setModel(model);
            
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e);
        }
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTable_productos.getSelectedRow(); // Obtiene la fila seleccionada.

                if (selectedRow >= 0) {
                    int idProductoSeleccionado = (int) jTable_productos.getValueAt(selectedRow, 0);
                    // Rellena los campos de texto con los valores de la fila seleccionada.
                    txt_nombre.setText(jTable_productos.getValueAt(selectedRow, 1).toString());
                    txt_cantidad.setText(jTable_productos.getValueAt(selectedRow, 2).toString());
                    txt_precio.setText(jTable_productos.getValueAt(selectedRow, 3).toString());
                    txt_descripcion.setText(jTable_productos.getValueAt(selectedRow, 4).toString());
                    // Puedes continuar con los demás campos si es necesario.
                }
            }
        });
    }

    
        
    

}