package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Avaliacao;

public interface AvaliacaoDAO {

	
	void cadastrar(Avaliacao avaliacao) throws DBException;
	void atualizar(Avaliacao avaliacao) throws DBException; 
	void remover(int id) throws DBException;
	Avaliacao buscar(int id);
	List<Avaliacao> listar();
}
