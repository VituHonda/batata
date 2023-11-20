package br.com.fiap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Medico;
import br.com.fiap.model.Usuario;

@WebServlet("/loginMedico")
public class LoginMedicoServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	private MedicoDAO dao;
	private Medico medicoLogin = new Medico();
	
	public LoginMedicoServlet() {
		super();
		dao = DAOFactory.getMedicoDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect("loginMedico.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
			
			String email = request.getParameter("login-email");
			String senha = request.getParameter("login-password");
			
			medicoLogin.setEmailMedico(email);
			medicoLogin.setSenhaMedico(senha);
		

			if (dao.validarMedico(medicoLogin)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", email);
				request.getRequestDispatcher("medico.jsp").forward(request, response);
			} else {
				request.setAttribute("erro", "Usuário ou senha inválido");
				request.getRequestDispatcher("loginMedico.jsp").forward(request, response);
			}
			
		
	}

}
