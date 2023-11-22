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
import br.com.fiap.model.Medico;
import br.com.fiap.model.Tecnologia;
import br.com.fiap.model.Usuario;

public class OracleConsultaDAO implements ConsultaDAO {

	private Connection conexao;

	@Override
	public void cadastrar(Consulta consulta) throws DBException {
		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO consultas(usuarios_id_usuario, medicos_id_medico, tecnologias_id_tecnologia) VALUES (?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(2, consulta.getUsuario().getIdUsuario());
			stmt.setInt(3, consulta.getMedico().getIdMedico());
			stmt.setInt(4, consulta.getTecnologiaConsulta().getIdTecnologia());

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

				consulta = new Consulta();
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

				int codigoConsulta = rs.getInt("id_consulta");
				int codigoUsuario = rs.getInt("usuarios_id_usuario");
				int codigoTecnologia = rs.getInt("tecnologias_id_tecnologia");
				int codigoMedico = rs.getInt("medicos_id_medico");
				int situacao = rs.getInt("situacao");

				Consulta consulta = new Consulta();
				consulta.setIdConsulta(codigoConsulta);
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(codigoUsuario);
				Tecnologia tecnologia = new Tecnologia();
				tecnologia.setIdTecnologia(codigoTecnologia);
				Medico medico = new Medico();
				medico.setIdMedico(codigoMedico);
				consulta.setUsuario(usuario);
				consulta.setTecnologiaConsulta(tecnologia);
				consulta.setMedico(medico);
				consulta.setSituacao(situacao);
				
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

	@Override
	public List<Consulta> listarConsultas(int idUsuario) {
		List<Consulta> lista = new ArrayList<Consulta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM consultas where usuarios_id_usuario = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idUsuario);
			
			rs = stmt.executeQuery();
			while (rs.next()) {

				
				

				

				Consulta consulta = new Consulta();
			

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
