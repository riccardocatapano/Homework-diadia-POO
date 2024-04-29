package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {
	
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	static final private int SOGLIA_MAGICA_DEFAULT = 5;
	
	public StanzaMagicaProtected(String nome, int sogliaMagica) {
		super(nome);
		this.sogliaMagica = sogliaMagica;
		this.contatoreAttrezziPosati = 0;
	}
	
	//public StanzaMagica(int sogliaMagica) {
	//	this(nome, SOGLIA_MAGICA_DEFAULT);
	//}
	

	public int getContatoreAttrezziPosati() {
		return contatoreAttrezziPosati;
	}

	public void setContatoreAttrezziPosati(int contatoreAttrezziPosati) {
		this.contatoreAttrezziPosati = contatoreAttrezziPosati;
	}

	public int getSogliaMagica() {
		return sogliaMagica;
	}

	public void setSogliaMagica(int sogliaMagica) {
		this.sogliaMagica = sogliaMagica;
	}
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso()*2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
		return attrezzo;	
	}
	
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if(this.contatoreAttrezziPosati > this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		if(this.numeroAttrezzi < this.attrezzi.length) {
			this.attrezzi[this.numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		else 
			return false;
	}
	
	
}
