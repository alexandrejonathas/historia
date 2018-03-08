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
import br.edu.adtalem.lds.historia.model.data.PinturaStatic;

@WebServlet("/pinturas/manutencao")
public class ManutencaoPintura extends HttpServlet {

	private static final long serialVersionUID = 1L;

	PinturaStatic db = PinturaStatic.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("id");
		Arte arte = null;
		if(param != null)
			arte = db.getArteVisual(Long.valueOf(param));
		else
			arte = new Pintura();
		req.setAttribute("pintura", arte);
		RequestDispatcher rd = req.getRequestDispatcher("/view/pinturas/manutencao.jsp");
		rd.forward(req, resp);		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idRequest = req.getParameter("id");
		
		Long id = null;
		
		if(idRequest != null && !idRequest.isEmpty())
			id = Long.valueOf(idRequest);
		
		String nome = req.getParameter("nome");
		String autor = req.getParameter("autor");
		Integer ano = Integer.valueOf(req.getParameter("ano"));
		
		Arte arte = null;
		if(id == null) 
			arte = new Pintura();
		else
			arte = db.getArteVisual(id);
		
		arte.setNome(nome);
		arte.setAutor(autor);
		arte.setAno(ano);
		
		if(id == null)
			db.add(arte);

		req.setAttribute("pintura", arte);
		req.setAttribute("msg", "Operação realizada com sucesso!");
		RequestDispatcher rd = req.getRequestDispatcher("/view/pinturas/manutencao.jsp");
		rd.forward(req, resp);		
		
	}
	
}
