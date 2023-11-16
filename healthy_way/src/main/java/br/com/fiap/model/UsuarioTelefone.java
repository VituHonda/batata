package br.com.fiap.model;

public class UsuarioTelefone {
	
	private int idUsuarioTelefone;
	private String usuarioTelefone;
	private int idUsuario;
	
	public UsuarioTelefone() {}
	
	public UsuarioTelefone(String usuarioTelefone) {
		super();
		this.usuarioTelefone = usuarioTelefone;
	}

	public int getIdUsuarioTelefone() {
		return idUsuarioTelefone;
	}

	public void setIdUsuarioTelefone(int idUsuarioTelefone) {
		this.idUsuarioTelefone = idUsuarioTelefone;
	}

	public String getUsuarioTelefone() {
		return usuarioTelefone;
	}

	public void setUsuarioTelefone(String usuarioTelefone) {
		this.usuarioTelefone = usuarioTelefone;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
