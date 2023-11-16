package br.com.fiap.model;

import java.util.Calendar;

public class Exame {
	
	private int idExame;
	private String nomeExame;
	private Calendar dataExame;
	
	public Exame() {}
	
	public Exame(String nomeExame,Calendar dataExame) {
		super();
		this.nomeExame = nomeExame;
		this.dataExame = dataExame;
	}

	public int getIdExame() {
		return idExame;
	}

	public void setIdExame(int idExame) {
		this.idExame = idExame;
	}

	public Calendar getDataExame() {
		return dataExame;
	}

	public void setDataExamne(Calendar dataExame) {
		this.dataExame = dataExame;
	}

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}
	
}
