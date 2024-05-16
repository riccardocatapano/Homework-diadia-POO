package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class Borsa {
			
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> nomeAttrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int pesoAttuale;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		//this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.nomeAttrezzi = new TreeMap<>();
		this.numeroAttrezzi = 0;
		this.pesoAttuale = 0;
	}
		

		/**
		 * Aggiunge, se possibile, un oggetto nella borsa
		 * @param attrezzo
		 * @return true se l'oggetto viene aggiunto correttamente
		 */
		public boolean addAttrezzo(Attrezzo attrezzo) {
			if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
				return false;
			this.nomeAttrezzi.put(attrezzo.getNome(),attrezzo);
			this.numeroAttrezzi++;
			this.pesoAttuale += attrezzo.getPeso();
			return true;
		}
		
		public int getPesoMax() {
			return pesoMax;
		}


		/**
		 * Cerca un attrezzo nella borsa
		 * @param nomeAttrezzo
		 * @return l'attrezzo cercato
		 */
		public Attrezzo getAttrezzo(String nomeAttrezzo) {
			Attrezzo a = null;
			if(nomeAttrezzo != null && this.nomeAttrezzi.containsKey(nomeAttrezzo))
				a = this.nomeAttrezzi.get(nomeAttrezzo);
			return a;
		}
		
		public int getPeso() {
			return this.pesoAttuale;
		}
		
		public boolean getPesoRimanente(Attrezzo a) {
			if(a != null && this.getPesoMax()-this.getPeso()>=a.getPeso())
				return true;
			return false; 
		}
		
		public boolean isEmpty() {
			return this.numeroAttrezzi == 0;
		}

		/**
		 * Verifica se l'attrezzo è presente nella borsa
		 * @param nomeAttrezzo
		 * @return true se l'attrezzo è nella borsa
		 */
		public boolean hasAttrezzo(String nomeAttrezzo) {
			return this.getAttrezzo(nomeAttrezzo)!=null;
		}
		
		
		/**
		 * Rimuove un attrezzo dalla borsa
		 * @param nomeAttrezzo
		 * @return l'attrezzo rimosso
		 */
		public Attrezzo removeAttrezzo(String nomeAttrezzo) {
			Attrezzo a = null;
			if(nomeAttrezzo!=null){
				a = nomeAttrezzi.remove(nomeAttrezzo);
			}
			return a;
		}
		
		public String toString() {
			StringBuilder s = new StringBuilder();
			if (!this.isEmpty()) {
				s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
				s.append("\n");
				s.append(this.getContenutoOrdinatoPerNome().toString());
				s.append("\n");
				s.append(this.getContenutoRaggruppatoPerPeso().toString());
				s.append("\n");
				s.append(this.getSortedSetOrdinatoPerPeso().toString());
			}
			else
				s.append("Borsa vuota");
			return s.toString();
		}
		
		SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
			SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
			s.addAll(this.nomeAttrezzi.values());
			return s;
		}
		
		List<Attrezzo> getContenutoOrdinatoPerPeso(){
			List<Attrezzo> l = new ArrayList<>();
			l.addAll(this.nomeAttrezzi.values());
			Collections.sort(l, new ComparatoreAttrezziPerPeso());
			return l;
		}

		SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
			return new TreeSet<Attrezzo>(this.nomeAttrezzi.values());
		}

		Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
			Map<Integer, Set<Attrezzo>> a2p = new TreeMap<>();
			for(Attrezzo a : this.nomeAttrezzi.values()){
				if(a2p.containsKey(a.getPeso())) {
					a2p.get(a.getPeso()).add(a);
				}
				else {
					Set<Attrezzo>  s =new HashSet<Attrezzo>();
					s.add(a);
					a2p.put(a.getPeso(), s);
				}
			}
			return a2p;
		}

}
