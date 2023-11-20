package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.dao.DadosBiometricosUsuarioDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.DadosBiometricosUsuario;
import br.com.fiap.model.Usuario;

public class OracleDadosBiometricosUsuarioDAO implements DadosBiometricosUsuarioDAO {

	private Connection conexao;
	
	@Override
	public void cadastrar(DadosBiometricosUsuario dadosBiometricos) throws DBException {
		PreparedStatement stmt = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO dados_biometricos_usuario(idade,altura,peso,tipo_sanguineo,convenio_medico,pressao_maior,pressao_menor,genero,cpf,usuarios_id_usuario) VALUES (?,?,?,?,?,?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, dadosBiometricos.getIdade());
			stmt.setDouble(2, dadosBiometricos.getAltura());
			stmt.setDouble(3, dadosBiometricos.getPeso());
			stmt.setString(4, dadosBiometricos.getTipoSanguineo());
			stmt.setString(5, dadosBiometricos.getConvenioMedico());
			stmt.setDouble(6, dadosBiometricos.getPressaoMaior());
			stmt.setDouble(7, dadosBiometricos.getPressaoMenor());
			stmt.setString(8, dadosBiometricos.getGenero());
			stmt.setString(9, dadosBiometricos.getCpf());
			stmt.setInt(10, dadosBiometricos.getIdUsuario());
			
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
	public void atualizar(DadosBiometricosUsuario dadosBiometricos) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE dados_biometricos_usuario SET idade=?,altura=?,peso=?,tipo_sanguineo=?,convenio_medico=?,pressao_maior=?,pressao_menor=?,genero=?,cpf=? WHERE id_dado_biometrico_usuario = ?";
			stmt.setInt(1, dadosBiometricos.getIdade());
			stmt.setDouble(2, dadosBiometricos.getAltura());
			stmt.setDouble(3, dadosBiometricos.getPeso());
			stmt.setString(4, dadosBiometricos.getTipoSanguineo());
			stmt.setString(5, dadosBiometricos.getConvenioMedico());
			stmt.setDouble(6, dadosBiometricos.getPressaoMaior());
			stmt.setDouble(7, dadosBiometricos.getPressaoMenor());
			stmt.setString(8, dadosBiometricos.getGenero());
			stmt.setString(9, dadosBiometricos.getCpf());
			stmt.setInt(10, dadosBiometricos.getIdDadosBiometricosUsuario());

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
			String sql = "DELETE FROM dados_biometricos_usuario WHERE id_dado_biometrico_usuario = ?";
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
	public DadosBiometricosUsuario buscar(int id) {
		DadosBiometricosUsuario dadosBiometricos = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM dados_biometricos_usuario WHERE id_dado_biometrico_usuario = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoDadosBiometricos = rs.getInt("id_dado_biometrico_usuario");
				int idade = rs.getInt("idade");
				double altura = rs.getDouble("altura");
				double peso = rs.getDouble("peso");
				String tipoSangue = rs.getString("tipo_sanguineo");
				String convenioMedico = rs.getString("convenio_medico");
				double pressaoMaior = rs.getDouble("pressao_maior");
				double pressaoMenor = rs.getDouble("pressao_menor");
				String genero = rs.getString("genero");
				String cpf = rs.getString("cpf");

				dadosBiometricos = new DadosBiometricosUsuario();
				dadosBiometricos.setIdDadosBiometricosUsuario(codigoDadosBiometricos);
				dadosBiometricos.setIdade(idade);
				dadosBiometricos.setAltura(altura);
				dadosBiometricos.setPeso(peso);
				dadosBiometricos.setTipoSanguineo(tipoSangue);
				dadosBiometricos.setConvenioMedico(convenioMedico);
				dadosBiometricos.setPressaoMaior(pressaoMaior);
				dadosBiometricos.setPressaoMenor(pressaoMenor);
				dadosBiometricos.setGenero(genero);
				dadosBiometricos.setCpf(cpf);
		
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

		return dadosBiometricos;
	}

	@Override
	public List<DadosBiometricosUsuario> listar() {
		List<DadosBiometricosUsuario> lista = new ArrayList<DadosBiometricosUsuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM dados_biometricos_usuario";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				int codigoDadosBiometricos = rs.getInt("id_dado_biometrico_usuario");
				int idade = rs.getInt("idade");
				double altura = rs.getDouble("altura");
				double peso = rs.getDouble("peso");
				String tipoSangue = rs.getString("tipo_sanguineo");
				String convenioMedico = rs.getString("convenio_medico");
				double pressaoMaior = rs.getDouble("pressao_maior");
				double pressaoMenor = rs.getDouble("pressao_menor");
				String genero = rs.getString("genero");
				String cpf = rs.getString("cpf");

				DadosBiometricosUsuario dadosBiometricos = new DadosBiometricosUsuario();
				dadosBiometricos.setIdDadosBiometricosUsuario(codigoDadosBiometricos);
				dadosBiometricos.setIdade(idade);
				dadosBiometricos.setAltura(altura);
				dadosBiometricos.setPeso(peso);
				dadosBiometricos.setTipoSanguineo(tipoSangue);
				dadosBiometricos.setConvenioMedico(convenioMedico);
				dadosBiometricos.setPressaoMaior(pressaoMaior);
				dadosBiometricos.setPressaoMenor(pressaoMenor);
				dadosBiometricos.setGenero(genero);
				dadosBiometricos.setCpf(cpf);
				
				lista.add(dadosBiometricos);
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
