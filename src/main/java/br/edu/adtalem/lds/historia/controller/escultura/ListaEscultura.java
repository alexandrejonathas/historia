package br.edu.adtalem.lds.historia.controller.escultura;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Arte;
import br.edu.adtalem.lds.historia.model.data.PinturaStatic;

@WebServlet("/esculturas")
public class ListaEscultura extends HttpServlet {

	private static final long serialVersionUID = 1L;

	PinturaStatic db = PinturaStatic.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Arte> esculturas = db.getArteVisuals();
		req.setAttribute("esculturas", esculturas);
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/esculturas/lista.jsp");
		rd.forward(req, resp);
	}
	
}