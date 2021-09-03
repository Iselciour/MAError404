package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDAO {
    //private static final int a = 3;
    private static final String SQL_SELECT = "SELECT idpersona, nombre, apellido, email, telefono FROM dabase.persona";
    
    public List<Persona> eliminar(int g){
        //Inicializar parametros de conexión
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        String SQL_DELETE = "DELETE FROM dabase.persona WHERE idpersona=" + g;
        
        List<Persona> personas = new ArrayList<>();
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                //Obtener los atributos de cada usuario en la BD
                int idPersona = rs.getInt("idpersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                
                personas.add(persona);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        // Cerrar todos los objetos
        finally{
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                
            }            
        }
        return personas;
    }
    public List<Persona> seleccionar(){
        //Inicializar parametros de conexión
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        
        List<Persona> personas = new ArrayList<>();
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                //Obtener los atributos de cada usuario en la BD
                int idPersona = rs.getInt("idpersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                
                personas.add(persona);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        // Cerrar todos los objetos
        finally{
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                
            }            
        }
        return personas;
    }
    
}