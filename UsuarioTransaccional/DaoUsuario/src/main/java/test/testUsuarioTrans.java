package test;


import datos.Conexion;
import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class testUsuarioTrans {
    
    public static void main(String[] args) {
        Connection conexion = null;
        
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);// Para no hacer automaticamente el commit
            }
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
            
            Usuario actualizarUsuario = new Usuario();
            actualizarUsuario.setIdUsuario(1);
            actualizarUsuario.setUsername("hello");
            actualizarUsuario.setPassw("35435345345");
            usuarioDAO.actualizar(actualizarUsuario);
            
            
            Usuario nuevaUsuario = new Usuario();
            nuevaUsuario.setUsername("Shakira");
            nuevaUsuario.setPassw("Piqué");
            usuarioDAO.insertar(nuevaUsuario);
            
            conexion.commit();
            System.out.println("Se realizaron correctamente las modificaciones en la BD");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback - no fue posible realizar cambios");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
    
}
