package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza {
	
	private String direzioneBloccata;
	private String attrezzoSbloccante;
	
	public StanzaBloccata(String nome,String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.hasAttrezzo(attrezzoSbloccante)) {
			return super.getStanzaAdiacente(direzione);
		}
		else if(this.direzioneBloccata != direzione) 
			return super.getStanzaAdiacente(direzione);
		else 
			return this;
	}
	
	@Override
	public String getDescrizione() {
		StringBuilder risultato = new StringBuilder();
    	risultato.append(this.getNome());
    	risultato.append("\nUscite: ");
    	for (String direzione : this.getDirezioni())
    		if (direzione!=null) {
    			if(direzione != this.direzioneBloccata) {
    				risultato.append(" "+direzione);
    			}
    			else {
    				risultato.append("direzione bloccata!");
    			}
    		}
    	risultato.append("\nAttrezzi nella stanza: ");
    	for(Attrezzo attrezzo: this.getAttrezzi()) {
    		if(attrezzo != null) {
    			risultato.append(attrezzo.toString()+" ");
    		}
    	}
    	return risultato.toString();
	}

}
