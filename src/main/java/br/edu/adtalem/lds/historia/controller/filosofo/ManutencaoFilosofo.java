package br.edu.adtalem.lds.historia.controller.filosofo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Filosofo;
import br.edu.adtalem.lds.historia.model.Pessoa;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

@WebServlet("/filosofos/manutencao")
public class ManutencaoFilosofo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	StaticDB db = StaticDB.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("id");
		Filosofo pessoa = null;
		if(param != null)
			pessoa = (Filosofo) db.getFilosofo(Long.valueOf(param));
		else
			pessoa = new Filosofo();
		req.setAttribute("filosofo", pessoa);
		RequestDispatcher rd = req.getRequestDispatcher("/view/filosofos/manutencao.jsp");
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
		Integer nascimento = Integer.valueOf(req.getParameter("nascimento"));
		Integer morte = Integer.valueOf(req.getParameter("morte"));
		String caracteristica = req.getParameter("caracteristica");
				
		Filosofo filosofo = null;
		if(id == null) 
			filosofo = new Filosofo();
		else
			filosofo = (Filosofo) db.getFilosofo(id);
		
		filosofo.setNome(nome);
		filosofo.setConhecidoPor(conhecidoPor);
		filosofo.setNascimento(nascimento);
		filosofo.setMorte(morte);
		filosofo.setCaracteristica(caracteristica);
		
		if(id == null)
			db.addFilosofo(filosofo);

		req.setAttribute("filosofo", filosofo);
		req.setAttribute("msg", "Operação realizada com sucesso!");
		RequestDispatcher rd = req.getRequestDispatcher("/view/filosofos/manutencao.jsp");
		rd.forward(req, resp);		
		
	}
	
}
