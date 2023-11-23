package br.com.fiap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.dao.TecnologiaDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Consulta;
import br.com.fiap.model.Medico;
import br.com.fiap.model.Usuario;

@WebServlet("/medico-consulta")
public class MedicoConsultaServlet extends HttpServlet {

	private ConsultaDAO daoConsulta;
	private MedicoDAO daoMedico;
	private TecnologiaDAO daoTecnologia;
	
	public MedicoConsultaServlet() {
		super();
		daoConsulta = DAOFactory.getConsultaDAO();
		daoMedico = DAOFactory.getMedicoDAO();
		daoTecnologia = DAOFactory.getTecnologiaDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		switch (acao) {
		case "listarMedicoConsulta":
			listarMedicoConsulta(request, response);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String acao = request.getParameter("acao");
		switch (acao) {
		case "excluir":
			try {
				excluir(request, response);
			} catch (ServletException | IOException | DBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "atender":
			try {
				atender(request, response);
			} catch (ServletException | IOException | DBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
	

	private void atender(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DBException {
		
		int idConsulta = Integer.parseInt(request.getParameter("idMedicoConsulta"));	
		System.out.println(idConsulta);
		daoConsulta.atender(idConsulta);
		listarMedicoConsulta(request, response);
		request.getRequestDispatcher("medico-consulta.jsp").forward(request, response);
	}

	private void listarMedicoConsulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Medico medico = (Medico) session.getAttribute("user");
		List<Consulta> lista = daoConsulta.listarConsultasMedico(medico.getIdMedico());
		request.setAttribute("consultas", lista);
		request.getRequestDispatcher("medico-consulta.jsp").forward(request, response);
		
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, DBException {
		int codigo = Integer.parseInt(request.getParameter("idMedicoConsulta"));
				
		try {
			daoConsulta.remover(codigo);
			request.setAttribute("msg", "Consulta desmarcado!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao remover");
		}
		
		listarMedicoConsulta(request, response);
		
		int idMedico = Integer.parseInt(request.getParameter("idMedicoConsulta"));
		daoConsulta.atender(idMedico);
		
		request.getRequestDispatcher("medico-consulta.jsp").forward(request, response);
	}
}
