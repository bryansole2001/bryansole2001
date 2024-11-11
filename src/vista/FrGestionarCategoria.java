/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;


import Conexion.Conexion;
import Controlador.Controlador_Categoria;
import Modelo.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bryan
 */
public class FrGestionarCategoria extends javax.swing.JInternalFrame {
    
    
    private int idCategoria;

    
    public FrGestionarCategoria() {
        initComponents();
        this.setSize(new Dimension(600,400));
        this.setTitle("Gestionar Categoria");
        this.CargarTablaCategoria();
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
        jTable_categoria = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        jLabel_fondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de categorias");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 250, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_categoria.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable_categoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_categoria);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 270));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 360, 290));

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
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 30));

        jButton_eliminar.setBackground(new java.awt.Color(255, 0, 51));
        jButton_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 170, 120));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Descripcion:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 200, 70));

        jLabel_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fondogestcat.jpg"))); // NOI18N
        getContentPane().add(jLabel_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        if(!txt_descripcion.getText().isEmpty()){
            Categoria categoria = new Categoria();
            Controlador_Categoria controladorcategoria = new Controlador_Categoria();
            
            categoria.setDescripcion(txt_descripcion.getText().trim());
            
            if(controladorcategoria.actualizar(categoria, idCategoria)){
                JOptionPane.showMessageDialog(null,"Actualizado");
                txt_descripcion.setText("");
                this.CargarTablaCategoria();
                
                
            }else{
                JOptionPane.showMessageDialog(null,"Error al actualizar");
                
            }
            
            
        }else{
            
            JOptionPane.showMessageDialog(null,"Seleccione una categoria para actualizar");
            
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        
        if(!txt_descripcion.getText().isEmpty()){
            Categoria categoria = new Categoria();
            Controlador_Categoria controladorcategoria = new Controlador_Categoria();
            
            categoria.setDescripcion(txt_descripcion.getText().trim());
            
            if(!controladorcategoria.eliminar(idCategoria)){
                JOptionPane.showMessageDialog(null,"Eliminado con exito");
                txt_descripcion.setText("");
                this.CargarTablaCategoria();
                
                
            }else{
                JOptionPane.showMessageDialog(null,"Error al ELIMINAR");
                
            }
            
            
        }else{
            
            JOptionPane.showMessageDialog(null,"Seleccione una categoria para eliminar");
            
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_categoria;
    private javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables


    //mostrar categorias registradas
    
    private void CargarTablaCategoria(){
        Connection con = Conexion.Conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql="select idCategoria,descripcion,estado from categoria";
        Statement st;
        
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            FrGestionarCategoria.jTable_categoria = new JTable(model);
            FrGestionarCategoria.jScrollPane1.setViewportView(FrGestionarCategoria.jTable_categoria);
            
            
            model.addColumn("idCategoria");
            model.addColumn("descripcion");
            model.addColumn("estado");
            
            while(rs.next()){
                Object fila[]=new Object[3];
                
                for(int i=0; i<3;i++){
                    fila[i]= rs.getObject(i+1);
                    
                    
                }
                
                model.addRow(fila);
            }
            con.close();
            
            
            
        } catch (SQLException e) {
            System.out.println("Error al llenar tabla" + e);
        }
        
        
        jTable_categoria.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int fila_point= jTable_categoria.rowAtPoint(e.getPoint());
                int columna_point=0;
                
                if (fila_point>=0){
                    idCategoria =(int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosCategoriaSeleccionada(idCategoria);
                            
                    
                }
            }
        });
        
    }
    
    private void EnviarDatosCategoriaSeleccionada (int idCategoria){
        try {
            Connection con = Conexion.Conectar();
            PreparedStatement pst = con.prepareStatement("select * from categoria where idCategoria='"+idCategoria+"'");
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                txt_descripcion.setText(rs.getString("descripcion"));
                
            }
            con.close();
            
            
        } catch (SQLException e) {
            System.out.println("Error al cargar categoria"+ e);
        }
    }




}
