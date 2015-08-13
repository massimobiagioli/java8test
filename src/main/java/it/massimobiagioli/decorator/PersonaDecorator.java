package it.massimobiagioli.decorator;

import it.massimobiagioli.model.Persona;
import it.massimobiagioli.util.PersonaNormalizer;

public interface PersonaDecorator {
	
	default void decorate(Persona persona) {
		System.out.println("*** Default decorator for: " + PersonaNormalizer.normalize(persona) + " ***");
	}
	
}
