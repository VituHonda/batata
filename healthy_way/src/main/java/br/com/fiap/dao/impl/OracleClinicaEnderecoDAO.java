package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.dao.ClinicaEnderecoDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.ClinicaEndereco;
import br.com.fiap.model.Usuario;

public class OracleClinicaEnderecoDAO implements ClinicaEnderecoDAO {
	
	private Connection conexao;

	@Override
	public void cadastrar(ClinicaEndereco clinicaEndereco) throws DBException {
		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO clinica_enderecos(rua_clinica, numero_clinica, estado_clinica, cidade_clinica, cep_clinica, clinica_id_clinica) VALUES (?,?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, clinicaEndereco.getRuaClinica());
			stmt.setInt(2, clinicaEndereco.getNumeroClinica());
			stmt.setString(3, clinicaEndereco.getEstadoClinica());
			stmt.setString(4, clinicaEndereco.getCidadeClinica());
			stmt.setString(5, clinicaEndereco.getCepClinica());
			stmt.setInt(6, clinicaEndereco.getIdClinica());

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
	public void atualizar(ClinicaEndereco clinicaEndereco) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE clinica_enderecos SET rua_clinica = ?, numero_clinica = ?, estado_clinica = ?, cidade_clinica = ?, cep_clinica = ? WHERE id_clinica_endereco = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, clinicaEndereco.getRuaClinica());
			stmt.setInt(2, clinicaEndereco.getNumeroClinica());
			stmt.setString(3, clinicaEndereco.getEstadoClinica());
			stmt.setString(4, clinicaEndereco.getCidadeClinica());
			stmt.setString(5, clinicaEndereco.getCepClinica());
			stmt.setInt(6, clinicaEndereco.getIdClinicaEndereco());

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
			String sql = "DELETE FROM clinica_enderecos WHERE id_clinica_endereco = ?";
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
	public ClinicaEndereco buscar(int id) {
		ClinicaEndereco clinicaEndereco = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM clinica_enderecos WHERE id_clinica_endereco = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoClinicaEndereco = rs.getInt("id_clinica_endereco");
				String ruaClinica = rs.getString("rua_clinica");
				int numeroClinica = rs.getInt("numero_clinica");
				String estadoClinica = rs.getString("estado_clinica");
				String cidadeClinica = rs.getString("cidade_clinica");
				String cepClinica = rs.getString("cep_clinica");

				clinicaEndereco = new ClinicaEndereco(ruaClinica, numeroClinica, estadoClinica, cidadeClinica, cepClinica);
				clinicaEndereco.setIdClinicaEndereco(codigoClinicaEndereco);

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

		return clinicaEndereco;
	}

	@Override
	public List<ClinicaEndereco> listar() {
		List<ClinicaEndereco> lista = new ArrayList<ClinicaEndereco>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM clinica_enderecos";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				int codigoClinicaEndereco = rs.getInt("id_clinica_endereco");
				String ruaClinica = rs.getString("rua_clinica");
				int numeroClinica = rs.getInt("numero_clinica");
				String estadoClinica = rs.getString("estado_clinica");
				String cidadeClinica = rs.getString("cidade_clinica");
				String cepClinica = rs.getString("cep_clinica");

				ClinicaEndereco clinicaEndereco = new ClinicaEndereco(ruaClinica, numeroClinica, estadoClinica, cidadeClinica, cepClinica);
				clinicaEndereco.setIdClinicaEndereco(codigoClinicaEndereco);
				
				lista.add(clinicaEndereco);
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
