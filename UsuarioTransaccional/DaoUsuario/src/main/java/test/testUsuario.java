package test;

import java.util.List;
import datos.UsuarioDAO;
import domain.Usuario;

public class testUsuario {
    
    public static void main(String[] args) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        //Insertar
        //Usuario usuarioNuevo = new Usuario("joseedson91", "thismypass159");
        //usuarioDao.insertar(usuarioNuevo);
        
        //Actualizar
        Usuario usuarioEditar = new Usuario(3, "romeosanchez42", "scarlett595");
        usuarioDao.actualizar(usuarioEditar);
        
        //Elminar
        //Usuario usuarioEliminar = new Usuario(5);
        //usuarioDao.eliminar(usuarioEliminar);
        
        
        List<Usuario> usuarios = usuarioDao.seleccionar();
        usuarios.forEach(usuario -> {
            System.out.println(usuario);
        });

//        for (Usuario usuario:usuarios){
//            System.out.println("usuario"+usuario);
//        }
    }
    
}
