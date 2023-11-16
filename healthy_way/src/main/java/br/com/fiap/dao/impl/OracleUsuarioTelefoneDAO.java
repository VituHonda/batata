package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.dao.UsuarioTelefoneDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.UsuarioTelefone;

public class OracleUsuarioTelefoneDAO implements UsuarioTelefoneDAO {

	private Connection conexao;

	@Override
	public void cadastrar(UsuarioTelefone usuarioTelefone) throws DBException {
		
		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO USUARIOS() VALUES (?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuarioTelefone.getUsuarioTelefone());
			stmt.setInt(2, usuarioTelefone.getIdUsuario());

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
	public void atualizar(UsuarioTelefone usuarioTelefone) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE USUARIOS SET telefone_usuario = ? WHERE id_usuario_telefone = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuarioTelefone.getUsuarioTelefone());
			stmt.setInt(2, usuarioTelefone.getIdUsuarioTelefone());

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
			String sql = "DELETE FROM USUARIO_TELEFONES WHERE id_usuario_telefone = ?";
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
	public UsuarioTelefone buscar(int id) {
		UsuarioTelefone usuarioTelefone = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM USUARIO_TELEFONES WHERE id_usuario_telefone = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoUsuarioTelefone = rs.getInt("id_usuario_telefone");
				String telefoneUsuario = rs.getString("telefone_usuario");
				

				usuarioTelefone = new UsuarioTelefone(telefoneUsuario);
				usuarioTelefone.setIdUsuarioTelefone(codigoUsuarioTelefone);

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

		return usuarioTelefone;
	}

	@Override
	public List<UsuarioTelefone> listar() {
		List<UsuarioTelefone> lista = new ArrayList<UsuarioTelefone>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM USUARIO_TELEFONES";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				int codigoUsuarioTelefone = rs.getInt("id_usuario_telefone");
				String telefoneUsuario = rs.getString("telefone_usuario");
			
				UsuarioTelefone usuarioTelefone = new UsuarioTelefone(telefoneUsuario);
				usuarioTelefone.setIdUsuarioTelefone(codigoUsuarioTelefone);
				
				lista.add(usuarioTelefone);
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
