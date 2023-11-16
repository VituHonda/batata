package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.dao.ClinicaTelefoneDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.ClinicaTelefone;
import br.com.fiap.model.Usuario;

public class OracleClinicaTelefoneDAO implements ClinicaTelefoneDAO {

	private Connection conexao;
	
	@Override
	public void cadastrar(ClinicaTelefone clinicaTelefone) throws DBException {
		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO clinica_telefones(telefone_clinica, clinica_id_clinica) VALUES (?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, clinicaTelefone.getTelefoneClinica());
			stmt.setInt(2, clinicaTelefone.getIdClinica());

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
	public void atualizar(ClinicaTelefone clinicaTelefone) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE clinica_telefones SET telefone_clinica = ? WHERE id_clinica_telefone = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, clinicaTelefone.getTelefoneClinica());
			stmt.setInt(2, clinicaTelefone.getIdClinicaTelefone());

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
	public void remover(int id) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM clinica_telefones WHERE id_clinica_telefones = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

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
	public ClinicaTelefone buscar(int id) {
		ClinicaTelefone clinicaTelefone = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM clinica_telefones WHERE id_clinica_telefone = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoClinicaTelefone = rs.getInt("id_clinica_telefone");
				String telefoneClinica = rs.getString("telefone_clinica");

				clinicaTelefone = new ClinicaTelefone(telefoneClinica);
				clinicaTelefone.setIdClinicaTelefone(codigoClinicaTelefone);

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

		return clinicaTelefone;
	}

	@Override
	public List<ClinicaTelefone> listar() {
		List<ClinicaTelefone> lista = new ArrayList<ClinicaTelefone>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM clinica_telefones";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				int codigoClinicaTelefone = rs.getInt("id_clinica_telefone");
				String telefoneClinica = rs.getString("telefone_clinica");

				ClinicaTelefone clinicaTelefone = new ClinicaTelefone(telefoneClinica);
				clinicaTelefone.setIdClinicaTelefone(codigoClinicaTelefone);
				
				lista.add(clinicaTelefone);
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
