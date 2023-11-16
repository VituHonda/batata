package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.ClinicaTelefone;
import br.com.fiap.model.Usuario;

public interface ClinicaTelefoneDAO {
	void cadastrar(ClinicaTelefone clinicaTelefone) throws DBException;
	void atualizar(ClinicaTelefone clinicaTelefone) throws DBException; 
	void remover(int id) throws DBException;
	ClinicaTelefone buscar(int id);
	List<ClinicaTelefone> listar();
}
