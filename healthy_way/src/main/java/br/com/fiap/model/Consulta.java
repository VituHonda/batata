package br.com.fiap.model;

import java.util.Calendar;
import java.util.List;

public class Consulta {
	
	private int idConsulta;
	private int situacao;
	private Usuario usuario;
	private Medico medico;
	private Tecnologia tecnologiaConsulta;
		
	public Consulta() {}
	
	public Consulta(Usuario usuario, Medico medico, Tecnologia tecnologia) {
		super();
		this.usuario = usuario;
		this.medico = medico;
		this.tecnologiaConsulta = tecnologia;
		this.situacao = 0;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
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

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}




	
}
