package domain;

public class Usuario {
    private int idUsuario;
    private String username;
    private String passw;

    //EJBean
    public Usuario() {
    }
    
    //Eliminar un registro
    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    //Nuevo regist4ro
    public Usuario(String username, String passw) {
        this.username = username;
        this.passw = passw;
    }
    
    // Modificación
    public Usuario(int idUsuario, String username, String passw) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.passw = passw;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassw() {
        return this.passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", user=" + username + ", password=" + passw + '}';
    }
}
