package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection Conectar() {

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/sistema_ventas", "root","Guitar3bry");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexion local: " + e);
        }
        return null;
    }

}
