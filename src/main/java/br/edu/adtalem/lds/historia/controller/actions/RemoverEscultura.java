package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Arte;
import br.edu.adtalem.lds.historia.model.Escultura;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class RemoverEscultura implements IAction {
	
	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String idRequest = req.getParameter("id");

		Long id = Long.valueOf(idRequest);
		Arte arte = (Escultura) db.getEscultura(id);
		db.removeEscultura(arte);

		req.setAttribute("msg", "Operação realizada com sucesso!");		
		req.setAttribute("esculturas", db.getEsculturas());
		return "/view/esculturas/lista.jsp";
		
	}

}
