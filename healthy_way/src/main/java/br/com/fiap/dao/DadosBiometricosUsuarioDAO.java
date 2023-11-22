package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.DadosBiometricosUsuario;
import br.com.fiap.model.Usuario;

public interface DadosBiometricosUsuarioDAO {
	
	void cadastrar(DadosBiometricosUsuario dadosBiometricos) throws DBException;
	void atualizar(DadosBiometricosUsuario dadosBiometricos) throws DBException; 
	void remover(int id) throws DBException;
	DadosBiometricosUsuario buscar(int id);
	List<DadosBiometricosUsuario> listar();
	List<DadosBiometricosUsuario> listarUsuario(int idUsuario);
	
}
