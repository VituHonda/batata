package br.com.fiap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Usuario;

@WebServlet("/cadastroUsuario")
public class CadastroUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
	private Usuario usuarioCadastro = new Usuario();
	
	public CadastroUsuarioServlet() {
		super();
		dao = DAOFactory.getUsuarioDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect("cadastroUsuario.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
			
			String nome = request.getParameter("login-nome");
			String email = request.getParameter("login-email");
			String senha = request.getParameter("login-password");
				
			usuarioCadastro.setNomeUsuario(nome);
			usuarioCadastro.setEmailUsuario(email);
			usuarioCadastro.setSenhaUsuario(senha);
			
			System.out.println("cadastrando usuario");
			
			try {
				dao.cadastrar(usuarioCadastro);
				request.setAttribute("cadastro", "cadastro feito com sucesso");
				System.out.println("usuario cadastrado");
				request.getRequestDispatcher("loginUsuario.jsp").forward(request, response);
			} catch (DBException e) {
				request.setAttribute("erro", "Usuário ou senha inválido");
				System.out.println("erro ao cadastrar usuario");
				request.getRequestDispatcher("cadastroUsuario.jsp").forward(request, response);
				e.printStackTrace();
			}
		
	}

}