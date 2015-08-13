package it.massimobiagioli.util;

import it.massimobiagioli.model.Persona;

public class PersonaNormalizer {
	
	public static Persona normalize(Persona persona) {
		persona.setNome(persona.getNome().toUpperCase());
		persona.setCognome(persona.getCognome().toUpperCase());
		persona.setIndirizzo(persona.getIndirizzo().toLowerCase());
		
		return persona;
	}
	
}
