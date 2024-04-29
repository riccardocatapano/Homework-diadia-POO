package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null) {
			System.out.println("Devi scrivere un nome di un attrezzo!!");
		}
		else if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
			System.out.println("Attrezzo rimosso dalla stanza e aggiunto alla borsa!");
			System.out.println(partita.getStanzaCorrente().toString());
			System.out.println(partita.getGiocatore().getBorsa().toString());
		}
		else {
			System.out.println(nomeAttrezzo + " non presente nella stanza");
			System.out.println(partita.getStanzaCorrente().toString());
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return nomeAttrezzo;
	}

}
