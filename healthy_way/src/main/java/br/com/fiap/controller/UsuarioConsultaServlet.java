package br.com.fiap.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import br.com.fiap.model.Tecnologia;
import br.com.fiap.model.Usuario;

@WebServlet("/usuario-consulta")
public class UsuarioConsultaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ConsultaDAO daoConsulta;
	private MedicoDAO daoMedico;
	private TecnologiaDAO daoTecnologia;

	public UsuarioConsultaServlet() {
		super();
		daoConsulta = DAOFactory.getConsultaDAO();
		daoMedico = DAOFactory.getMedicoDAO();
		daoTecnologia = DAOFactory.getTecnologiaDAO();
	}
	
	protected void doService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		carregarOpcoesConsulta(request);
		carregarOpcoesTecnologia(request);
		carregarOpcoesMedico(request);
		request.getRequestDispatcher("cadastro-consulta.jsp").forward(request, response);
		System.out.println("cadastrar chamado");
		
		String acao = request.getParameter("acao");
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			System.out.println("cadastrar chamado cadastrar");	
			break;
		default:
			break;
		}
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HttpSession session = request.getSession();
			Usuario usuario = (Usuario) session.getAttribute("user");
			
			System.out.println(usuario.getIdUsuario());
			
			Medico medico = (Medico) request.getAttribute("medico");
			Tecnologia tecnologia = (Tecnologia) request.getAttribute("tecnologia");

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("data")));

			Consulta consulta = new Consulta(data, usuario, medico, tecnologia);

			daoConsulta.cadastrar(consulta);

			request.setAttribute("msg", "Consulta cadastrada!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		abrirFormCadastro(request, response);
	}

	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		carregarOpcoesConsulta(request);
		carregarOpcoesTecnologia(request);
		carregarOpcoesMedico(request);
		request.getRequestDispatcher("cadastro-consulta.jsp").forward(request, response);
		
	}

	private void carregarOpcoesMedico(HttpServletRequest request) {
		List<Medico> lista = daoMedico.listar();
		request.setAttribute("medicos", lista);
		
	}

	private void carregarOpcoesTecnologia(HttpServletRequest request) {
		List<Tecnologia> lista = daoTecnologia.listar();
		request.setAttribute("tecnologias", lista);
		
	}

	private void carregarOpcoesConsulta(HttpServletRequest request) {
		List<Consulta> lista = daoConsulta.listar();
		request.setAttribute("consultas", lista);
	}
}
