package br.com.fiap.model;

public class Medico {
	
	private int idMedico;
	private String nomeMedico;
	private String emailMedico;
	private String senhaMedico;
	private String estadoCrm;
	private String crm;
	
	public Medico() {}
	
	public Medico(String nomeMedico, String emailMedico, String senhaMedico,String estadoCrm, String crm) {
		super();
		this.nomeMedico = nomeMedico;
		this.emailMedico = emailMedico;
		this.senhaMedico = senhaMedico;
		this.estadoCrm = estadoCrm;
		this.crm = crm;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getEmailMedico() {
		return emailMedico;
	}

	public void setEmailMedico(String emailMedico) {
		this.emailMedico = emailMedico;
	}

	public String getSenhaMedico() {
		return senhaMedico;
	}

	public void setSenhaMedico(String senhaMedico) {
		this.senhaMedico = senhaMedico;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEstadoCrm() {
		return estadoCrm;
	}

	public void setEstadoCrm(String estadoCrm) {
		this.estadoCrm = estadoCrm;
	}
	
}
