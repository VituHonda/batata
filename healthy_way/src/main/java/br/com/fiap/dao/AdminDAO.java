package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Admin;

public interface AdminDAO {
	
	void cadastrar(Admin admin) throws DBException;
	void atualizar(Admin admin) throws DBException; 
	void remover(int id) throws DBException;
	Admin buscar(int id);
	List<Admin> listar();
	
}
