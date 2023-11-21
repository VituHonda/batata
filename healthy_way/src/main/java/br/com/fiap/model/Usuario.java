package br.com.fiap.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private int idUsuario;
	private String nomeUsuario;
	private String emailUsuario;
	private String senhaUsuario;
	private List<UsuarioEndereco> usuarioEnderecos;
	private List<UsuarioTelefone> usuarioTelefones;
	private List<Avaliacao> usuarioAvaliacoes;
	private List<DadosBiometricosUsuario> usuarioDadosBiometricos;
	private List<Consulta> usuarioConsultas;
	
	
	public Usuario() {}
	
	public Usuario(String nomeUsuario, String emailUsuario, String senhaUsuario) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public List<UsuarioTelefone> getUsuarioTelefones() {
		return usuarioTelefones;
	}

	public void setUsuarioTelefones(List<UsuarioTelefone> usuarioTelefones) {
		this.usuarioTelefones = usuarioTelefones;
	}

	public List<UsuarioEndereco> getUsuarioEnderecos() {
		return usuarioEnderecos;
	}

	public void setUsuarioEnderecos(List<UsuarioEndereco> usuarioEnderecos) {
		this.usuarioEnderecos = usuarioEnderecos;
	}

	public List<Avaliacao> getUsuarioAvaliacoes() {
		return usuarioAvaliacoes;
	}

	public void setUsuarioAvaliacoes(List<Avaliacao> usuarioAvaliacoes) {
		this.usuarioAvaliacoes = usuarioAvaliacoes;
	}

	public List<DadosBiometricosUsuario> getUsuarioDadosBiometricos() {
		return usuarioDadosBiometricos;
	}

	public void setUsuarioDadosBiometricos(List<DadosBiometricosUsuario> usuarioDadosBiometricos) {
		this.usuarioDadosBiometricos = usuarioDadosBiometricos;
	}

	public List<Consulta> getUsuarioConsultas() {
		return usuarioConsultas;
	}

	public void setUsuarioConsultas(List<Consulta> usuarioConsultas) {
		this.usuarioConsultas = usuarioConsultas;
	}
	
}

