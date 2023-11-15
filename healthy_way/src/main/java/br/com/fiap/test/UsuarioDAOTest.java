package br.com.fiap.test;

import java.util.List;

import br.com.fiap.controller.UsuarioDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Usuario;

public class UsuarioDAOTest {

	public static void main(String[] args) {

		UsuarioDAO dao = DAOFactory.getUsuarioDAO();

		Usuario usuario = null;

//		// cadastrar
//		usuario = new Usuario("Felipe", "emailfelipe@test.com", "123456");
//		try {
//			dao.cadastrar(usuario);
//			System.out.println("Usuario cadastrado");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}

//		// atualizar
//		usuario = new Usuario("Ramos", "emailramos@test.com", "1234");
//		usuario.setIdUsuario(81);
//		try {
//			dao.atualizar(usuario);
//			System.out.println("Usuario atualizado");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}

//		// listar
//
//		List<Usuario> lista = dao.listar();
//
//		for (Usuario user : lista) {
//			System.out.println(user.getNomeUsuario() + " " + user.getEmailUsuario());
//		}

//		// buscar
//		usuario = dao.buscar(81);
//		System.out.println(usuario.getNomeUsuario());
		
//		// remover
//		try {
//			dao.remover(82);
//			System.out.println("Usuario removido.");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}
		
	}

}
