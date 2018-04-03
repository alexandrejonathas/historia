package br.edu.adtalem.lds.historia.controller.filosofo;

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

@WebServlet("/filosofos")
public class ListaFilosofos extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	StaticDB db = StaticDB.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Pessoa> filosofos = db.getFilosofos();
		req.setAttribute("filosofos", filosofos);

		String msg = (String)req.getSession().getAttribute("msg");
		req.setAttribute("msg", msg);
		req.getSession().removeAttribute("msg");		
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/filosofos/lista.jsp");
		rd.forward(req, resp);

	}

}
