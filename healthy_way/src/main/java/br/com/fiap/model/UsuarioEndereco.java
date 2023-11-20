package br.com.fiap.model;

public class UsuarioEndereco {
	
	private int idUsuarioEndereco;
	private String ruaUsuario;
	private String estadoUsuario;
	private int numeroUsuario;
	private String cepUsuario;
	private String cidadeUsuario;
	private int idUsuario;
	
	public UsuarioEndereco() {}
	
	public UsuarioEndereco(String ruaUsuario, String estadoUsuario, int numeroUsuario, String cepUsuario, String cidadeUsuario) {
		super();
		this.ruaUsuario = ruaUsuario;
		this.estadoUsuario = estadoUsuario;
		this.numeroUsuario = numeroUsuario;
		this.cepUsuario = cepUsuario;
		this.cidadeUsuario = cidadeUsuario;
	}

	public int getIdUsuarioEndereco() {
		return idUsuarioEndereco;
	}

	public void setIdUsuarioEndereco(int idUsuarioEndereco) {
		this.idUsuarioEndereco = idUsuarioEndereco;
	}

	public String getRuaUsuario() {
		return ruaUsuario;
	}

	public void setRuaUsuario(String ruaUsuario) {
		this.ruaUsuario = ruaUsuario;
	}

	public String getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public int getNumeroUsuario() {
		return numeroUsuario;
	}

	public void setNumeroUsuario(int numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}

	public String getCepUsuario() {
		return cepUsuario;
	}

	public void setCepUsuario(String cepUsuario) {
		this.cepUsuario = cepUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCidadeUsuario() {
		return cidadeUsuario;
	}

	public void setCidadeUsuario(String cidadeUsuario) {
		this.cidadeUsuario = cidadeUsuario;
	}
	
}
