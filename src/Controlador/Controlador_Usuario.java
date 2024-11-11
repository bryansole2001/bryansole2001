package Controlador;

import Conexion.Conexion;
import Modelo.Usuario;
import java.sql.Statement;
//import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class Controlador_Usuario {

    //metodo para inisiar sesion 
    public boolean login(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.Conectar();
        String sql = "select usuario,password from usuarios where usuario = '" + objeto.getUsuario() +"' and password = '" + objeto.getPassword() + "'";
        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuesta = true;

            }

        } catch (SQLException e) {
            System.out.println("error al inicio de sesion");
            JOptionPane.showMessageDialog(null, "error al inicio de sesion");

        }
        return respuesta;

    }

}
