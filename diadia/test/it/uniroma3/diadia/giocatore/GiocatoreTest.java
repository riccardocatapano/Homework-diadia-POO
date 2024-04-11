package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	private int cfu;
	private Giocatore giocatore;

	@Before
	public void setUp() throws Exception {
		this.giocatore = new Giocatore();
		this.cfu = this.giocatore.getCfu();
	}
	
	/**
	 * test per il metodo getCFU
	 */
	@Test
	public void testControllaQuantiCFUIniziali() {
		assertEquals(20, this.giocatore.getCfu());
	}
	@Test
	public void testCFUDiminuiti() {
		this.giocatore.setCfu(10);
		assertEquals(10, this.giocatore.getCfu());
	}
	@Test
	public void testPartitaFinitaQuandoCFUSonoZero() {
		this.giocatore.setCfu(0);
		assertEquals(0, this.giocatore.getCfu());
	}
	@Test
	public void testCFUNonNulli() {
		assertNotNull(this.giocatore.getCfu());
	}

}
