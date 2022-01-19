package juego;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Juego {

    private List<Enfrentable> enfrentables;

    public Juego() {
        this.enfrentables = new LinkedList<Enfrentable>();
    }

    public List<Enfrentable> getQuienesVencen(Enfrentable e, Comparator<Enfrentable> c) {
        return null;
    }

    public Enfrentable enfrentar(Enfrentable e1, Enfrentable e2, Comparator<Enfrentable> c) {
        return null;
    }

    public boolean addEnfrentable(Enfrentable e) {
        return false;
    }

    public List<Personaje> ordenarPersonajes(Comparator<Enfrentable> c) {
        return null;
    }
}
