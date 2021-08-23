package metodos;

public class metodosSobreC {
    public static int area(int a, int b){
        System.out.println("Metodo Rectangulo");
        return a*b;
    }
    
    public static double area(double a, double b){
        System.out.println("Metodo Triangulo");
        return (a*b)/2;
    }
    
    public static double area(double a){
        System.out.println("Metodo Circulo");
        return ((a*a)*3.14);
    }
}
