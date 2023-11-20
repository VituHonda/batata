package br.com.fiap.model;

import java.util.Calendar;

public class Consulta {
	
	private int idConsulta;
	private Calendar dataConsulta;
	private int idUsuario;
	private int idMedico;
	private int idTecnologia;
	
	public Consulta() {}
	
	public Consulta(Calendar dataConsulta) {
		super();
		this.dataConsulta = dataConsulta;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Calendar getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Calendar dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public int getIdTecnologia() {
		return idTecnologia;
	}

	public void setIdTecnologia(int idTecnologia) {
		this.idTecnologia = idTecnologia;
	}
	
}
