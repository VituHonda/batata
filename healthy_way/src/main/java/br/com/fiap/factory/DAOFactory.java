package br.com.fiap.factory;

import br.com.fiap.dao.AdminDAO;
import br.com.fiap.dao.AvaliacaoDAO;
import br.com.fiap.dao.ExameDAO;
import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.dao.TecnologiaDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.UsuarioEnderecoDAO;
import br.com.fiap.dao.UsuarioTelefoneDAO;
import br.com.fiap.dao.impl.OracleAdminDAO;
import br.com.fiap.dao.impl.OracleAvaliacaoDAO;
import br.com.fiap.dao.impl.OracleExameDAO;
import br.com.fiap.dao.impl.OracleMedicoDAO;
import br.com.fiap.dao.impl.OracleTecnologiaDAO;
import br.com.fiap.dao.impl.OracleUsuarioDAO;
import br.com.fiap.dao.impl.OracleUsuarioEnderecoDAO;
import br.com.fiap.dao.impl.OracleUsuarioTelefoneDAO;

public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
	
	public static UsuarioEnderecoDAO getUsuarioEnderecoDAO() {
		return new OracleUsuarioEnderecoDAO();
	}
	
	public static UsuarioTelefoneDAO getUsuarioTelefoneDAO() {
		return new OracleUsuarioTelefoneDAO();
	}
	
	public static TecnologiaDAO getTecnologiaDAO() {
		return new OracleTecnologiaDAO();
	}
	
	public static MedicoDAO getMedicoDAO() {
		return new OracleMedicoDAO();
	}
	
	public static ExameDAO getExameDAO() {
		return new OracleExameDAO();
	}
	
	public static AdminDAO getAdminDAO() {
		return new OracleAdminDAO();
	}
	
	public static AvaliacaoDAO getAvaliacaoDAO() {
		return new OracleAvaliacaoDAO();
	}
	
}
