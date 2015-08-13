package it.massimobiagioli.model;

public class Persona {
	
	private String nome;
	private String cognome;
	private String indirizzo;
	
	public Persona(String nome, String cognome, String indirizzo) {
		this.setNome(nome);
		this.setCognome(cognome);
		this.setIndirizzo(indirizzo);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getNome())
			.append(" ")
			.append(this.getCognome())
			.append(" ")
			.append(this.getIndirizzo());
		
		return sb.toString();
	}
	
}
