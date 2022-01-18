package juego;

import java.util.LinkedList;
import java.util.List;

public class Liga extends Enfrentable {

    private List<Enfrentable> integrantes;

    public Liga(String nombre, String nombreFantasia) {
        super(nombre, nombreFantasia);
        this.integrantes = new LinkedList<Enfrentable>();
    }

    public Liga(String nombre, String nombreFantasia, List<Enfrentable> integrantes) {
        super(nombre, nombreFantasia);
        this.integrantes = integrantes;
    }

    public boolean addIntegrante(Enfrentable e) {
        if (e != this) {
            return integrantes.add(e);
        }
        return false;
    }

    @Override
    public float getValorAtributo(String key) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    protected List<Personaje> getPersonajes() {
        // TODO Auto-generated method stub
        return null;
    }

}
