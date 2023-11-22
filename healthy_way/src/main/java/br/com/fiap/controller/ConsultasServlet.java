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

import br.com.fiap.dao.AvaliacaoDAO;
import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.dao.TecnologiaDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Avaliacao;
import br.com.fiap.model.Consulta;
import br.com.fiap.model.Medico;
import br.com.fiap.model.Tecnologia;
import br.com.fiap.model.Usuario;

@WebServlet("/consultas")
public class ConsultasServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

	private ConsultaDAO dao;
	
	public ConsultasServlet() {
		super();
		dao = DAOFactory.getConsultaDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
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

		case "abrir-form-cadastro":
			abrirFormCadastro(request, response);
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
	
	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		carregarOpcoesConsulta(request);
		request.getRequestDispatcher("cadastro-consulta.jsp").forward(request, response);
	}

	private void carregarOpcoesConsulta(HttpServletRequest request) {
		List<Consulta> lista = dao.listar();
		request.setAttribute("consultas", lista);
	}
	
	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, DBException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Consulta consulta = dao.buscar(id);
		request.setAttribute("consulta", consulta);
		carregarOpcoesConsulta(request);
		request.getRequestDispatcher("edicao-avaliacao.jsp").forward(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Consulta> lista = dao.listar();
		request.setAttribute("consultas", lista);
		request.getRequestDispatcher("listar-consultas.jsp").forward(request, response);
		System.out.println("Enviado lista avaliacoes");
	}
	
	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			Usuario usuario = (Usuario) request.getAttribute("usuario");
			Medico medico = (Medico) request.getAttribute("medico");
			Tecnologia tecnologia = (Tecnologia) request.getAttribute("tecnologia");
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("data")));
			
			Consulta consulta = new Consulta(data, usuario, medico, tecnologia);

			dao.cadastrar(consulta);

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
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("data")));
						
			Consulta consulta = new Consulta();
			consulta.setDataConsulta(data);

			dao.cadastrar(consulta);

			request.setAttribute("msg", "Consulta atualizada!");
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
		
		System.out.println("excluindo avaliacao com id: " + codigo);
		
		try {
			dao.remover(codigo);
			request.setAttribute("msg", "Avaliacao removida!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao remover");
		}
		listar(request, response);
		
		request.getRequestDispatcher("listar-tecnologias.jsp").forward(request, response);
	}

}