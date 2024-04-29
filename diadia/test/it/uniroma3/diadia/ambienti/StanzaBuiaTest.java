package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private StanzaBuia buia;
	private Attrezzo attrezzo;

	@Before
	public void setUp() throws Exception {
		this.buia = new StanzaBuia("buia", "attrezzo");
		this.attrezzo = new Attrezzo("attrezzo",1);
	}

	@Test
	public void testAttrezzoPresenteNellaStanza() {
		this.buia.addAttrezzo(attrezzo);
		assertEquals(this.buia.toString(),this.buia.getDescrizione());
	}
	
	@Test
	public void testAttrezzoNonPresenteNellaStanza() {
		assertEquals("qui c'è un buio pesto", this.buia.getDescrizione());
	}

}
