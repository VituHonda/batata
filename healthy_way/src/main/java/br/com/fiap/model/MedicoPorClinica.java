package br.com.fiap.model;

import java.util.Calendar;

public class MedicoPorClinica {
	
	private Calendar inicioContrato;
	private Calendar fimContrato;
	
	public MedicoPorClinica() {}
	
	public MedicoPorClinica(Calendar inicioContrato) {
		super();
		this.inicioContrato = inicioContrato;
	}

	public Calendar getInicioContrato() {
		return inicioContrato;
	}

	public void setInicioContrato(Calendar inicioContrato) {
		this.inicioContrato = inicioContrato;
	}

	public Calendar getFimContrato() {
		return fimContrato;
	}

	public void setFimContrato(Calendar fimContrato) {
		this.fimContrato = fimContrato;
	}
	
}
