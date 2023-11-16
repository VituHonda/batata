package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Tecnologia;

public interface TecnologiaDAO {
	void cadastrar(Tecnologia tecnologia) throws DBException;
	void atualizar(Tecnologia tecnologia) throws DBException; 
	void remover(int id) throws DBException;
	Tecnologia buscar(int id);
	List<Tecnologia> listar();
}
