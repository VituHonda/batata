package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Medico;
import br.com.fiap.model.Usuario;

public interface MedicoDAO {
	
	void cadastrar(Medico medico) throws DBException;
	void atualizar(Medico medico) throws DBException; 
	void remover(int id) throws DBException;
	Medico buscar(int id);
	Medico loginMedico(Medico medico);
	public boolean validarMedico(Medico medico);
	List<Medico> listar();
	
}
