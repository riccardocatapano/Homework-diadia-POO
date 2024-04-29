package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	private String nomeAttrezzo;
	
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null) {
			System.out.println("Devi scrivere un nome di un attrezzo!!");
		}
		else if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoDaPosare = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
			System.out.println("Attrezzo rimosso dalla borsa e posato nella stanza!");
			System.out.println(partita.getGiocatore().getBorsa().toString());
			System.out.println(partita.getStanzaCorrente().toString());
		}
		else {
			System.out.println(nomeAttrezzo + " non presente nella borsa");
			System.out.println(partita.getGiocatore().getBorsa().toString());
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return nomeAttrezzo;
	}
}
