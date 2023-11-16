package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.dao.MedicoPorClinicaDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.MedicoPorClinica;
import br.com.fiap.model.Usuario;

public class OracleMedicoPorClinicaDAO implements MedicoPorClinicaDAO {

	private Connection conexao;
	
	@Override
	public void cadastrar(br.com.fiap.model.MedicoPorClinica medicoPorClinica) throws DBException {
		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO medico_por_clinica(data_inicio_contrato, id_medico, id_clinica) VALUES (?,?,?)";
			stmt = conexao.prepareStatement(sql);
			java.sql.Date dataInicio = new java.sql.Date(medicoPorClinica.getInicioContrato().getTimeInMillis());
			stmt.setDate(1, dataInicio);

			stmt.setInt(2, medicoPorClinica.getIdMedico());
			stmt.setInt(3, medicoPorClinica.getIdClinica());
			
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void atualizar(br.com.fiap.model.MedicoPorClinica medicoPorClinica) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE medico_por_clinica SET data_final_contrato WHERE id_medico = ? AND id_clinica = ?";
			stmt = conexao.prepareStatement(sql);
			
			java.sql.Date dataFim = new java.sql.Date(medicoPorClinica.getInicioContrato().getTimeInMillis());
			stmt.setDate(1, dataFim);
			
			stmt.setInt(2, medicoPorClinica.getIdMedico());
			stmt.setInt(3, medicoPorClinica.getIdClinica());

			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void remover(int idMedico, int idClinica) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM medico_por_clinica WHERE id_medico = ? AND id_clinica = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idMedico);
			stmt.setInt(2, idClinica);

			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public br.com.fiap.model.MedicoPorClinica buscar(int idMedico, int idClinica) {
		MedicoPorClinica medicoPorClinica = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM medico_por_clinica WHERE id_medico = ? AND id_clinica = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idMedico);
			stmt.setInt(2, idClinica);

			rs = stmt.executeQuery();

			if (rs.next()) {
				java.sql.Date dataI = rs.getDate("data_inicio_contrato");
				Calendar dataInicio = Calendar.getInstance();
				dataInicio.setTimeInMillis(dataI.getTime());
				
				java.sql.Date dataF = rs.getDate("data_fim_contrato");
				Calendar dataFim = Calendar.getInstance();
				dataFim.setTimeInMillis(dataF.getTime());
				
				int codigoMedico = rs.getInt("id_medico");
				int codigoClinica = rs.getInt("id_clinica");

				medicoPorClinica = new MedicoPorClinica(dataInicio);				
				medicoPorClinica.setFimContrato(dataFim);;
				medicoPorClinica.setIdMedico(codigoMedico);;
				medicoPorClinica.setIdClinica(codigoClinica);;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return medicoPorClinica;
	}

	@Override
	public List<MedicoPorClinica> listar() {
		List<MedicoPorClinica> lista = new ArrayList<MedicoPorClinica>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM medico_por_clinica";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				java.sql.Date dataI = rs.getDate("data_inicio_contrato");
				Calendar dataInicio = Calendar.getInstance();
				dataInicio.setTimeInMillis(dataI.getTime());
				
				java.sql.Date dataF = rs.getDate("data_fim_contrato");
				Calendar dataFim = Calendar.getInstance();
				dataFim.setTimeInMillis(dataF.getTime());
				
				int codigoMedico = rs.getInt("id_medico");
				int codigoClinica = rs.getInt("id_clinica");

				MedicoPorClinica medicoPorClinica = new MedicoPorClinica(dataInicio);				
				medicoPorClinica.setFimContrato(dataFim);;
				medicoPorClinica.setIdMedico(codigoMedico);;
				medicoPorClinica.setIdClinica(codigoClinica);;
				
				lista.add(medicoPorClinica);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lista;
	}



}
