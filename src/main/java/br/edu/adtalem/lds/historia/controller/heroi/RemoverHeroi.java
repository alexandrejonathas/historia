package br.edu.adtalem.lds.historia.controller.heroi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Heroi;
import br.edu.adtalem.lds.historia.model.Pessoa;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

@WebServlet("/herois/remover")
public class RemoverHeroi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StaticDB db = StaticDB.getInstance();
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("id");
		Pessoa pessoa = db.getHeroi(Long.valueOf(param));
		req.setAttribute("heroi", pessoa);
		RequestDispatcher rd = req.getRequestDispatcher("/view/herois/remover.jsp");
		rd.forward(req, resp);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idRequest = req.getParameter("id");		
		String path = null;
		
		if(idRequest != null && !idRequest.isEmpty()) {

			Long id = Long.valueOf(idRequest);
			Pessoa pessoa = (Heroi) db.getHeroi(id);
			db.removerHeroi(pessoa);
			
			path = req.getContextPath()+"/herois";

			req.getSession().setAttribute("msg", "Operação realizada com sucesso!");
			resp.sendRedirect(path);
		
		}else {			
			
			req.setAttribute("msg", "Não foi possivel realizar a operação!");
			path = "/herois/manutencao?id="+idRequest;
			RequestDispatcher rd = req.getRequestDispatcher(path);
			rd.forward(req, resp);
			
		}
		
	}
}
