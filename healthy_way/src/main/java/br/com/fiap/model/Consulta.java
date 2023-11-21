package br.com.fiap.model;

import java.util.Calendar;
import java.util.List;

public class Consulta {
	
	private int idConsulta;
	private Calendar dataConsulta;
	private Usuario usuario;
	private Medico medico;
	private Tecnologia tecnologiaConsulta;
	
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

	public Tecnologia getTecnologiaConsulta() {
		return tecnologiaConsulta;
	}

	public void setTecnologiaConsulta(Tecnologia tecnologiaConsulta) {
		this.tecnologiaConsulta = tecnologiaConsulta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}




	
}
