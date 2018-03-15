package br.edu.adtalem.lds.historia.controller.heroi;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Pessoa;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

@WebServlet("/herois")
public class ListaHeroi extends HttpServlet {

	private static final long serialVersionUID = 1L;

	StaticDB db = StaticDB.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Pessoa> herois = db.getHerois();
		req.setAttribute("herois", herois);

		RequestDispatcher rd = req.getRequestDispatcher("/view/herois/lista.jsp");
		rd.forward(req, resp);

	}

}
