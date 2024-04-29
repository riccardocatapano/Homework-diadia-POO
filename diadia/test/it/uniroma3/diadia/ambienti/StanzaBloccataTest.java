package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	private StanzaBloccata bloccata;
	private Stanza stanza;
	private Attrezzo attrezzo;

	@Before
	public void setUp() throws Exception {
		this.bloccata = new StanzaBloccata("bloccata","su","attrezzo");
		this.attrezzo = new Attrezzo("attrezzo",1);
		this.stanza = new Stanza("stanza");
		this.stanza.impostaStanzaAdiacente("su", bloccata);
		this.bloccata.impostaStanzaAdiacente("giu", stanza);
	}

	@Test
	public void testAttrezzoPresenteNellaStanza() {
		
		
	}

}
