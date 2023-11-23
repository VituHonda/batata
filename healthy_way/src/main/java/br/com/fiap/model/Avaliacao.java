package br.com.fiap.model;

import java.util.List;

public class Avaliacao {
	
	private int idAvaliacao;
	private int nota;
	private String mensagem;
	private Tecnologia tecnologiaConsulta;
	private Usuario usuario;
	
	
	public Avaliacao() {}
	
	public Avaliacao(int nota, String mensagem) {
		super();
		this.nota = nota;
		this.mensagem =  mensagem;
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


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tecnologia getTecnologiaConsulta() {
		return tecnologiaConsulta;
	}

	public void setTecnologiaConsulta(Tecnologia tecnologiaConsulta) {
		this.tecnologiaConsulta = tecnologiaConsulta;
	}


	
}
