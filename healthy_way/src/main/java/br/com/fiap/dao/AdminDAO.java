package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Admin;
import br.com.fiap.model.Usuario;

public interface AdminDAO {
	
	void cadastrar(Admin admin) throws DBException;
	void atualizar(Admin admin) throws DBException; 
	void remover(int id) throws DBException;
	Admin buscar(int id);
	Admin loginAdmin(Admin admin);
	public boolean validarAdmin(Admin admin);
	List<Admin> listar();
	
}
