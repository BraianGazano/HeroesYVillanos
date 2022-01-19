package tests;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import atributo.AtributoCondicional;
import atributo.AtributoOperacionDivisor;
import atributo.AtributoSimple;

import juego.Personaje;

public class PersonajeTest {
	
	private Personaje batman;	
	
	@Before
	public void inicializarPersonajes() {
		this.batman = new Personaje("Bruce", "Batman");
	}
	
	@Test
	public void comprobarNombresDelPersonaje() {
		
		Assert.assertEquals("Bruce",this.batman.getNombre());
		Assert.assertEquals("Batman",this.batman.getNombreFantasia());
	}
	

	@Test
	public void añadirUnAtributoSimpleAUnPersonajeYRecuperarlo() {
		this.batman.addAtributo("Fuerza", new AtributoSimple(40));
		Assert.assertEquals(40, this.batman.getValorAtributo("Fuerza"),0.1);
	}
	
	@Test
	public void añadirUnAtributoDivisorAUnPersonajeYRecuperarlo() {
		this.batman.addAtributo("Fuerza", new AtributoSimple(40));
		this.batman.addAtributo("Destreza", new AtributoSimple(20));
		this.batman.addAtributo("Habilidad",new AtributoOperacionDivisor("Fuerza","Destreza"));
		Assert.assertEquals(2, this.batman.getValorAtributo("Habilidad"),0.1);
	}
	
	@Test
	public void añadirUnAtributoCondicionalAUnPersonajeYRecuperarlo() {
		this.batman.addAtributo("Fuerza", new AtributoSimple(40));
		this.batman.addAtributo("Destreza", new AtributoSimple(20));
		this.batman.addAtributo("Inteligencia",new AtributoCondicional("Fuerza","Destreza",new AtributoSimple(30),new AtributoSimple(35)));
		Assert.assertEquals(30, this.batman.getValorAtributo("Inteligencia"),0.1);
	}

	
	@Test
	public void obtenerUnaListaConElPersonajeIncluidoEnElla() {
		List<Personaje> personaje = new LinkedList<Personaje>();
		personaje.add(this.batman);
		Assert.assertEquals(personaje, this.batman.getPersonajes());
	}
}
