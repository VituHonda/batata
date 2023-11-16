package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Exame;

public interface ExameDAO {
	
	void cadastrar(Exame exame) throws DBException;
	void atualizar(Exame exame) throws DBException; 
	void remover(int id) throws DBException;
	Exame buscar(int id);
	List<Exame> listar();
	
}
