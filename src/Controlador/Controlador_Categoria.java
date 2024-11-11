
package Controlador;

import Conexion.Conexion;
import Modelo.Categoria;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

//registro de categoria
public class Controlador_Categoria {
    public boolean guardar(Categoria objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.Conectar();
        
        try {
                   
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("insert into categoria values(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());
            
            if(consulta.executeUpdate()>0){
                respuesta=true;
            }
            cn.close();
            

            

        } catch (SQLException e) {
            System.out.println("error al guardar categoria"+ e);

        }
        return respuesta;

    }
    
    
    //consulta si existe categoria
    public boolean existeCat(String categoria) {
        boolean respuesta = false;
        String sql="select descripcion from  categoria where  descripcion = '"+categoria+"';";
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
    
    
    //metodo actualizar
    public boolean actualizar(Categoria objeto, int idCategoria) {
        boolean respuesta = false;
        Connection cn = Conexion.Conectar();
        
        try {
                   
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("update categoria set descripcion = ? where idCategoria= '"+idCategoria+"'");
            consulta.setString(1, objeto.getDescripcion());
            
            
            if(consulta.executeUpdate()>0){
                respuesta=true;
            }
            cn.close();
            

            

        } catch (SQLException e) {
            System.out.println("error al actualizar"+ e);

        }
        return respuesta;

    }
    
    
    //metodo eliminar
    public boolean eliminar(int idCategoria) {
        boolean respuesta = false;
        Connection cn = Conexion.Conectar();
        
        try {
                   
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("delete from categoria where idCategoria= '"+idCategoria+"'");
            consulta.executeUpdate();
            
            
            if(consulta.executeUpdate()>0){
                respuesta=true;
            }
            cn.close();
            

            

        } catch (SQLException e) {
            System.out.println("error al eliminar"+ e);

        }
        return respuesta;

    }
    
}


