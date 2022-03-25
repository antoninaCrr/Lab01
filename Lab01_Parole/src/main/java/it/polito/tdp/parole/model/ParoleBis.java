package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class ParoleBis {

	
	private List<String> paroleInserite = new ArrayList<String>();
		
	public void addParolaBis(String p) {
		//TODO
		this.paroleInserite.add(p);
	}
	
	public List<String> getElencoBis() {
		//TODO
		ArrayList<String> paroleOrdinate = new ArrayList<String>(this.paroleInserite);
		Collections.sort(paroleOrdinate, new ComparatoreOrdineAlfabetico());
		return paroleOrdinate;
	}
	
	public void resetBis() {
		// TODO
		this.paroleInserite.removeAll(paroleInserite);
	}
	
	public void deleteBis (String word) {
		for(String s : this.paroleInserite) {
			if(s.equals(word))
				this.paroleInserite.remove(s);
		}
	}

	
	public String toStringBis() {
		String s = "";
		for(String si: this.getElencoBis()) {
			s += si+ " ";
		}	
		return s;
	}
	
	

}
