package br.com.fiap.factory;

import br.com.fiap.controller.UsuarioDAO;
import br.com.fiap.controller.UsuarioEnderecoDAO;
import br.com.fiap.controller.impl.OracleUsuarioDAO;
import br.com.fiap.controller.impl.OracleUsuarioEnderecoDAO;

public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
	
	public static UsuarioEnderecoDAO getUsuarioEnderecoDAO() {
		return new OracleUsuarioEnderecoDAO();
	}
	

}
