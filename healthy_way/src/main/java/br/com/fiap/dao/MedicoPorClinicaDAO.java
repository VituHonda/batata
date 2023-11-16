package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.MedicoPorClinica;

public interface MedicoPorClinicaDAO {
	
	void cadastrar(MedicoPorClinica medicoPorClinica) throws DBException;
	void atualizar(MedicoPorClinica medicoPorClinica) throws DBException; 
	void remover(int idMedico, int idClinica) throws DBException;
	MedicoPorClinica buscar(int idMedico, int idClinica);
	List<MedicoPorClinica> listar();
}
