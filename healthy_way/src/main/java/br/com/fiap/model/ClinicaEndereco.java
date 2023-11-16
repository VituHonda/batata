package br.com.fiap.model;

public class ClinicaEndereco {
	
	private int idClinicaEndereco;
	private String ruaClinica;
	private int numeroClinica;
	private String estadoClinica;
	private String cidadeClinica;
	private String cepClinica;
	private int idClinica;
	
	public ClinicaEndereco() {}
	
	public ClinicaEndereco(String ruaClinica, int numeroClinica, String estadoClinica, String cidadeClinica, String cepClinica) {
		super();
		this.ruaClinica = ruaClinica;
		this.numeroClinica = numeroClinica;
		this.estadoClinica = estadoClinica;
		this.cidadeClinica = cidadeClinica;
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

	public int getNumeroClinica() {
		return numeroClinica;
	}

	public void setNumeroClinica(int numeroClinica) {
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

	public String getCidadeClinica() {
		return cidadeClinica;
	}

	public void setCidadeClinica(String cidadeClinica) {
		this.cidadeClinica = cidadeClinica;
	}

	public int getIdClinica() {
		return idClinica;
	}

	public void setIdClinica(int idClinica) {
		this.idClinica = idClinica;
	}
	
}
