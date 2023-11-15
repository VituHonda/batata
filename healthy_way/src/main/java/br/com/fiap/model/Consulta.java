package br.com.fiap.model;

import java.util.Calendar;

public class Consulta {
	
	private int idConsulta;
	private Calendar dataConsulta;
	
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
	
}
