package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Consulta;

public interface ConsultaDAO {

	void cadastrar(Consulta consulta) throws DBException;
//	void atualizar(Consulta consulta) throws DBException; 
	void atender(int idConsulta) throws DBException;
	void remover(int id) throws DBException;
	Consulta buscar(int id);
	List<Consulta> listarConsultas(int idUsuario);
	List<Consulta> listarConsultasMedico(int idMedico);
	List<Consulta> listar();
	
	
}
