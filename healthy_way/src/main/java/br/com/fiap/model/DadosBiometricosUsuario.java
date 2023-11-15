package br.com.fiap.model;

public class DadosBiometricosUsuario {
	
	private int idDadosBiometricosUsuario;
	private int idade;
	private double altura;
	private double peso;
	private String tipoSanguineo;
	private double pressaoMaior;
	private double pressaoMenor;
	private String genero;
	
	private String convenioMedico;
	private String cpf;
	
	public DadosBiometricosUsuario() {}

	public int getIdDadosBiometricosUsuario() {
		return idDadosBiometricosUsuario;
	}

	public void setIdDadosBiometricosUsuario(int idDadosBiometricosUsuario) {
		this.idDadosBiometricosUsuario = idDadosBiometricosUsuario;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public double getPressaoMaior() {
		return pressaoMaior;
	}

	public void setPressaoMaior(double pressaoMaior) {
		this.pressaoMaior = pressaoMaior;
	}

	public double getPressaoMenor() {
		return pressaoMenor;
	}

	public void setPressaoMenor(double pressaoMenor) {
		this.pressaoMenor = pressaoMenor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getConvenioMedico() {
		return convenioMedico;
	}

	public void setConvenioMedico(String convenioMedico) {
		this.convenioMedico = convenioMedico;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
