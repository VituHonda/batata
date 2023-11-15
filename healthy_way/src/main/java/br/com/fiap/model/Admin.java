package br.com.fiap.model;

public class Admin {

	private int idAdmin;
	private String emailAdmin;
	private String senhaAdmin;
	
	public Admin() {}
	
	public Admin(String emailAdmin, String senhaAdmin) {
		super();
		this.emailAdmin = emailAdmin;
		this.senhaAdmin = senhaAdmin;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getEmailAdmin() {
		return emailAdmin;
	}

	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}

	public String getSenhaAdmin() {
		return senhaAdmin;
	}

	public void setSenhaAdmin(String senhaAdmin) {
		this.senhaAdmin = senhaAdmin;
	}
	
}
