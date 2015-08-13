package it.massimobiagioli.functional;

import it.massimobiagioli.model.Persona;

@FunctionalInterface
public interface AfterStorePersona {
	
	public void execute(Persona persona);
	
}
