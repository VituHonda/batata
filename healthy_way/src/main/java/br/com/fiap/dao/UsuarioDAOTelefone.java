package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.UsuarioTelefone;

public interface UsuarioDAOTelefone {

	void cadastrar(UsuarioTelefone usuarioTelefone) throws DBException;
	void atualizar(UsuarioTelefone usuarioTelefone) throws DBException; 
	void remover(int id) throws DBException;
	UsuarioTelefone buscar(int id);
	List<UsuarioTelefone> listar();

}
