package br.com.fiap.model;

public class ClinicaTelefone {
	
	private int idClinicaTelefone;
	private String telefoneClinica;
	private int idClinica;
	
	public ClinicaTelefone() {}
	
	public ClinicaTelefone(String telefoneClinica) {
		super();
		this.telefoneClinica = telefoneClinica;
	}

	public int getIdClinicaTelefone() {
		return idClinicaTelefone;
	}

	public void setIdClinicaTelefone(int idClinicaTelefone) {
		this.idClinicaTelefone = idClinicaTelefone;
	}

	public String getTelefoneClinica() {
		return telefoneClinica;
	}

	public void setTelefoneClinica(String telefoneClinica) {
		this.telefoneClinica = telefoneClinica;
	}

	public int getIdClinica() {
		return idClinica;
	}

	public void setIdClinica(int idClinica) {
		this.idClinica = idClinica;
	}
	
}
