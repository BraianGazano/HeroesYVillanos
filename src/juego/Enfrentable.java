package juego;

import java.util.Comparator;
import java.util.List;

public abstract class Enfrentable {

    protected String nombre;
    protected String nombreFantasia;

    public Enfrentable(String nombre, String nombreFantasia) {
        this.nombre = nombre;
        this.nombreFantasia = nombreFantasia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public abstract float getValorAtributo(String key);

    protected abstract List<Personaje> getPersonajes();

    public Enfrentable enfrentar(Enfrentable e, Comparator<Enfrentable> c) {
        return null;
    }

    public List<Personaje> ordenar(Comparator<Enfrentable> c) {
        return null;
    }

}
