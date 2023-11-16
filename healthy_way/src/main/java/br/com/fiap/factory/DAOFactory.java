package br.com.fiap.factory;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.UsuarioEnderecoDAO;
import br.com.fiap.dao.impl.OracleUsuarioDAO;
import br.com.fiap.dao.impl.OracleUsuarioEnderecoDAO;

public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
	
	public static UsuarioEnderecoDAO getUsuarioEnderecoDAO() {
		return new OracleUsuarioEnderecoDAO();
	}
	

}
