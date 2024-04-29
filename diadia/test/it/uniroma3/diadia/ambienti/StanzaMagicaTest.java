package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	
	private StanzaMagica stanzaMagica;
	private Attrezzo attrezzo;

	@Before
	public void setUp() throws Exception {
		this.stanzaMagica = new StanzaMagica("stanza",2);
		this.attrezzo = new Attrezzo("attrezzo",1);
	}

	@Test
	public void testAumentoContatoreAttrezziPosati() {
		stanzaMagica.addAttrezzo(attrezzo);
		assertEquals(1,this.stanzaMagica.getContatoreAttrezziPosati());
		stanzaMagica.removeAttrezzo(attrezzo);
		stanzaMagica.addAttrezzo(attrezzo);
		assertEquals(2,this.stanzaMagica.getContatoreAttrezziPosati());
	}
	@Test
	public void testVerificaFunzionamentoComportamentoMagicoNome() {
		this.stanzaMagica.setContatoreAttrezziPosati(3);
		stanzaMagica.addAttrezzo(attrezzo);
		assertTrue(this.stanzaMagica.hasAttrezzo("ozzertta"));
	}
	@Test
	public void testFunzionamentoMagicoConSogliaMinore() {
		stanzaMagica.addAttrezzo(attrezzo);
		assertFalse(this.stanzaMagica.hasAttrezzo("ozzertta"));
		assertTrue(this.stanzaMagica.hasAttrezzo("attrezzo"));
	}
	@Test
	public void testVerificaCorrettoFunzionamentoMagicoPeso() {
		this.stanzaMagica.setContatoreAttrezziPosati(3);
		stanzaMagica.addAttrezzo(attrezzo);
		assertEquals(2,this.stanzaMagica.getAttrezzo("ozzertta").getPeso());
	}

}
