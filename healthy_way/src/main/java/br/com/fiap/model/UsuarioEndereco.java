package br.com.fiap.model;

public class UsuarioEndereco {
	
	private int idUsuarioEndereco;
	private String ruaUsuario;
	private String estadoUsuario;
	private String numeroUsuario;
	private String cepUsuario;
	
	public UsuarioEndereco() {}
	
	public UsuarioEndereco(String ruaUsuario, String estadoUsuario, String numeroUsuario, String cepUsuario) {
		super();
		this.ruaUsuario = ruaUsuario;
		this.estadoUsuario = estadoUsuario;
		this.numeroUsuario = numeroUsuario;
		this.cepUsuario = cepUsuario;
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

	public String getNumeroUsuario() {
		return numeroUsuario;
	}

	public void setNumeroUsuario(String numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}

	public String getCepUsuario() {
		return cepUsuario;
	}

	public void setCepUsuario(String cepUsuario) {
		this.cepUsuario = cepUsuario;
	}
	
}
