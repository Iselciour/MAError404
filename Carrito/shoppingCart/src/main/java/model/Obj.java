package model;

public class Obj {
    String name;
    int av = 0;

    public Obj(String nombre) {
        this.name = nombre;
    }
    
    public String getName() {
        return name;
    }

    public void setNName(String nombre) {
        this.name = nombre;
    }

    public int getAv() {
        return av;
    }

    public void setAv(int av) {
        this.av = av;
    }
}
