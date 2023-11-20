package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.UsuarioEndereco;

public interface UsuarioEnderecoDAO {
	
	void cadastrar(UsuarioEndereco usuarioEndereco) throws DBException;
	void atualizar(UsuarioEndereco usuarioEndereco) throws DBException; 
	void remover(int id) throws DBException;
	UsuarioEndereco buscar(int id);
	List<UsuarioEndereco> listar();
	
}
