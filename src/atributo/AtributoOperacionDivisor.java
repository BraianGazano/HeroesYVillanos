package atributo;

import juego.Enfrentable;

public class AtributoOperacionDivisor extends AtributoOperacion {

    public AtributoOperacionDivisor(String key1, String key2) {
        super(key1, key2);
    }

    @Override
    public float getValor(Enfrentable e) {
        return e.getValorAtributo(key1) / e.getValorAtributo(key2);
    }

}
