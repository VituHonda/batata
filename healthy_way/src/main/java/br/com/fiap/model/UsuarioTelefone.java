package br.com.fiap.model;

public class UsuarioTelefone {
	
	private int idUsuarioTelefone;
	private String usuarioTelefone;
	
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
	
}
