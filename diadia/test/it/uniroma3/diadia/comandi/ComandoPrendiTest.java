package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	
	private Labirinto labirinto;
	private ComandoPrendi prendi;
	private Partita partita;
	private Attrezzo attrezzo;

	@Before
	public void setUp() throws Exception {
		this.labirinto = new Labirinto();
		this.partita = new Partita(labirinto);
		this.attrezzo = new Attrezzo("attrezzo", 1);
		this.prendi = new ComandoPrendi();
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
	}

	@Test
	public void testNonEsisteAttrezzoConNome() {
		String attrezzoInesistente = "inesistente";
		this.prendi.setParametro(attrezzoInesistente);
		this.prendi.esegui(this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(attrezzoInesistente));
	}
	
	@Test
	public void testAttrezzoPosatoInBorsa() {
		this.prendi.setParametro(this.attrezzo.getNome());
		this.prendi.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzo.getNome()));
	}
	
	@Test
	public void testAttrezzoRimossoDallaStanza() {
		this.prendi.setParametro(this.attrezzo.getNome());
		this.prendi.esegui(partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(this.attrezzo.getNome()));
	}

}
