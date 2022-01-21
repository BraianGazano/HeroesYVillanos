package juego;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Juego {

    private List<Enfrentable> enfrentables;

    public Juego() {
        this.enfrentables = new LinkedList<Enfrentable>();
    }

    public List<Enfrentable> getQuienesVencen(Enfrentable e, Comparator<Enfrentable> c) {

        List<Enfrentable> personajes = new LinkedList<Enfrentable>();
        for (Enfrentable enfrentable : enfrentables) {
            if (c.compare(e, enfrentable) < 0) {
                personajes.add(enfrentable);
            }
        }
        return personajes;
    }

    public Enfrentable enfrentar(Enfrentable e1, Enfrentable e2, Comparator<Enfrentable> c) {
        return e1.enfrentar(e2, c);
    }

    public boolean addEnfrentable(Enfrentable e) {
        return enfrentables.add(e);
    }

    public List<Personaje> ordenarPersonajes(Comparator<Enfrentable> c) {
    	
    	List<Personaje> personajes = enfrentables.stream()
				  .map(enfrentable -> enfrentable.ordenar(c))
				  .flatMap(List::stream)
				  .sorted(c)
				  .distinct()
				  .collect(Collectors.toList());
        return personajes;
    }
}
