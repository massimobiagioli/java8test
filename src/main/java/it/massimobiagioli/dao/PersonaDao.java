package it.massimobiagioli.dao;

import it.massimobiagioli.functional.AfterStorePersona;
import it.massimobiagioli.model.Persona;
import it.massimobiagioli.util.PersonaNormalizer;

public class PersonaDao {
	
	public void store(Persona persona, AfterStorePersona f) {
		System.out.println("To store: " + persona);		
		f.execute(PersonaNormalizer.normalize(persona));		
	}
	
}
