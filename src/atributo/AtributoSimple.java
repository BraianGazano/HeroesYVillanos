package atributo;

import juego.Enfrentable;

public class AtributoSimple implements Atributo {

    private float value;

    public AtributoSimple(float value) {
        setValor(value);
    }

    @Override
    public float getValor(Enfrentable e) {
        return value;
    }
    
    public void setValor(float value){
    	this.value = value;
    }
}
