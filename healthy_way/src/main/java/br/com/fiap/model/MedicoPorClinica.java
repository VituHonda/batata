package br.com.fiap.model;

import java.util.Calendar;

public class MedicoPorClinica {
	
	private Calendar inicioContrato;
	private Calendar fimContrato;
	private int idMedico;
	private int idClinica;
	
	public MedicoPorClinica() {}
	
	public MedicoPorClinica(Calendar inicioContrato) {
		super();
		this.inicioContrato = inicioContrato;
	}

	public Calendar getInicioContrato() {
		return inicioContrato;
	}

	public void setInicioContrato(Calendar inicioContrato) {
		this.inicioContrato = inicioContrato;
	}

	public Calendar getFimContrato() {
		return fimContrato;
	}

	public void setFimContrato(Calendar fimContrato) {
		this.fimContrato = fimContrato;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public int getIdClinica() {
		return idClinica;
	}

	public void setIdClinica(int idClinica) {
		this.idClinica = idClinica;
	}
	
}
