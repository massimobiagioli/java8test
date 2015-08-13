package it.massimobiagioli.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import it.massimobiagioli.dao.PersonaDao;
import it.massimobiagioli.decorator.PersonaDecorator;
import it.massimobiagioli.model.Persona;
import it.massimobiagioli.util.PersonaComparator;
import it.massimobiagioli.util.PersonaNormalizer;

public class Application {

	public static void main(String[] args) {
		
		System.out.println("*** STREAM *****************");		
		
		System.out.println("1) Without Stream");
		List<Persona> items1 = loadItems();
		testWithoutStream(items1);
		
		System.out.println("2) With Stream");
		List<Persona> items2 = loadItems();
		testWithStream(items2);		
		
		System.out.println("*** LAMBDA *****************");
		testLambda();	
		
		System.out.println("*** DEFAULT ****************");
		testDefault();
	}
	
	private static List<Persona> loadItems() {
		return new ArrayList<Persona>() {
			private static final long serialVersionUID = 1L;
			{
				add(new Persona("Mario", "Rossi", "via roma 1, Jesi(AN)"));
				add(new Persona("Anna", "Verdi", "via napoli 2, Apiro(MC)"));
				add(new Persona("Giulio", "Neri", "via torino 3, Chiaravalle(AN)"));
			}};
	}		
	
	private static void testWithoutStream(List<Persona> items) {
				
		CollectionUtils.filter(items, new Predicate() {
			
			@Override
			public boolean evaluate(Object o) {
				Persona persona = (Persona) o;
				
				return persona.getCognome().length() > 4;
			}
		});
		
		CollectionUtils.forAllDo(items, new Closure() {
			
			@Override
			public void execute(Object o) {
				Persona persona = (Persona) o;
				persona.setNome(persona.getNome().toUpperCase());
				persona.setCognome(persona.getCognome().toUpperCase());
				persona.setIndirizzo(persona.getIndirizzo().toLowerCase());	
			}
		});
		
		Collections.sort(items, new PersonaComparator());
		
		CollectionUtils.forAllDo(items, new Closure() {
			
			@Override
			public void execute(Object o) {
				System.out.println(o);
			}
		});
				
	}	
	
	private static void testWithStream(List<Persona> items) {
		items.stream()
			.filter(persona -> persona.getCognome().length() > 4)
			.map(persona -> PersonaNormalizer.normalize(persona))
			.sorted(new PersonaComparator())
			.forEach(System.out::println);
	}
	
	private static void testLambda() {
		Persona persona = new Persona("Gianni", "Bianchi", "via dei fiori 123, Montecarotto(AN)");
		PersonaDao dao = new PersonaDao();
		dao.store(persona, saved -> System.out.println("Stored: " + saved));		
	}
	
	public static void testDefault() {
		Persona persona = new Persona("Emma", "Grigi", "via delle rose 456, Cingoli(MC)");
		decoratePersona(persona, new PersonaDecorator() {
		});
	}
	
	public static void decoratePersona(Persona persona, PersonaDecorator decorator) {
		decorator.decorate(persona);
	}
	
}
