package br.com.fiap.model;

import java.util.List;

public class Avaliacao {
	
	private int idAvaliacao;
	private int nota;
	private String mensagem;
	private List<Tecnologia> tecnologiaConsulta;
	private int idUsuario;
	
	
	public Avaliacao() {}
	
	public Avaliacao(int nota, String mensagem) {
		super();
		this.nota = nota;
	}

	public int getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<Tecnologia> getTecnologiaConsulta() {
		return tecnologiaConsulta;
	}

	public void setTecnologiaConsulta(List<Tecnologia> tecnologiaConsulta) {
		this.tecnologiaConsulta = tecnologiaConsulta;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
