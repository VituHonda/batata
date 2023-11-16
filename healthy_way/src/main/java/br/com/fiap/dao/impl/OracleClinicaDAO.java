package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.dao.ClinicaDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Clinica;
import br.com.fiap.model.Usuario;

public class OracleClinicaDAO implements ClinicaDAO{

	private Connection conexao;
	
	@Override
	public void cadastrar(Clinica clinica) throws DBException {
		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO clinicas(nome_clinica) VALUES (?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, clinica.getNomeClinica());

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
	public void atualizar(Clinica clinica) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE USUARIOS SET nome_clinica = ? WHERE id_clinica = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, clinica.getNomeClinica());


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
			String sql = "DELETE FROM clinicas WHERE id_clinica = ?";
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
	public Clinica buscar(int id) {
		Clinica clinica = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM clinicas WHERE id_clinica = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoClinica = rs.getInt("id_clinica");
				String nomeClinica = rs.getString("nome_clinica");
				
				clinica = new Clinica(nomeClinica);
				clinica.setIdClinica(codigoClinica);

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

		return clinica;
	}

	@Override
	public List<Clinica> listar() {
		List<Clinica> lista = new ArrayList<Clinica>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM clinicas";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				int codigoClinica = rs.getInt("id_clinica");
				String nomeClinica = rs.getString("nome_clinica");
				
				Clinica clinica = new Clinica(nomeClinica);
				clinica.setIdClinica(codigoClinica);
				
				lista.add(clinica);
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
