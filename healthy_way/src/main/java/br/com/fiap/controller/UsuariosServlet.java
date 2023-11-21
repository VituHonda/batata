package br.com.fiap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.dao.TecnologiaDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Medico;
import br.com.fiap.model.Tecnologia;
import br.com.fiap.model.Usuario;

@WebServlet("/usuarios")
public class UsuariosServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;
	
	public UsuariosServlet() {
		super();
		dao = DAOFactory.getUsuarioDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		switch (acao) {
		case "editar":
			editar(request, response);
			break;
		case "excluir":
			excluir(request, response);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao":
			try {
				abrirFormEdicao(request, response);
			} catch (ServletException | IOException | DBException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	private void carregarOpcoesUsuario(HttpServletRequest request) {
		List<Usuario> lista = dao.listar();
		request.setAttribute("usuarios", lista);
	}
	
	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, DBException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Usuario usuario = dao.buscar(id);
		request.setAttribute("usuario", usuario);
		carregarOpcoesUsuario(request);
		request.getRequestDispatcher("edicao-usuario.jsp").forward(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> lista = dao.listar();
		request.setAttribute("usuarios", lista);
		request.getRequestDispatcher("listar-usuarios.jsp").forward(request, response);
		System.out.println("Enviado lista usuarios");
	}
	
	
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Usuario usuario = new Usuario(nome, email, senha);
			usuario.setIdUsuario(codigo);
				
			dao.atualizar(usuario);

			request.setAttribute("msg", "Usuario atualizada!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request, response);
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("idTecnologia"));
		
		System.out.println("excluindo usuario com id: " + codigo);
		
		try {
			dao.remover(codigo);
			request.setAttribute("msg", "Usuario removido!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao remover");
		}
		listar(request, response);
		
		request.getRequestDispatcher("listar-usuarios.jsp").forward(request, response);
	}

}
