package br.com.fiap.controller.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.controller.UsuarioDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Usuario;

public class OracleUsuarioDAO implements UsuarioDAO {

	private Connection conexao;

	@Override
	public void cadastrar(Usuario usuario) throws DBException {

		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO USUARIOS(nome_usuario, email_usuario, senha_usuario) VALUES (?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setString(2, usuario.getEmailUsuario());
			stmt.setString(3, usuario.getSenhaUsuario());

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
	public void atualizar(Usuario usuario) throws DBException {

		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE USUARIOS SET nome_usuario = ?, email_usuario = ?, senha_usuario = ? WHERE id_usuario = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setString(2, usuario.getEmailUsuario());
			stmt.setString(3, usuario.getSenhaUsuario());
			stmt.setInt(4, usuario.getIdUsuario());

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
			String sql = "DELETE FROM USUARIOS WHERE id_usuario = ?";
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
	public Usuario buscar(int id) throws DBException {

		Usuario usuario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "";
			stmt.setInt(1, id);

			stmt.executeQuery();

			if (rs.next()) {

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao buscar.");
		}

		return usuario;
	}

	@Override
	public List<Usuario> listar() throws DBException {

		List<Usuario> lista = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM USUARIOS";
			stmt = conexao.prepareStatement(sql);
			stmt.executeQuery();
			
			if(rs.next()) {
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao listar.");
		}

		return lista;
	}

}