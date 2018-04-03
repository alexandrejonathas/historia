package br.edu.adtalem.lds.historia.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.controller.actions.IAction;
import br.edu.adtalem.lds.historia.controller.helper.Aplicacao;

@WebServlet("/")
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Aplicacao app = new Aplicacao(request);
		IAction action = app.getAction();
		String pagina = action.execute(request, response);
		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.include(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processarRequisicao(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processarRequisicao(req, resp);
	}
		
	
}
