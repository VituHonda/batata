package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.dao.UsuarioEnderecoDAO;
import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.UsuarioEndereco;

public class OracleUsuarioEnderecoDAO implements UsuarioEnderecoDAO {

	private Connection conexao;

	@Override
	public void cadastrar(UsuarioEndereco usuarioEndereco) throws DBException {
		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO USUARIO_ENDERECOS(rua_usuario,estado_usuario,numero_usuario,cep_usuario,cidade_usuario,usuarios_id_usuario) VALUES (?,?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuarioEndereco.getRuaUsuario());
			stmt.setString(2, usuarioEndereco.getEstadoUsuario());
			stmt.setInt(3, usuarioEndereco.getNumeroUsuario());
			stmt.setString(4, usuarioEndereco.getCepUsuario());
			stmt.setString(5, usuarioEndereco.getCidadeUsuario());
			stmt.setInt(6, usuarioEndereco.getIdUsuario());

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
	public void atualizar(UsuarioEndereco usuarioEndereco) throws DBException {

		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE USUARIO_ENDERECOS SET rua_usuario = ?, estado_usuario = ?, numero_usuario = ?, cep_usuario = ?, cidade_usuario = ? WHERE id_usuario_endereco = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuarioEndereco.getRuaUsuario());
			stmt.setString(2, usuarioEndereco.getEstadoUsuario());
			stmt.setInt(3, usuarioEndereco.getNumeroUsuario());
			stmt.setString(4, usuarioEndereco.getCepUsuario());
			stmt.setString(5, usuarioEndereco.getCidadeUsuario());
			stmt.setInt(6, usuarioEndereco.getIdUsuarioEndereco());

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
			String sql = "DELETE FROM USUARIO_ENDERECOS WHERE id_usuario_endereco = ?";
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
	public UsuarioEndereco buscar(int id) {
		UsuarioEndereco usuarioEndereco = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM USUARIO_ENDERECOS WHERE id_usuario_endereco = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoUsuarioEndereco = rs.getInt("id_usuario_endereco");
				String ruaUsuario = rs.getString("rua_usuario");
				String estadoUsuario = rs.getString("estado_usuario");
				int numeroUsuario = rs.getInt("numero_usuario");
				String cepUsuario = rs.getString("cep_usuario");
				String cidadeUsuario = rs.getString("cidade_usuario");

				usuarioEndereco = new UsuarioEndereco(ruaUsuario, estadoUsuario, numeroUsuario, cepUsuario, cidadeUsuario);
				usuarioEndereco.setIdUsuarioEndereco(codigoUsuarioEndereco);

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

		return usuarioEndereco;
	}

	@Override
	public List<UsuarioEndereco> listar() {
		List<UsuarioEndereco> lista = new ArrayList<UsuarioEndereco>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM USUARIO_ENDERECOS";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				int codigoUsuarioEndereco = rs.getInt("id_usuario_endereco");
				String ruaUsuario = rs.getString("rua_usuario");
				String estadoUsuario = rs.getString("estado_usuario");
				int numeroUsuario = rs.getInt("numero_usuario");
				String cepUsuario = rs.getString("cep_usuario");
				String cidadeUsuario = rs.getString("cidade_usuario");

				UsuarioEndereco usuarioEndereco = new UsuarioEndereco(ruaUsuario, estadoUsuario, numeroUsuario, cepUsuario, cidadeUsuario);
				usuarioEndereco.setIdUsuarioEndereco(codigoUsuarioEndereco);
				
				lista.add(usuarioEndereco);
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
