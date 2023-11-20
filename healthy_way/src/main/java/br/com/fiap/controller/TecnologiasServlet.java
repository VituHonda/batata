package br.com.fiap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.dao.TecnologiaDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Medico;
import br.com.fiap.model.Tecnologia;
import br.com.fiap.model.Usuario;

@WebServlet("/tecnologias")
public class TecnologiasServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

	private TecnologiaDAO dao;
	
	public TecnologiasServlet() {
		super();
		dao = DAOFactory.getTecnologiaDAO();
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
		carregarOpcoesTecnologia(request);
		request.getRequestDispatcher("cadastro-tecnologia.jsp").forward(request, response);
	}

	private void carregarOpcoesTecnologia(HttpServletRequest request) {
		List<Tecnologia> lista = dao.listar();
		request.setAttribute("tecnologias", lista);
	}
	
	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, DBException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Tecnologia tecnologia = dao.buscar(id);
		request.setAttribute("tecnologia", tecnologia);
		carregarOpcoesTecnologia(request);
		request.getRequestDispatcher("edicao-tecnologia.jsp").forward(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Tecnologia> lista = dao.listar();
		request.setAttribute("tecnologias", lista);
		request.getRequestDispatcher("listar-tecnologias.jsp").forward(request, response);
		System.out.println("Enviado lista tecnologias");
	}
	
	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			
			System.out.println(nome);
			System.out.println(descricao);
			
			Tecnologia tecnologia = new Tecnologia(nome, descricao);

			dao.cadastrar(tecnologia);

			request.setAttribute("msg", "Tecnologia cadastrada!");
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
			
			Tecnologia tecnologia = new Tecnologia(nome, descricao);
			tecnologia.setIdTecnologia(codigo);
				
			dao.atualizar(tecnologia);

			request.setAttribute("msg", "Tecnologia atualizada!");
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
		
		System.out.println("excluindo tecnologia com id: " + codigo);
		
		try {
			dao.remover(codigo);
			request.setAttribute("msg", "Tecnologia removida!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao remover");
		}
		listar(request, response);
		
		request.getRequestDispatcher("listar-tecnologias.jsp").forward(request, response);
	}

}
