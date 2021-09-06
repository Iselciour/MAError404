package datos;

import static datos.Conexion.*;
import domain.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioDAO {
    
    private Connection conexionTransaccional;
    
    //private static final int a = 3;
    private static final String SQL_SELECT = "SELECT idusuario, username, passw FROM dabase.usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(username, passw) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET username = ?, passw = ? WHERE idusuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE idusuario=?";
    
    public UsuarioDAO() {

    }

    public UsuarioDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
    public List<Usuario> seleccionar() throws SQLException{
        //Inicializar parametros de conexión
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt  = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                int idUsuario = rs.getInt("idusuario");
                String username = rs.getString("username");
                String passw = rs.getString("passw");
                
                usuario = new Usuario(idUsuario, username, passw);
                
                usuarios.add(usuario);
            }
            
        } 
//        catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
        
        finally{
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                
            }            
        }
        return usuarios;
    }
    
    public int insertar(Usuario usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsername());//?
            stmt.setString(2, usuario.getPassw());
            
            registros = stmt.executeUpdate(); 
            
        } 
//        catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
        finally{
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int actualizar(Usuario usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0; 
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassw());
            stmt.setInt(3, usuario.getIdUsuario()); 
                        
            registros = stmt.executeUpdate(); 
            
        } 
//        catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
        finally{
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
        public int eliminar(Usuario usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);           
            stmt.setInt(1, usuario.getIdUsuario());
                        
            registros = stmt.executeUpdate();
            
        } 
//        catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
        finally{
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    
}
