package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.dao.AvaliacaoDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Avaliacao;
import br.com.fiap.model.Tecnologia;
import br.com.fiap.model.Usuario;

public class OracleAvaliacaoDAO implements AvaliacaoDAO{

	private Connection conexao;
	
	@Override
	public void cadastrar(Avaliacao avaliacao) throws DBException {
		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO avaliacoes(nota, mensagem, usuarios_id_usuario, tecnologias_id_tecnologia) VALUES (?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, avaliacao.getNota());
			stmt.setString(2, avaliacao.getMensagem());
			stmt.setInt(3, avaliacao.getUsuario().getIdUsuario());
			stmt.setInt(4, avaliacao.getTecnologiaConsulta().getIdTecnologia());

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
	public void atualizar(Avaliacao avaliacao) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE avaliacoes SET nota = ?, mensagem = ? WHERE id_avaliacao = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, avaliacao.getNota());
			stmt.setString(2, avaliacao.getMensagem());
			stmt.setInt(3, avaliacao.getIdAvaliacao());

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
			String sql = "DELETE FROM avaliacoes WHERE id_avaliacao = ?";
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
	public Avaliacao buscar(int id) {
		Avaliacao avaliacao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM avaliacoes WHERE id_avaliacao = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoAvaliacao = rs.getInt("id_avaliacao");
				int nota = rs.getInt("nota");
				String mensagem = rs.getString("mensagem");
				
				int idUsuario = rs.getInt("usuarios_id_usuario");
				int idTecnologia = rs.getInt("tecnologias_id_tecnologia");

				Usuario usuario = new Usuario();
				Tecnologia tecnologia = new Tecnologia();
				usuario.setIdUsuario(idUsuario);
				tecnologia.setIdTecnologia(idTecnologia);
				
				avaliacao = new Avaliacao(nota, mensagem);
				avaliacao.setIdAvaliacao(codigoAvaliacao);
				avaliacao.setUsuario(usuario);
				avaliacao.setTecnologiaConsulta(tecnologia);
				

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

		return avaliacao;
	}

	@Override
	public List<Avaliacao> listar() {
		List<Avaliacao> lista = new ArrayList<Avaliacao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM avaliacoes";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				int codigoAvaliacao = rs.getInt("id_avaliacao");
				int nota = rs.getInt("nota");
				String mensagem = rs.getString("mensagem");

				int idUsuario = rs.getInt("usuarios_id_usuario");
				int idTecnologia = rs.getInt("tecnologias_id_tecnologia");

				Usuario usuario = new Usuario();
				Tecnologia tecnologia = new Tecnologia();
				usuario.setIdUsuario(idUsuario);
				tecnologia.setIdTecnologia(idTecnologia);
		
				Avaliacao avaliacao = new Avaliacao(nota, mensagem);
				avaliacao.setIdAvaliacao(codigoAvaliacao);
				avaliacao.setUsuario(usuario);
				avaliacao.setTecnologiaConsulta(tecnologia);
				
				lista.add(avaliacao);
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
