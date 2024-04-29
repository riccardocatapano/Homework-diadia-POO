package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{
	
	private String direzione;
	
	public ComandoVai() {
	}

	/**
	 * esecuzione del comando
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	@Override
	public void esegui(Partita partita) {
		if(direzione==null)
			System.out.println("Dove vuoi andare?, Devi specificare una direzione");
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			partita.setStanzaCorrente(prossimaStanza);
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}
	
	/**
	 * Set  parametro del comando
	 * @param parametro
	 */
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public String getNome() {
		return "vai";
	}

	@Override
	public String getParametro() {
		return direzione;
	}
}
