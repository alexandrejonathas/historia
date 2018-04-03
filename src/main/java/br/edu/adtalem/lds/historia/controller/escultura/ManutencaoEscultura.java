package br.edu.adtalem.lds.historia.controller.escultura;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Arte;
import br.edu.adtalem.lds.historia.model.Escultura;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

@WebServlet("/esculturas/manutencao")
public class ManutencaoEscultura extends HttpServlet {

	private static final long serialVersionUID = 1L;

	StaticDB db = StaticDB.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("id");
		Arte arte = null;
		if(param != null)
			arte = db.getEscultura(Long.valueOf(param));
		else
			arte = new Escultura();
		req.setAttribute("escultura", arte);
		RequestDispatcher rd = req.getRequestDispatcher("/view/esculturas/manutencao.jsp");
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

		String longitude = req.getParameter("longitude");
		String latitude = req.getParameter("latitude");
		
		Escultura arte = null;
		if(id == null) 
			arte = new Escultura();
		else
			arte = (Escultura) db.getEscultura(id);		
		
		arte.setNome(nome);
		arte.setAutor(autor);
		arte.setAno(ano);

		arte.setLongitude(longitude == null ? 0 : Double.valueOf(longitude));
		arte.setLatitude(latitude == null ? 0 : Double.valueOf(latitude));

		
		if(id == null)
			db.addEscultura(arte);

		req.setAttribute("escultura", arte);
		req.setAttribute("msg", "Operação realizada com sucesso!");
		RequestDispatcher rd = req.getRequestDispatcher("/view/esculturas/manutencao.jsp");
		rd.forward(req, resp);		
		
	}
	
}
