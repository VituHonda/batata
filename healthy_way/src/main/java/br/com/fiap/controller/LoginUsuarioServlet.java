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
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Usuario;

@WebServlet("/loginUsuario")
public class LoginUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;
	private Usuario usuarioLogin = new Usuario();

	public LoginUsuarioServlet() {
		super();
		dao = DAOFactory.getUsuarioDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("loginUsuario.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession();
		session.setAttribute("user", null);

		String email = request.getParameter("login-email");
		String senha = request.getParameter("login-password");

		usuarioLogin.setEmailUsuario(email);
		usuarioLogin.setSenhaUsuario(senha);

		Usuario usuario = dao.buscarEmail(email);

		if (dao.validarUsuario(usuarioLogin)) {
			session = request.getSession();
			session.setAttribute("user", usuario);
			request.getRequestDispatcher("usuario.jsp").forward(request, response);
		} else {
			request.setAttribute("erro", "Usuário ou senha inválido");
			request.getRequestDispatcher("loginUsuario.jsp").forward(request, response);
		}

	}

}