package it.uniroma3.diadia.ambienti;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private Stanza stanza;
	private Stanza stanzaAdiacente;
	private Attrezzo attrezzo;
	private Attrezzo nonAttrezzo;

	@Before
	public void setUp() throws Exception {
		this.stanza = new Stanza("stanza");
		this.stanzaAdiacente = new Stanza("stanzaAdiacente");
		this.attrezzo = new Attrezzo("attrezzo", 1);
		this.nonAttrezzo = new Attrezzo("nonAttrezzo", 1);

		stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
		stanza.addAttrezzo(attrezzo);
		
	}
	
	/**
	 * Test per il metodo impostaStanzaAdiacente
	 */

	@Test
	public void testImpostaStanzaAdiacenteNord() {
		assertEquals(stanzaAdiacente, stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testImpostaStanzaAdiacenteEst() {
		stanza.impostaStanzaAdiacente("est", stanzaAdiacente);
		assertEquals(stanzaAdiacente, stanza.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testImpostaStanzaAdiacenteOvest() {
		stanza.impostaStanzaAdiacente("ovest", stanzaAdiacente);
		assertEquals(stanzaAdiacente, stanza.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testImpostaStanzaAdiacenteSud() {
		stanza.impostaStanzaAdiacente("sud", stanzaAdiacente);
		assertEquals(stanzaAdiacente, stanza.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testImpostaStanzaAdiacenteNuova() {
		Stanza stanzaNuova = new Stanza("stanzaNuova");
		stanza.impostaStanzaAdiacente("nord", stanzaNuova);
		assertEquals(stanzaNuova, stanza.getStanzaAdiacente("nord"));
	}
	
	/**
	 * Test per il metodo addAttrezzo
	 */
	@Test
	public void testAggiungiUnAttrezzoNellaStanza() {
		assertTrue(stanza.hasAttrezzo("attrezzo"));
	}
	
	@Test
	public void testAttrezzoNonPresenteNellaSTanza() {
		assertFalse(stanza.hasAttrezzo("nonAttrezzo"));
	}
	@Test
	public void testStessoAttrezzoAggiuntoInDueStanzeDifferenti() {
		stanzaAdiacente.addAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo("attrezzo"));
		assertTrue(stanzaAdiacente.hasAttrezzo("attrezzo"));
	}
	@Test
	public void testDueAttrezziAggiuntiInDueStanzeDifferenti() {
		stanzaAdiacente.addAttrezzo(nonAttrezzo);
		assertTrue(stanza.hasAttrezzo("attrezzo"));
		assertTrue(stanzaAdiacente.hasAttrezzo("nonAttrezzo"));
	}
	@Test
	public void testAggiungiUndicesimoAttrezzo() {
		Attrezzo attrezzo1 = new Attrezzo("attrezzo1", 1);
		Attrezzo attrezzo2 = new Attrezzo("attrezzo2", 1);
		Attrezzo attrezzo3 = new Attrezzo("attrezzo3", 1);
		Attrezzo attrezzo4 = new Attrezzo("attrezzo4", 1);
		Attrezzo attrezzo5 = new Attrezzo("attrezzo5", 1);
		Attrezzo attrezzo6 = new Attrezzo("attrezzo6", 1);
		Attrezzo attrezzo7 = new Attrezzo("attrezzo7", 1);
		Attrezzo attrezzo8 = new Attrezzo("attrezzo8", 1);
		Attrezzo attrezzo9 = new Attrezzo("attrezzo9", 1);
		Attrezzo attrezzo10 = new Attrezzo("attrezzo10", 1);
		stanza.addAttrezzo(attrezzo1);
		stanza.addAttrezzo(attrezzo2);
		stanza.addAttrezzo(attrezzo3);
		stanza.addAttrezzo(attrezzo4);
		stanza.addAttrezzo(attrezzo5);
		stanza.addAttrezzo(attrezzo6);
		stanza.addAttrezzo(attrezzo7);
		stanza.addAttrezzo(attrezzo8);
		stanza.addAttrezzo(attrezzo9);
		stanza.addAttrezzo(attrezzo10);
		assertTrue(stanza.hasAttrezzo("attrezzo"));
		assertTrue(stanza.hasAttrezzo("attrezzo1"));
		assertTrue(stanza.hasAttrezzo("attrezzo2"));
		assertTrue(stanza.hasAttrezzo("attrezzo3"));
		assertTrue(stanza.hasAttrezzo("attrezzo4"));
		assertTrue(stanza.hasAttrezzo("attrezzo5"));
		assertTrue(stanza.hasAttrezzo("attrezzo6"));
		assertTrue(stanza.hasAttrezzo("attrezzo7"));
		assertTrue(stanza.hasAttrezzo("attrezzo8"));
		assertTrue(stanza.hasAttrezzo("attrezzo9"));
		assertFalse(stanza.hasAttrezzo("attrezzo10"));
	}
	
	/**
	 * Test per il metodo getAttrezzo
	 */
	@Test
	public void testVerificaCheNellaStanzaCiSiaAttrezzo() {
		assertEquals(attrezzo, stanza.getAttrezzo("attrezzo"));
	}
	@Test 
	public void testAttrezzoNonPresenteNellaStanza() {
		assertEquals(null, stanza.getAttrezzo("nonAttrezzo"));
	}
	@Test
	public void testRitornaIlSecondoAttrezzoNellaStanza() {
		stanza.addAttrezzo(nonAttrezzo);
		assertEquals(nonAttrezzo, stanza.getAttrezzo("nonAttrezzo"));
	}
	/**
	 * Test per il metodo removeAttrezzo
	 */
	@Test
	public void testControllaSeAttrezzoEStatoRimosso() {
		stanza.removeAttrezzo(attrezzo);
		assertFalse(stanza.hasAttrezzo("attrezzo"));
		assertEquals(null, stanza.getAttrezzo("atterezzo"));
	}
	@Test
	public void testRimuoviSeconoAttrezzoPresenteNellaStanza() {
		stanza.addAttrezzo(nonAttrezzo);
		stanza.removeAttrezzo(nonAttrezzo);
		assertFalse(stanza.hasAttrezzo("nonAttrezzo"));
		assertEquals(attrezzo, stanza.getAttrezzo("attrezzo"));
		assertEquals(null, stanza.getAttrezzo("nonAttrezzo"));
	}
	@Test
	public void testRimuoviTuttiGliAttrezziNellaStanza() {
		stanza.addAttrezzo(nonAttrezzo);
		stanza.removeAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo("nonAttrezzo"));
		stanza.removeAttrezzo(nonAttrezzo);
		assertFalse(stanza.hasAttrezzo("nonAttrezzo"));
		assertFalse(stanza.hasAttrezzo("attrezzo"));
		assertEquals(null, stanza.getAttrezzo("attrezzo"));
		assertEquals(null, stanza.getAttrezzo("nonAttrezzo"));
		
	}
	

}
