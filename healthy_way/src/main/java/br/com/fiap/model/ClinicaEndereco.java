package br.com.fiap.model;

public class ClinicaEndereco {
	
	private int idClinicaEndereco;
	private String ruaClinica;
	private String numeroClinica;
	private String estadoClinica;
	private String cepClinica;
	
	public ClinicaEndereco() {}
	
	public ClinicaEndereco(String ruaClinica, String numeroClinica, String estadoClinica, String cepClinica) {
		super();
		this.ruaClinica = ruaClinica;
		this.numeroClinica = numeroClinica;
		this.estadoClinica = estadoClinica;
		this.cepClinica = cepClinica;
	}

	public int getIdClinicaEndereco() {
		return idClinicaEndereco;
	}

	public void setIdClinicaEndereco(int idClinicaEndereco) {
		this.idClinicaEndereco = idClinicaEndereco;
	}

	public String getRuaClinica() {
		return ruaClinica;
	}

	public void setRuaClinica(String ruaClinica) {
		this.ruaClinica = ruaClinica;
	}

	public String getNumeroClinica() {
		return numeroClinica;
	}

	public void setNumeroClinica(String numeroClinica) {
		this.numeroClinica = numeroClinica;
	}

	public String getEstadoClinica() {
		return estadoClinica;
	}

	public void setEstadoClinica(String estadoClinica) {
		this.estadoClinica = estadoClinica;
	}

	public String getCepClinica() {
		return cepClinica;
	}

	public void setCepClinica(String cepClinica) {
		this.cepClinica = cepClinica;
	}
	
}
