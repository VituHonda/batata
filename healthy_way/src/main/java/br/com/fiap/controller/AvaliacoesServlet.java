package br.com.fiap.controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/avaliacoes")
public class AvaliacoesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private AvaliacaoDAO dao;
	private ConsultaDAO daoConsulta;

	public AvaliacoesServlet() {
		super();
		dao = DAOFactory.getAvaliacaoDAO();
		daoConsulta = DAOFactory.getConsultaDAO();
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

		int notas[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		request.setAttribute("notas", notas);
		
		String consultaString = request.getParameter("idUsuarioConsulta");
		int idConsulta = Integer.parseInt(consultaString);

		Consulta consulta = daoConsulta.buscar(idConsulta);

		request.setAttribute("consulta", consulta);

		carregarOpcoesAvaliacao(request);
		request.getRequestDispatcher("cadastro-avaliacao.jsp").forward(request, response);
	}

	private void carregarOpcoesAvaliacao(HttpServletRequest request) {
		List<Avaliacao> lista = dao.listar();
		request.setAttribute("avaliacoes", lista);
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, DBException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Avaliacao avaliacao = dao.buscar(id);
		request.setAttribute("avaliacao", avaliacao);
		carregarOpcoesAvaliacao(request);
		request.getRequestDispatcher("edicao-avaliacao.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Avaliacao> lista = dao.listar();
		request.setAttribute("avaliacoes", lista);
		request.getRequestDispatcher("listar-avaliacoes.jsp").forward(request, response);
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HttpSession session = request.getSession();
			Usuario usuario = (Usuario) session.getAttribute("user");
			
			String notaString = request.getParameter("nota");
			int nota = Integer.parseInt(notaString);

			String tecnologiaString = request.getParameter("idTecnologia");
			int idTecnoloiga = Integer.parseInt(tecnologiaString);
			
			String msg = request.getParameter("mensagem");
			
			String consulta = request.getParameter("consulta.tecnologiaConsulta.idTecnologia");
						
			Avaliacao avaliacao = new Avaliacao(nota, msg);
			avaliacao.setUsuario(usuario);
			Tecnologia tecnologia = new Tecnologia();
			tecnologia.setIdTecnologia(idTecnoloiga);
			avaliacao.setTecnologiaConsulta(tecnologia);
			
			dao.cadastrar(avaliacao);

			request.setAttribute("msg", "Avaliacao cadastrada!");
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
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");

			String notaString = request.getParameter("nota");
			int nota = Integer.parseInt(notaString);
			String mensagem = request.getParameter("mensagem");

			Avaliacao avaliacao = new Avaliacao(nota, mensagem);

			dao.cadastrar(avaliacao);

			request.setAttribute("msg", "Avaliacao atualizada!");
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
		int codigo = Integer.parseInt(request.getParameter("idAvaliacao"));


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