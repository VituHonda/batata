package br.com.fiap.model;

public class Tecnologia {
	
	private int idTecnologia;
	private String nomeTecnologia;
	private String descricaoTecnologia; 
	
	public Tecnologia() {}
	
	public Tecnologia(String nomeTecnologia, String descricaoTecnologia) {
		super();
		this.nomeTecnologia = nomeTecnologia;
		this.descricaoTecnologia = descricaoTecnologia;
	}

	public int getIdTecnologia() {
		return idTecnologia;
	}

	public void setIdTecnologia(int idTecnologia) {
		this.idTecnologia = idTecnologia;
	}

	public String getNomeTecnologia() {
		return nomeTecnologia;
	}

	public void setNomeTecnologia(String nomeTecnologia) {
		this.nomeTecnologia = nomeTecnologia;
	}

	public String getDescricaoTecnologia() {
		return descricaoTecnologia;
	}

	public void setDescricaoTecnologia(String descricaoTecnologia) {
		this.descricaoTecnologia = descricaoTecnologia;
	}
	
}
