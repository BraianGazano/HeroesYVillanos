package tests;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import atributo.AtributoSimple;

import juego.Liga;
import juego.Personaje;

public class LigaTest {
	
	private Liga liga;	
	
	@Before
	public void inicializarLiga() {
		this.liga = new Liga("Liga","Liga de la Justicia");
	}
	
	@Test
	public void comprobarNombresDeLaLiga() {
		
		Assert.assertEquals("Liga",this.liga.getNombre());
		Assert.assertEquals("Liga de la Justicia",this.liga.getNombreFantasia());
	}
	

	@Test
	public void añadirUnPersonajeALaLigaYRecuperarlo() {
		Personaje batman = new Personaje("Bruce","Batman");
		List<Personaje> resultado = new LinkedList<Personaje>();
		resultado.add(batman);
		this.liga.addIntegrante(batman);
		Assert.assertEquals(resultado,this.liga.getPersonajes());
	}
	
	@Test
	public void intentarAñadirUnaLigaASiMisma() {
		Assert.assertFalse(this.liga.addIntegrante(liga));
	}
	
	@Test
	public void añadirUnaLigaAUnaLigaMasGrande() {
		Personaje batman = new Personaje("Bruce","Batman");
		Personaje superman = new Personaje("Clark","Superman");
		Personaje flash = new Personaje("Barry","Flash");
		Liga ligaMayor = new Liga("Liga mas grande","Liga");
		
		this.liga.addIntegrante(batman);
		ligaMayor.addIntegrante(superman);
		ligaMayor.addIntegrante(flash);
		ligaMayor.addIntegrante(this.liga);
		
		List<Personaje> resultado = new LinkedList<Personaje>();
		resultado.add(superman);
		resultado.add(flash);
		resultado.add(batman);
		Assert.assertEquals(resultado,ligaMayor.getPersonajes());		
	}

	
	@Test
	public void obtenerElValorTotalDeLosAtributosDeUnaLiga() {
		Personaje batman = new Personaje("Bruce","Batman");
		Personaje superman = new Personaje("Clark","Superman");
		Personaje flash = new Personaje("Barry","Flash");
		batman.addAtributo("Fuerza", new AtributoSimple(40));
		superman.addAtributo("Fuerza", new AtributoSimple(20));
		flash.addAtributo("Fuerza", new AtributoSimple(30));
		this.liga.addIntegrante(batman);
		this.liga.addIntegrante(superman);
		this.liga.addIntegrante(flash);
		Assert.assertEquals(30, this.liga.getValorAtributo("Fuerza"),0.1);
	}
}

