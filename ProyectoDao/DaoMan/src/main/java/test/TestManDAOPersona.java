package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManDAOPersona {

    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        List<Persona> personas = personaDao.seleccionar();
        
        //List<Persona> personas = personaDao.eliminar(3);
        
        personas.forEach(persona -> {
            System.out.println(persona);
        });

//        for (Persona persona:personas){
//            System.out.println("persona"+persona);
//        }
    }

}