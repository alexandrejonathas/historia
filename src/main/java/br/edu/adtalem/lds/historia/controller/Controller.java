package br.edu.adtalem.lds.historia.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.controller.actions.IAction;
import br.edu.adtalem.lds.historia.controller.helper.ControllerHelper;

@WebServlet("/")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControllerHelper app = new ControllerHelper(request);
		IAction action;
		try {
			action = app.getAction();
			String pagina = action.execute(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(pagina);
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			rd.include(request, response);			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Não foi possivel executar a lógica ", e);
		} 
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
