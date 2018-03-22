package br.edu.adtalem.lds.historia.controller.pintura;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Arte;
import br.edu.adtalem.lds.historia.model.Pintura;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

@WebServlet("/pinturas/remover")
public class RemoverPintura extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("id");
		Arte pintura = db.getPintura(Long.valueOf(param));
		req.setAttribute("pintura", pintura);
		RequestDispatcher rd = req.getRequestDispatcher("/view/pinturas/remover.jsp");
		rd.forward(req, resp);			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idRequest = req.getParameter("id");		
		String path = null;
		
		if(idRequest != null && !idRequest.isEmpty()) {

			Long id = Long.valueOf(idRequest);
			Arte arte = (Pintura) db.getPintura(id);
			db.removePintura(arte);
			
			path = req.getContextPath()+"/pinturas";

			req.getSession().setAttribute("msg", "Operação realizada com sucesso!");
			resp.sendRedirect(path);
		
		}else {			
			
			req.setAttribute("msg", "Não foi possivel realizar a operação!");
			path = "/pintras/manutencao?id="+idRequest;
			RequestDispatcher rd = req.getRequestDispatcher(path);
			rd.forward(req, resp);
			
		}
		
	}
	
}
