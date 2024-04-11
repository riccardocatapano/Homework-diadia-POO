package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	
	private Labirinto labirinto;
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	

	@Before
	public void setUp() throws Exception {
		this.labirinto = new Labirinto();
		this.stanzaVincente = new Stanza("stanzaVincente");
		this.stanzaIniziale = new Stanza("stanzaIniziale");
		this.labirinto.setStanzaVincente(stanzaVincente);
		this.labirinto.setStanzaIniziale(stanzaIniziale);
	}
	
	/**
	 * Test per il metodo getStanzaVincente
	 */
	@Test
	public void testControlloDellaStanzaVincente() {
		assertEquals(stanzaVincente, this.labirinto.getStanzaVincente());
	}
	@Test
	public void testCambioStanzaVincente() {
		Stanza nuovaStanzaVincente = new Stanza("nuovaStanzaVincente");
		this.labirinto.setStanzaVincente(nuovaStanzaVincente);
		assertEquals(nuovaStanzaVincente, this.labirinto.getStanzaVincente());
	}
	/**
	 * Test per il metodo getStanzaIniziale
	 */
	@Test
	public void testControloStanzaIniziale() {
		assertEquals(stanzaIniziale, this.labirinto.getStanzaIniziale());
	}
	@Test
	public void testCambioStanzaVIniziale() {
		Stanza nuovaStanzaIniziale = new Stanza("nuovaStanzaIniziale");
		this.labirinto.setStanzaVincente(nuovaStanzaIniziale);
		assertEquals(nuovaStanzaIniziale, this.labirinto.getStanzaVincente());
	}

}
