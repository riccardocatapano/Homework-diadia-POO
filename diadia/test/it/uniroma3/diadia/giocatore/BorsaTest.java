package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	
	private Borsa borsa;
	private Attrezzo attrezzo;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzoPesante;
	private int pesoMax;

	@Before
	public void setUp() throws Exception {
		this.borsa = new Borsa();
		this.pesoMax = this.borsa.getPesoMax();
		this.attrezzo = new Attrezzo("attrezzo",1);
		this.attrezzoPesante = new Attrezzo("attrezzoPesante", 11);
		this.attrezzo2 = new Attrezzo("attrezzo2",2);
		
		this.borsa.addAttrezzo(attrezzo);
	}
	
	/**
	 * Test per il metood addAttrezzo
	 */
	@Test
	public void testAggiungiAttrezzoAllaBorsa() {
		assertTrue(this.borsa.hasAttrezzo("attrezzo"));
	}
	@Test
	public void testAggiungiDueAttrezziAllaBorsa() {
		this.borsa.addAttrezzo(attrezzo2);
		assertTrue(this.borsa.hasAttrezzo("attrezzo"));
		assertTrue(this.borsa.hasAttrezzo("attrezzo2"));
	}
	@Test
	public void testAggiungiAttrezzoPesanteAllaBorsa() {
		this.borsa.addAttrezzo(attrezzoPesante);
		assertFalse(this.borsa.hasAttrezzo("attrezzoPesante"));
	}
	@Test
	public void testAggiungiAttrezzoQuantoPesoEMassimo() {
		Attrezzo nuovoAttrezzo = new Attrezzo("nuovoAttrezzo",7);
		Attrezzo attrezzoNonEntra = new Attrezzo("attrezzoNonEntra",3);
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(nuovoAttrezzo);
		assertTrue(this.borsa.hasAttrezzo("nuovoAttrezzo"));
		this.borsa.addAttrezzo(attrezzoNonEntra);
		assertFalse(this.borsa.hasAttrezzo("attrezzoNonEntra"));
	}
	/**
	 * Test per il metodo getAttrezzo
	 */
	@Test
	public void testCercaAttrezzoNellaBorsa() {
		assertEquals(attrezzo,this.borsa.getAttrezzo("attrezzo"));
	}
	@Test
	public void testCercaSecondoAttrezzoNellaBorsa() {
		this.borsa.addAttrezzo(attrezzo2);
		assertEquals(attrezzo2, this.borsa.getAttrezzo("attrezzo2"));
	}
	@Test
	public void testCercaAttrezzoNonPresenteNellaBorsa() {
		assertEquals(null, this.borsa.getAttrezzo("attrezzo2"));
	}
	/**
	 * Test per il metodo removeAttrezzo
	 */
	@Test
	public void testAttrezzoRimossoDallaBorsa() {
		this.borsa.removeAttrezzo("attrezzo");
		assertFalse(this.borsa.hasAttrezzo("attrezzo"));
	}
	@Test
	public void testRimuoviPrimoAttrezzoDallaBorsa() {
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.removeAttrezzo("attrezzo");
		assertFalse(this.borsa.hasAttrezzo("attrezzo"));
	}
	@Test
	public void testBorsaRimastaVuota() {
		this.borsa.removeAttrezzo("attrezzo");
		assertTrue(this.borsa.isEmpty());
	}
	@Test
	public void testAttrezzoAggiuntoConBorsaPienaDopoAverRimossoAttrezzo() {
		Attrezzo nuovoAttrezzo = new Attrezzo("nuovoAttrezzo",7);
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(nuovoAttrezzo);
		//borsa piena(peso=10)
		Attrezzo attrezzo3 = new Attrezzo("attrezzo3",4);
		this.borsa.addAttrezzo(attrezzo3);
		assertEquals(null, this.borsa.getAttrezzo("attrezzo3"));
		//attrezzo non aggiunto Peso=10)
		this.borsa.removeAttrezzo("attrezzo2");
		assertEquals(null, this.borsa.getAttrezzo("attrezzo2"));
		//attrezzo rimosso Peso=8
		this.borsa.addAttrezzo(attrezzo2);
		assertEquals(attrezzo2, this.borsa.getAttrezzo("attrezzo2"));
		assertEquals(null, this.borsa.getAttrezzo("attrezzo3"));
		
	}
}
