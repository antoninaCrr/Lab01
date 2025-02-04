package it.polito.tdp.parole.model;

import java.util.List;
import java.util.*;

public class Parole {
	
	private LinkedList<String> paroleInserite = new LinkedList<String>();
		
	public void addParola(String p) {
		//TODO
		this.paroleInserite.add(p);
	}
	
	public List<String> getElenco() {
		//TODO
		LinkedList<String> paroleOrdinate = new LinkedList<String>(this.paroleInserite);
		Collections.sort(paroleOrdinate, new ComparatoreOrdineAlfabetico());
		return paroleOrdinate;
	}
	
	public void reset() {
		// TODO
		this.paroleInserite.removeAll(paroleInserite);
	}
	
	public void delete (String word) {
		for(String s : this.paroleInserite) {
			if(s.equals(word))
				this.paroleInserite.remove(s);
		}
	}

	@Override
	public String toString() {
		String s = "";
		for(String si: this.getElenco()) {
			s += si+ " ";
		}	
		return s;
	}
	
	

}
