package br.com.fiap.test;

import java.util.List;

import br.com.fiap.controller.UsuarioEnderecoDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.UsuarioEndereco;

public class UsuarioEnderecoTest {

	public static void main(String[] args) {
		
		UsuarioEnderecoDAO dao = DAOFactory.getUsuarioEnderecoDAO();

		UsuarioEndereco usuarioEndereco = null;

//		// cadastrar
//		usuarioEndereco = new UsuarioEndereco("Rua teste", "Estado teste", 123456, "123456-78");
//		usuarioEndereco.setIdUsuario(101);
//		try {
//			dao.cadastrar(usuarioEndereco);
//			System.out.println("Usuario Endereco cadastrado");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}
		
//		// atualizar
//		usuarioEndereco = new UsuarioEndereco("Rua 2", "Estado 2", 123, "789456-26");
//		usuarioEndereco.setIdUsuario(101);
//		usuarioEndereco.setIdUsuarioEndereco(3);
//		try {
//			dao.atualizar(usuarioEndereco);
//			System.out.println("Usuario Endereco atualizado");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}
		
//		// listar
//
//		List<UsuarioEndereco> lista = dao.listar();
//
//		for (UsuarioEndereco endereco : lista) {
//			System.out.println(endereco.getRuaUsuario() + " " + endereco.getEstadoUsuario() + " " + endereco.getNumeroUsuario() + " " + endereco.getCepUsuario());
//		}
		
//		// buscar
//		usuarioEndereco = dao.buscar(3);
//		System.out.println(usuarioEndereco.getRuaUsuario());
		
//		// remover
//		try {
//			dao.remover(3);
//			System.out.println("Usuario Endereco removido.");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}
		
		
	}

}
