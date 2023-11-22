package br.com.fiap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.DadosBiometricosUsuarioDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.DadosBiometricosUsuario;
import br.com.fiap.model.Usuario;

@WebServlet("/biometricos")
public class DadosUsuarioServet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private DadosBiometricosUsuarioDAO daoDados;
	
	public DadosUsuarioServet() {
		super();
		daoDados = DAOFactory.getDadosBiometricosUsuarioDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		}
		
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("user");
		int idUsuario = usuario.getIdUsuario();	
		List<DadosBiometricosUsuario> lista = daoDados.listarUsuario(idUsuario);
		request.setAttribute("dados", lista);
		request.getRequestDispatcher("dados-usuario.jsp").forward(request, response);
	}

}
