package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole io;

	public DiaDia(IOConsole io) {
		this.partita = new Partita();
		this.io = io;
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(this.io.leggiRiga());		
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if(comandoDaEseguire.getNome() == null) {
			this.io.mostraMessaggio("Nessun comando inserito!");
			this.aiuto();
		} 
		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			this.io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	
	/**
	 * Comando prendi
	 * Gli attrezzi vengono rimossi dalla stanza e aggiunti alla borsa
	 */
	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo == null) {
			this.io.mostraMessaggio("Devi scrivere un nome di un attrezzo!!");
		}
		else if(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoDaPrendere = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			this.partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
			this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
			this.io.mostraMessaggio("Attrezzo rimosso dalla stanza e aggiunto alla borsa!");
			this.io.mostraMessaggio(this.partita.getStanzaCorrente().toString());
			this.io.mostraMessaggio("\n");
			this.io.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
		}
		else {
			this.io.mostraMessaggio(nomeAttrezzo + " non presente nella stanza");
			this.io.mostraMessaggio("\n");
			this.io.mostraMessaggio(this.partita.getStanzaCorrente().toString());
		}
	}
	
	/**
	 * Comando posa
	 * Gli attrezzi posati vengono rimossi dalla borsa e aggiunti nella stanza
	 */
	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo == null) {
			this.io.mostraMessaggio("Devi scrivere un nome di un attrezzo!!");
		}
		else if(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoDaPosare = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			this.partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
			this.io.mostraMessaggio("Attrezzo rimosso dalla borsa e posato nella stanza!");
			this.io.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
			this.io.mostraMessaggio("\n");
			this.io.mostraMessaggio(this.partita.getStanzaCorrente().toString());
		}
		else {
			this.io.mostraMessaggio(nomeAttrezzo + " non presente nella borsa");
			this.io.mostraMessaggio("\n");
			this.io.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
		}
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}