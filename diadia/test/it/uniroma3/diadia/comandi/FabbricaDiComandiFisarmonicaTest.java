package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiFisarmonicaTest {
	
	FabbricaDiComandiFisarmonica fabbrica;

	@Before
	public void setUp() throws Exception {
		this.fabbrica = new FabbricaDiComandiFisarmonica();
		
	}

	@Test
	public void testesecuzioneComandoVai() {
		assertEquals("vai", this.fabbrica.costruisciComando("vai").getNome());
	}
	
	@Test
	public void testEsecuzioneComandoAiuto() {
		assertEquals("aiuto", this.fabbrica.costruisciComando("aiuto").getNome());
	}
	
	@Test
	public void testEsecuzioneComandoFine() {
		assertEquals("fine", this.fabbrica.costruisciComando("fine").getNome());
	}
	
	@Test
	public void testEsecuzioneComandoGuarda() {
		assertEquals("guarda", this.fabbrica.costruisciComando("guarda").getNome());
	}
	
	@Test
	public void testEsecuzioneComandoNonValido() {
		assertEquals("comando non valido", this.fabbrica.costruisciComando("comando non valido").getNome());
	}
	
	@Test
	public void testEsecuzioneComandoPosa() {
		assertEquals("posa", this.fabbrica.costruisciComando("posa").getNome());
	}
	
	@Test
	public void testesecuzioneComandoPrendi() {
		assertEquals("prendi", this.fabbrica.costruisciComando("prendi").getNome());
	}

}
