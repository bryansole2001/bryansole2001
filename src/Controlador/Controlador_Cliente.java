package Controlador;

import Conexion.Conexion;
import Modelo.Cliente;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bryan
 */
public class Controlador_Cliente {

    //METODO GUARDAR CLIENTE
    public boolean guardar(Cliente objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.Conectar();

        try {

            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("insert into clientes values(?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getCedula());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getDireccion());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("error al guardar Cliente" + e);

        }
        return respuesta;

    }

    //consulta si existe PRODUCTO
    public boolean existeCliente(String cedula) {
        boolean respuesta = false;
        String sql = "select cedula nombre from  clientes where  cedula = '" + cedula + "';";
        Statement st;

        try {
            Connection cn = Conexion.Conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;

            }
        } catch (SQLException e) {
            System.out.println("error al consultar cliente" + e);

        }
        return respuesta;

    }
    
    
    
    //actualizar cliente
    
    public boolean actualizar(Cliente objeto, int idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.Conectar();
        
        try {
                   
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("update clientes set nombre=?,apellido=?,cedula=?,telefono=?,direccion=?,estado=?  where idClientes= '"+idCliente+"'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3,objeto.getCedula());
            consulta.setString(4,objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            consulta.setInt(6, objeto.getEstado());
            
            
            if(consulta.executeUpdate()>0){
                respuesta=true;
            }
            cn.close();


        } catch (SQLException e) {
            System.out.println("error al actualizar Cliente"+ e);

        }
        return respuesta;

    }
    
    
    //metodo eliminar
    public boolean eliminar(int idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.Conectar();
        
        try {
                   
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("delete from clientes where idClientes= '"+idCliente+"'");
            consulta.executeUpdate();
            
            
            if(consulta.executeUpdate()>0){
                respuesta=true;
            }
            cn.close();
            

            

        } catch (SQLException e) {
            System.out.println("error al eliminar cliente"+ e);

        }
        return respuesta;

    }

}
