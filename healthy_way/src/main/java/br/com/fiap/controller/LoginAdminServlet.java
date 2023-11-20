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

import br.com.fiap.dao.AdminDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Admin;
import br.com.fiap.model.Usuario;

@WebServlet(urlPatterns = {"/loginAdmin", "/admin"})
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminDAO dao;
	private Admin adminLogin = new Admin();
	
	public LoginAdminServlet() {
		super();
		dao = DAOFactory.getAdminDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect("loginAdmin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
			
			String email = request.getParameter("login-email");
			String senha = request.getParameter("login-password");
			
			adminLogin.setEmailAdmin(email);
			adminLogin.setSenhaAdmin(senha);
			
			if (dao.validarAdmin(adminLogin)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", email);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			} else {
				request.setAttribute("erro", "Usuário ou senha inválido");
				request.getRequestDispatcher("loginAdmin.jsp").forward(request, response);
			}
			
		
	}

}