package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	StanzaBloccata bloccataASud;
	Attrezzo sblocco;
	Stanza sud;
	
	@Before
	public void setUp() {
		
		this.bloccataASud = new StanzaBloccata("bloccata", "sud", "sblocco");
		this.sblocco = new Attrezzo("sblocco", 2);
		this.sud = new Stanza("sud");
		this.bloccataASud.impostaStanzaAdiacente("sud", sud);
		
	}
	
	@Test
	public void testGetStanzaAdiacente_direzioneBloccata() {
		assertEquals(this.bloccataASud, this.bloccataASud.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacente_direzioneSbloccata() {
		this.bloccataASud.addAttrezzo(this.sblocco);
		assertEquals(this.sud, this.bloccataASud.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacente_direzioneNonBloccata() {
		Stanza nord = new Stanza("nord");
		this.bloccataASud.impostaStanzaAdiacente("nord", nord);
		assertEquals(nord, this.bloccataASud.getStanzaAdiacente("nord"));
	}
	
	
	
	
	
	
	
	
	
	
	
}