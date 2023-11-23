package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Medico;
import br.com.fiap.model.Usuario;

public class OracleMedicoDAO implements MedicoDAO {

	private Connection conexao;

	@Override
	public void cadastrar(Medico medico) throws DBException {
		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO medicos(nome_medico, email_medico,senha_medico,estado_crm,crm) VALUES (?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, medico.getNomeMedico());
			stmt.setString(2, medico.getEmailMedico());
			stmt.setString(3, medico.getSenhaMedico());
			stmt.setString(4, medico.getEstadoCrm());
			stmt.setString(5, medico.getCrm());

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
	public void atualizar(Medico medico) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE medicos SET nome_medico = ?,email_medico=?,senha_medico=?,estado_crm=?,crm=? WHERE id_medico = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, medico.getNomeMedico());
			stmt.setString(2, medico.getEmailMedico());
			stmt.setString(3, medico.getSenhaMedico());
			stmt.setString(4, medico.getEstadoCrm());
			stmt.setString(5, medico.getCrm());
			stmt.setInt(6, medico.getIdMedico());

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
			String sql = "DELETE FROM medicos WHERE id_medico = ?";
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
	public Medico buscar(int id) {
		Medico medico = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM medicos WHERE id_medico = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoMedico = rs.getInt("id_medico");
				String nomeMedico = rs.getString("nome_medico");
				String emailMedico = rs.getString("email_medico");
				String senhaMedico = rs.getString("senha_medico");
				String estadoCrm = rs.getString("estado_crm");
				String crm = rs.getString("crm");

				medico = new Medico(nomeMedico, emailMedico, senhaMedico, estadoCrm, crm);
				medico.setIdMedico(codigoMedico);

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

		return medico;
	}

	@Override
	public List<Medico> listar() {
		List<Medico> lista = new ArrayList<Medico>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM medicos";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {

				int codigoMedico = rs.getInt("id_medico");
				String nomeMedico = rs.getString("nome_medico");
				String emailMedico = rs.getString("email_medico");
				String senhaMedico = rs.getString("senha_medico");
				String estadoCrm = rs.getString("estado_crm");
				String crm = rs.getString("crm");

				Medico medico = new Medico(nomeMedico, emailMedico, senhaMedico, estadoCrm, crm);
				medico.setIdMedico(codigoMedico);

				lista.add(medico);
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
	public Medico loginMedico(Medico medico) {
		Medico medicoLogin = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM medicos WHERE medico = ? AND medico = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, medico.getEmailMedico());
			stmt.setString(2, medico.getSenhaMedico());

			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoMedico = rs.getInt("id_medico");
				String nomeMedico = rs.getString("nome_medico");
				String emailMedico = rs.getString("email_medico");
				String senhaMedico = rs.getString("senha_medico");
				String estadoCrm = rs.getString("estado_crm");
				String crm = rs.getString("crm");

				medico = new Medico(nomeMedico, emailMedico, senhaMedico, estadoCrm, crm);
				medico.setIdMedico(codigoMedico);

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

		return medico;
	}

	@Override
	public boolean validarMedico(Medico medico) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM medicos WHERE email_medico = ? AND senha_medico = ?");
			stmt.setString(1, medico.getEmailMedico());
			stmt.setString(2, medico.getSenhaMedico());
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

	public Medico buscarEmail(String email) {
		Medico medico = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM medicos WHERE email_medico = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, email);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoMedico = rs.getInt("id_medico");
				String nomeMedico = rs.getString("nome_medico");
				String emailMedico = rs.getString("email_medico");

				medico = new Medico();
				medico.setIdMedico(codigoMedico);
				medico.setNomeMedico(nomeMedico);
				medico.setEmailMedico(emailMedico);

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

		return medico;
	}

}
