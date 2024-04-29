package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	
	private String parametroNullo;
	/**
     * esecuzione del comando
     */
	@Override
	public void esegui(Partita partita) {
		System.out.println("Comando non valido, inserire altro");
	}
	
	/**
	 * set parametro del comando
	 */
	@Override
	public void setParametro(String parametro) {
		this.parametroNullo = parametro;
	}
	
	@Override
	public String getNome() {
		return "comando non valido";
	}

	@Override
	public String getParametro() {
		return parametroNullo;
	}

}
