package br.edu.adtalem.lds.historia.controller.heroi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Heroi;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

@WebServlet("/herois/manutencao")
public class ManutencaoHeroi extends HttpServlet {

	private static final long serialVersionUID = 1L;

	StaticDB db = StaticDB.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("id");
		Heroi pessoa = null;
		if(param != null)
			pessoa = (Heroi) db.getHeroi(Long.valueOf(param));
		else
			pessoa = new Heroi();
		req.setAttribute("heroi", pessoa);
		RequestDispatcher rd = req.getRequestDispatcher("/view/herois/manutencao.jsp");
		rd.forward(req, resp);		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idRequest = req.getParameter("id");
		
		Long id = null;
		
		if(idRequest != null && !idRequest.isEmpty())
			id = Long.valueOf(idRequest);
		
		String nome = req.getParameter("nome");
		String conhecidoPor = req.getParameter("conhecidoPor");
		String habilidade = req.getParameter("habilidade");
				
		Heroi heroi = null;
		if(id == null) 
			heroi = new Heroi();
		else
			heroi = (Heroi) db.getHeroi(id);
		
		heroi.setNome(nome);
		heroi.setConhecidoPor(conhecidoPor);
		heroi.setHabilidade(habilidade);
		
		
		if(id == null)
			db.addHeroi(heroi);

		req.setAttribute("heroi", heroi);
		req.setAttribute("msg", "Operação realizada com sucesso!");
		RequestDispatcher rd = req.getRequestDispatcher("/view/herois/manutencao.jsp");
		rd.forward(req, resp);		
		
	}
	
}