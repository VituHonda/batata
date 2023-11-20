package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.dao.TecnologiaDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Tecnologia;
import br.com.fiap.model.Usuario;

public class OracleTecnologiaDAO implements TecnologiaDAO {

	private Connection conexao;

	@Override
	public void cadastrar(Tecnologia tecnologia) throws DBException {
		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO tecnologias(nome_tecnologia, descricao_tecnologia) VALUES (?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, tecnologia.getNomeTecnologia());
			stmt.setString(2, tecnologia.getDescricaoTecnologia());


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
	public void atualizar(Tecnologia tecnologia) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE tecnologias SET nome_tecnologia = ?, descricao_tecnologia = ? WHERE id_tecnologia = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, tecnologia.getNomeTecnologia());
			stmt.setString(2, tecnologia.getDescricaoTecnologia());
			stmt.setInt(3, tecnologia.getIdTecnologia());

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
			String sql = "DELETE FROM tecnologias WHERE id_tecnologia = ?";
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
	public Tecnologia buscar(int id) {
		Tecnologia tecnologia = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM tecnologias WHERE id_tecnologia = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoTecnologia = rs.getInt("id_tecnologia");
				String nomeTecnologia = rs.getString("nome_tecnologia");
				String descricaoTecnologia = rs.getString("descricao_tecnologia");
				
				tecnologia = new Tecnologia(nomeTecnologia, descricaoTecnologia);
				tecnologia.setIdTecnologia(codigoTecnologia);

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

		return tecnologia;
	}

	@Override
	public List<Tecnologia> listar() {
		List<Tecnologia> lista = new ArrayList<Tecnologia>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM TECNOLOGIAS";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				int codigoTecnologia = rs.getInt("id_tecnologia");
				String nomeTecnologia = rs.getString("nome_tecnologia");
				String descricaoTecnologia = rs.getString("descricao_tecnologia");
				
				Tecnologia tecnologia = new Tecnologia(nomeTecnologia, descricaoTecnologia);
				tecnologia.setIdTecnologia(codigoTecnologia);
				
				lista.add(tecnologia);
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
