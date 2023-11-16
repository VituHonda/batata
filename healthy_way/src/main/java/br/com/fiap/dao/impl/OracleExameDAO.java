package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.dao.ExameDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Exame;
import br.com.fiap.model.Usuario;

public class OracleExameDAO implements ExameDAO {
	
	private Connection conexao;

	@Override
	public void cadastrar(Exame exame) throws DBException {

		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO exames(nome_exame, data_exame) VALUES (?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, exame.getNomeExame());
			java.sql.Date data = new java.sql.Date(exame.getDataExame().getTimeInMillis());
			stmt.setDate(2, data);
			
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
	public void atualizar(Exame exame) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE exames SET nome_exame WHERE id_exame = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, exame.getNomeExame());
			stmt.setInt(2, exame.getIdExame());

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
			String sql = "DELETE FROM exames WHERE id_exame = ?";
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
	public Exame buscar(int id) {
		Exame exame = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM exames WHERE id_exame = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoExame = rs.getInt("id_exame");
				String nomeExame = rs.getString("nome_exame");
				
				java.sql.Date data = rs.getDate("data_exame");
				Calendar dataExame = Calendar.getInstance();
				dataExame.setTimeInMillis(data.getTime());

				exame = new Exame(nomeExame,dataExame);
				exame.setIdExame(codigoExame);

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

		return exame;
	}

	@Override
	public List<Exame> listar() {
		List<Exame> lista = new ArrayList<Exame>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM exames";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				int codigoExame = rs.getInt("id_exame");
				String nomeExame = rs.getString("nome_exame");
				
				java.sql.Date data = rs.getDate("data_exame");
				Calendar dataExame = Calendar.getInstance();
				dataExame.setTimeInMillis(data.getTime());

				Exame exame = new Exame(nomeExame,dataExame);
				exame.setIdExame(codigoExame);
				
				lista.add(exame);
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
