package test;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test {
    public static void main(String[] args) {
        //cadena de conexión
        String url = "jdbc:mysql://localhost:3306/prueba?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            // Web Interface
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "databaseAdmin123");
            Statement intruccion = conexion.createStatement();
            String sql = "SELECT idpersona, nombre, apellido, email, telefono FROM prueba.persona";
            ResultSet resultado = intruccion.executeQuery(sql);// Ejecuta la consulta de instruccion
            // Para recorrer los elementos de la consulta
            while(resultado.next()){
                System.out.println("Id Persona:"+resultado.getString("idpersona"));
                System.out.println("Nombre:"+resultado.getString("nombre"));
                System.out.println("Apellidos:"+resultado.getString("apellido"));
                System.out.println("Email:"+resultado.getString("email"));
                System.out.println("telefono:"+resultado.getString("telefono"));
                System.out.println("\n");
            }
            // Cerrar sesión
            resultado.close();
            intruccion.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        }
        
    }
}