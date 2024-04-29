package it.uniroma3.diadia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	private Partita partita;
	private Labirinto labirinto;
	private Stanza nuovaStanzaVincente;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita(this.labirinto);
		this.labirinto = new Labirinto();
		this.nuovaStanzaVincente = new Stanza("nuovaStanzaVincente");
	}
	
	/**
	 * Test per il metodo vinta
	 */
	@Test
	public void testNonVinta() {
		assertFalse(this.partita.vinta());
	}
	@Test
	public void testPartitaVinta() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	@Test
	public void testPartitaVintaConCambioDiStanzaVincente() {
		this.labirinto.setStanzaVincente(nuovaStanzaVincente);
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	/*+
	 * Test per il metodo isFinita
	 */
	@Test
	public void testPartitaFinita() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	@Test
	public void testPartitaFinitaSeVinta() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}
	@Test
	public void testPartitaFinitaSeGiocatoreFinisceCFU() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}

}
