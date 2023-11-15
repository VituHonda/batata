package br.com.fiap.model;

import java.util.Calendar;

public class Exames {
	
	private int idExame;
	private Calendar dataExamne;
	
	public Exames() {}
	
	public Exames(Calendar dataExamne) {
		super();
		this.dataExamne = dataExamne;
	}

	public int getIdExame() {
		return idExame;
	}

	public void setIdExame(int idExame) {
		this.idExame = idExame;
	}

	public Calendar getDataExamne() {
		return dataExamne;
	}

	public void setDataExamne(Calendar dataExamne) {
		this.dataExamne = dataExamne;
	}
	
}
