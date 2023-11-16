package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Consulta;
import br.com.fiap.model.Usuario;

public class OracleConsultaDAO implements ConsultaDAO {

	private Connection conexao;

	@Override
	public void cadastrar(Consulta consulta) throws DBException {
		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO consultas(data_consulta, usuarios_id_usuario, medicos_id_medico, tecnologias_id_tecnologia) VALUES (?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			java.sql.Date data = new java.sql.Date(consulta.getDataConsulta().getTimeInMillis());
			stmt.setDate(1, data);
			stmt.setInt(2, consulta.getIdUsuario());
			stmt.setInt(3, consulta.getIdMedico());
			stmt.setInt(3, consulta.getIdTecnologia());

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

//	@Override
//	public void atualizar(Consulta consulta) throws DBException {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void remover(int id) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM consultas WHERE id_consulta = ?";
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
	public Consulta buscar(int id) {
		Consulta consulta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM consultas WHERE id_consulta = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoConsulta = rs.getInt("id_usuario");

				java.sql.Date data = rs.getDate("data_consulta");
				Calendar dataConsulta = Calendar.getInstance();
				dataConsulta.setTimeInMillis(data.getTime());

				consulta = new Consulta(dataConsulta);
				consulta.setIdConsulta(codigoConsulta);

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

		return consulta;
	}

	@Override
	public List<Consulta> listar() {
		List<Consulta> lista = new ArrayList<Consulta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM consultas";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {

				int codigoConsulta = rs.getInt("id_usuario");

				java.sql.Date data = rs.getDate("data_consulta");
				Calendar dataConsulta = Calendar.getInstance();
				dataConsulta.setTimeInMillis(data.getTime());

				Consulta consulta = new Consulta(dataConsulta);
				consulta.setIdConsulta(codigoConsulta);

				lista.add(consulta);
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
