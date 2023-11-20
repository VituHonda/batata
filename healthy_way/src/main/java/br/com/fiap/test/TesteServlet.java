package br.com.fiap.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Usuario;

@WebServlet("/teste")
public class TesteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;
	
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getUsuarioDAO();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	       
	    String mensagem = "Olá da Servlet";
	    
	    request.setAttribute("mensagem", mensagem);
	    request.getRequestDispatcher("teste.jsp").forward(request, response);
	    
	    System.out.println("Método doGet chamado!");
	    
	}

	
}
