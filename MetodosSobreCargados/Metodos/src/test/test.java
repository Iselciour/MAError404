package test;
import metodos.metodosSobreC;

public class test {
    public static void main(String[] args){
        double resultado1 = metodosSobreC.area(20, 20); //int = area de rectangulos
        double resultado2 = metodosSobreC.area(20L, 20L); //double = area de triangulos
        double resultado3 = metodosSobreC.area(20); // Un dato = area de circulo
        System.out.println("Resultado 1: " + resultado1 + "\nResultado 2: " + resultado2+ "\nResultado 3: " + resultado3);        
    }
}
