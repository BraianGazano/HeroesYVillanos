package juego;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import atributo.Atributo;

public class Personaje extends Enfrentable {

    private Map<String, Atributo> atributos;

    public Personaje(String nombre, String nombreFantasia) {
        super(nombre, nombreFantasia);
        this.atributos = new HashMap<String, Atributo>();
    }

    @Override
    public float getValorAtributo(String key) {
        Atributo atributo = atributos.get(key);
        if (atributo != null) {
            return atributo.getValor(this);
        }
        return 0;
    }

    @Override
    protected List<Personaje> getPersonajes() {
        List<Personaje> personaje = new LinkedList<Personaje>();
        personaje.add(this);
        return personaje;
    }

}
