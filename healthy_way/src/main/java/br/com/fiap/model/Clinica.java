package br.com.fiap.model;

import java.util.List;

public class Clinica {
	
	private int idClinica;
	private String nomeClinica;
	private List<ClinicaEndereco> clinicaEnderecos;
	private List<ClinicaTelefone> clinicaTelefones;
	
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

	public List<ClinicaEndereco> getClinicaEnderecos() {
		return clinicaEnderecos;
	}

	public void setClinicaEnderecos(List<ClinicaEndereco> clinicaEnderecos) {
		this.clinicaEnderecos = clinicaEnderecos;
	}

	public List<ClinicaTelefone> getClinicaTelefones() {
		return clinicaTelefones;
	}

	public void setClinicaTelefones(List<ClinicaTelefone> clinicaTelefones) {
		this.clinicaTelefones = clinicaTelefones;
	}
	
}
