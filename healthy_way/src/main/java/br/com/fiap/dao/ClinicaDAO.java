package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Clinica;

public interface ClinicaDAO {
	
	void cadastrar(Clinica clinica) throws DBException;
	void atualizar(Clinica clinica) throws DBException; 
	void remover(int id) throws DBException;
	Clinica buscar(int id);
	List<Clinica> listar();
	
}
