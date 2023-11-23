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
			String sql = "INSERT INTO consultas(usuarios_id_usuario, medicos_id_medico, tecnologias_id_tecnologia, situacao) VALUES (?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, consulta.getUsuario().getIdUsuario());
			stmt.setInt(2, consulta.getMedico().getIdMedico());
			stmt.setInt(3, consulta.getTecnologiaConsulta().getIdTecnologia());
			stmt.setInt(4, consulta.getSituacao());

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
			String sql = "SELECT * FROM consultas c JOIN medicos m ON c.medicos_id_medico = m.id_medico JOIN tecnologias t ON c.tecnologias_id_tecnologia = t.id_tecnologia WHERE usuarios_id_usuario = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idUsuario);
			
			rs = stmt.executeQuery();
			while (rs.next()) {

				int idConsulta = rs.getInt("id_consulta");
				String nomeMedico = rs.getString("nome_medico");
				String crm = rs.getString("crm");
				String nomeTecnologia = rs.getString("nome_tecnologia");
				String descricaoTecnologia = rs.getString("descricao_tecnologia");

				Consulta consulta = new Consulta();
				Medico medico = new Medico();
				Tecnologia tecnologia = new Tecnologia();
				
				medico.setNomeMedico(nomeMedico);
				medico.setCrm(crm);
				tecnologia.setNomeTecnologia(nomeTecnologia);
				tecnologia.setDescricaoTecnologia(descricaoTecnologia);
				
				consulta.setMedico(medico);
				consulta.setTecnologiaConsulta(tecnologia);
				consulta.setIdConsulta(idConsulta);
				
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
	public List<Consulta> listarConsultasMedico(int idMedico) {
		List<Consulta> lista = new ArrayList<Consulta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM consultas c JOIN usuarios u ON c.usuarios_id_usuario = u.id_usuario JOIN tecnologias t ON c.tecnologias_id_tecnologia = t.id_tecnologia WHERE medicos_id_medico = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idMedico);
			
			rs = stmt.executeQuery();
			while (rs.next()) {

				int idConsulta = rs.getInt("id_consulta");
				int situacao = rs.getInt("situacao");
				String nomeUsuario = rs.getString("nome_usuario");
				String nomeTecnologia = rs.getString("nome_tecnologia");
				String descricaoTecnologia = rs.getString("descricao_tecnologia");

				Consulta consulta = new Consulta();
				Usuario usuario = new Usuario();
				Tecnologia tecnologia = new Tecnologia();
				
				usuario.setNomeUsuario(nomeUsuario);
				tecnologia.setNomeTecnologia(nomeTecnologia);
				tecnologia.setDescricaoTecnologia(descricaoTecnologia);
				
				consulta.setUsuario(usuario);
				consulta.setTecnologiaConsulta(tecnologia);
				consulta.setIdConsulta(idConsulta);
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
	public void atender(int idConsulta) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE consultas SET situacao = 1 WHERE id_consulta = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, idConsulta);

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

}
