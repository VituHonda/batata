package br.com.fiap.factory;

import br.com.fiap.controller.UsuarioDAO;
import br.com.fiap.controller.impl.OracleUsuarioDAO;

public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
	

}
