package tests;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import atributo.AtributoSimple;
import comparators.ComparatorCompuesto;
import comparators.ComparatorCriterioSimple;
import juego.Liga;
import juego.Enfrentable;
import juego.Juego;
import juego.Personaje;

public class JuegoTest {

	private Juego juego;
	
	
	@Before
	public void inicializarJuego() {
		this.juego = new Juego();
	}
	
	@Test
	public void añadirUnPersonajeAlJuego() {
		Assert.assertTrue(this.juego.addEnfrentable(new Personaje("Bruce","Batman")));
	}
	
	@Test
	public void enfrentarPorFuerzaADosPersonajes() {
		Personaje batman = new Personaje("Bruce","Batman");
		Personaje superman = new Personaje("Clark","Superman");
		batman.addAtributo("Fuerza", new AtributoSimple(40));
		superman.addAtributo("Fuerza", new AtributoSimple(45));
		
		ComparatorCriterioSimple c = new ComparatorCriterioSimple("Fuerza");
		Assert.assertEquals(superman,juego.enfrentar(batman, superman, c));
	}
	
	@Test
	public void enfrentarPorFuerzaYAlObtenerEmpateLuegoPorDestreza() {
		Personaje batman = new Personaje("Bruce","Batman");
		Personaje superman = new Personaje("Clark","Superman");
		batman.addAtributo("Fuerza", new AtributoSimple(40));
		batman.addAtributo("Fuerza", new AtributoSimple(40));
		superman.addAtributo("Destreza", new AtributoSimple(50));
		superman.addAtributo("Destreza", new AtributoSimple(10));
		
		List<Comparator<Enfrentable>> comparators = new LinkedList<Comparator<Enfrentable>>();
		comparators.add(new ComparatorCriterioSimple("Fuerza"));
		comparators.add(new ComparatorCriterioSimple("Destreza"));
		
		ComparatorCompuesto c = new ComparatorCompuesto(comparators);
		Assert.assertEquals(batman,juego.enfrentar(batman, superman, c));
	}
	
	@Test
	public void enfrentarUnaLigaContraUnPersonaje() {
		Liga liga = new Liga("Liga","Liga de la Justicia");
		Personaje batman = new Personaje("Bruce","Batman");
		Personaje superman = new Personaje("Clark","Superman");
		Personaje flash = new Personaje("Barry","Flash");
		batman.addAtributo("Fuerza", new AtributoSimple(20));
		superman.addAtributo("Fuerza", new AtributoSimple(40));
		flash.addAtributo("Fuerza", new AtributoSimple(15));
		liga.addIntegrante(batman);
		liga.addIntegrante(flash);
		
		ComparatorCriterioSimple c = new ComparatorCriterioSimple("Fuerza");
		Assert.assertEquals(superman,juego.enfrentar(liga, superman, c));
	}
	
	
	@Test
	public void obtenerQuienesVencenAUnPersonaje() {
		Personaje batman = new Personaje("Bruce","Batman");
		Personaje superman = new Personaje("Clark","Superman");
		Personaje flash = new Personaje("Barry","Flash");
		batman.addAtributo("Fuerza", new AtributoSimple(20));
		superman.addAtributo("Fuerza", new AtributoSimple(40));
		flash.addAtributo("Fuerza", new AtributoSimple(15));
		
		juego.addEnfrentable(batman);
		juego.addEnfrentable(superman);
		juego.addEnfrentable(flash);
		
		ComparatorCriterioSimple c = new ComparatorCriterioSimple("Fuerza");
		List<Personaje> resultado = new LinkedList<Personaje>();
		resultado.add(batman);
		resultado.add(superman);
		Assert.assertEquals(resultado,juego.getQuienesVencen(flash, c));
	}
	
	@Test
	public void ordenarPersonajesPorAtributoFuerza() {
		Personaje batman = new Personaje("Bruce","Batman");
		Personaje superman = new Personaje("Clark","Superman");
		Personaje flash = new Personaje("Barry","Flash");
		batman.addAtributo("Fuerza", new AtributoSimple(20));
		superman.addAtributo("Fuerza", new AtributoSimple(40));
		flash.addAtributo("Fuerza", new AtributoSimple(15));
		
		juego.addEnfrentable(batman);
		juego.addEnfrentable(superman);
		juego.addEnfrentable(flash);
		
		ComparatorCriterioSimple c = new ComparatorCriterioSimple("Fuerza");
		List<Personaje> resultado = new LinkedList<Personaje>();
		resultado.add(flash);
		resultado.add(batman);
		resultado.add(superman);
		Assert.assertEquals(resultado,juego.ordenarPersonajes(c));		
	}
	
}
