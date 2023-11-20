package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.dao.AdminDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Admin;
import br.com.fiap.model.Usuario;

public class OracleAdminDAO implements AdminDAO {

	private Connection conexao;
	
	@Override
	public void cadastrar(Admin admin) throws DBException {
		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO admins(email_admin, senha_admin) VALUES (?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, admin.getEmailAdmin());
			stmt.setString(2, admin.getSenhaAdmin());


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
	public void atualizar(Admin admin) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE admins SET email_admin = ?, senha_admin = ? WHERE id_admin = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, admin.getEmailAdmin());
			stmt.setString(2, admin.getSenhaAdmin());
			stmt.setInt(3, admin.getIdAdmin());

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
			String sql = "DELETE FROM admins WHERE id_admin = ?";
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
	public Admin buscar(int id) {
		Admin admin = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM admins WHERE id_admin = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoAdmin = rs.getInt("id_usuario");
				String emailAdmin = rs.getString("email_admin");
				String senhaAdmin = rs.getString("senha_admin");

				admin = new Admin(emailAdmin, senhaAdmin);
				admin.setIdAdmin(codigoAdmin);

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

		return admin;
	}

	@Override
	public List<Admin> listar() {
		List<Admin> lista = new ArrayList<Admin>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM admins";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				int codigoAdmin = rs.getInt("id_usuario");
				String emailAdmin = rs.getString("email_admin");
				String senhaAdmin = rs.getString("senha_admin");

				Admin admin = new Admin(emailAdmin, senhaAdmin);
				admin.setIdAdmin(codigoAdmin);
				
				lista.add(admin);
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

	@Override
	public Admin loginAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validarAdmin(Admin admin) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM admins WHERE email_admin = ? AND senha_admin = ?");
			stmt.setString(1, admin.getEmailAdmin());
			stmt.setString(2, admin.getSenhaAdmin());
			rs = stmt.executeQuery();

			if (rs.next()) {
				return true;
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
		return false;
	}



}
