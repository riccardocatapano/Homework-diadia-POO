package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	private String attrezzoScatenante;
	
	public StanzaBuia(String nome, String attrezzoScatenante) {
		super(nome);
		this.attrezzoScatenante = attrezzoScatenante;
	}
	
	@Override
	public String getDescrizione() {
		String buia = "qui c'è un buio pesto";
		if(this.hasAttrezzo(attrezzoScatenante)) {
			return super.getDescrizione();
		}
		else return buia;	
	}

}
