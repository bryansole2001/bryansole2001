/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.Categoria;
import Modelo.Producto;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bryan
 */
public class Controlador_Producto {
    
    //METODO GUARDAR PRODUCTO
    public boolean guardar(Producto objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.Conectar();
        
        try {
                   
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("insert into producto values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getNombre());
            consulta.setInt(3, objeto.getCantidad());
            consulta.setDouble(4, objeto.getPrecio());
            consulta.setString(5, objeto.getDescripcion());
            consulta.setInt(6, objeto.getPorcentajeiva());
            consulta.setInt(7, objeto.getIdCategoria());
            consulta.setInt(8, objeto.getEstado());
            
            if(consulta.executeUpdate()>0){
                respuesta=true;
            }
            cn.close();
            

            

        } catch (SQLException e) {
            System.out.println("error al guardar Producto"+ e);

        }
        return respuesta;

    }
    
    
    
    
    //consulta si existe PRODUCTO
    public boolean existeProdu(String producto) {
        boolean respuesta = false;
        String sql="select nombre from  producto where  nombre = '"+producto+"';";
        Statement st;
        
        try {
            Connection cn= Conexion.Conectar();
            st=cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                respuesta=true;
                
            }
                   
            

        } catch (SQLException e) {
            System.out.println("error al consultar"+ e);

        }
        return respuesta;

    }
    
    
    
    
    //actualizar producto
    
    public boolean actualizar(Producto objeto, int idProducto) {
        boolean respuesta = false;
        Connection cn = Conexion.Conectar();
        
        try {
                   
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("update producto set nombre=?,cantidad=?,precio=?,descripcion=?,porcentajeIva=?,idCategoria=?,estado=?  where idProducto= '"+idProducto+"'");
            consulta.setString(1, objeto.getNombre());
            consulta.setInt(2, objeto.getCantidad());
            consulta.setDouble(3,objeto.getPrecio());
            consulta.setString(4,objeto.getDescripcion());
            consulta.setInt(5, objeto.getPorcentajeiva());
            consulta.setInt(6, objeto.getIdCategoria());
            consulta.setInt(7, objeto.getEstado());
            
            
            if(consulta.executeUpdate()>0){
                respuesta=true;
            }
            cn.close();


        } catch (SQLException e) {
            System.out.println("error al actualizar producto"+ e);

        }
        return respuesta;

    }
    
    
    //metodo eliminar
    public boolean eliminar(int idProducto) {
        boolean respuesta = false;
        Connection cn = Conexion.Conectar();
        
        try {
                   
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("delete from producto where idProducto= '"+idProducto+"'");
            consulta.executeUpdate();
            
            
            if(consulta.executeUpdate()>0){
                respuesta=true;
            }
            cn.close();
            

            

        } catch (SQLException e) {
            System.out.println("error al eliminar producto"+ e);

        }
        return respuesta;

    }
    
    
    
    
}
