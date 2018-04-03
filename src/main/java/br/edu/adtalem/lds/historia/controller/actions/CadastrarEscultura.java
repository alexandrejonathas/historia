package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Escultura;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class CadastrarEscultura implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		String nome = req.getParameter("nome");
		String autor = req.getParameter("autor");
		Integer ano = Integer.valueOf(req.getParameter("ano"));

		String longitude = req.getParameter("longitude");
		String latitude = req.getParameter("latitude");
		

		Escultura arte = new Escultura();
		
		arte.setNome(nome);
		arte.setAutor(autor);
		arte.setAno(ano);

		arte.setLongitude(longitude == null ? 0 : Double.valueOf(longitude));
		arte.setLatitude(latitude == null ? 0 : Double.valueOf(latitude));

	
		db.addEscultura(arte);

		arte = new Escultura();
		req.setAttribute("msg", "Operação realizada com sucesso!");
		
		return "/view/esculturas/cadastrar.jsp";
		
	}

}
