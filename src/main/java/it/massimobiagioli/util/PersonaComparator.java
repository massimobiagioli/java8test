package it.massimobiagioli.util;

import java.util.Comparator;

import it.massimobiagioli.model.Persona;

public class PersonaComparator implements Comparator<Persona> {

	@Override
	public int compare(Persona persona1, Persona persona2) {
		return persona1.getNome().compareTo(persona2.getNome());
	}
	
}