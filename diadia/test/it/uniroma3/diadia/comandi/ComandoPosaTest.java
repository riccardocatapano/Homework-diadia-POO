package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {
	
	private Labirinto labirinto;
	private ComandoPosa posa;
	private Partita partita;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() throws Exception {
		this.labirinto = new Labirinto();
		this.partita = new Partita(labirinto);
		this.attrezzo = new Attrezzo("attrezzo", 1);
		this.posa = new ComandoPosa();
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
	}

	@Test
	public void testNonEsisteAttrezzoConNome() {
		String attrezzoInesistente = "inesistente";
		this.posa.setParametro(attrezzoInesistente);
		this.posa.esegui(this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(attrezzoInesistente));
	}
	
	@Test
	public void testAttrezzoRimossoDaBorsa() {
		this.posa.setParametro(this.attrezzo.getNome());
		this.posa.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzo.getNome()));
	}
	
	@Test
	public void testAttrezzoPosatoInStanza() {
		this.posa.setParametro(this.attrezzo.getNome());
		this.posa.esegui(partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(this.attrezzo.getNome()));
	}

}
