package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.ClinicaEndereco;

public interface ClinicaEnderecoDAO {
	
	void cadastrar(ClinicaEndereco clinicaEndereco) throws DBException;
	void atualizar(ClinicaEndereco clinicaEndereco) throws DBException; 
	void remover(int id) throws DBException;
	ClinicaEndereco buscar(int id);
	List<ClinicaEndereco> listar();
	
}
