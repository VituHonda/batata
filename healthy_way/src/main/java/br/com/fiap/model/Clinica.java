package br.com.fiap.model;

public class Clinica {
	
	private int idClinica;
	private String nomeClinica;
	
	public Clinica() {}
	
	public Clinica(String nomeClinica) {
		super();
		this.nomeClinica = nomeClinica;
	}

	public int getIdClinica() {
		return idClinica;
	}

	public void setIdClinica(int idClinica) {
		this.idClinica = idClinica;
	}

	public String getNomeClinica() {
		return nomeClinica;
	}

	public void setNomeClinica(String nomeClinica) {
		this.nomeClinica = nomeClinica;
	}
	
}
