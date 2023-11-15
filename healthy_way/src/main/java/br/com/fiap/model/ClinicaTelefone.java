package br.com.fiap.model;

public class ClinicaTelefone {
	
	private int idClinicaTelefone;
	private String telefoneClinica;
	
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
	
}
