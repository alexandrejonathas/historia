package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Pessoa;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class RemoverHeroi implements IAction {
	
	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String idRequest = req.getParameter("id");

		Long id = Long.valueOf(idRequest);
		Pessoa pessoa = (Pessoa) db.getHeroi(id);
		db.removerHeroi(pessoa);

		req.setAttribute("msg", "Operação realizada com sucesso!");		
		req.setAttribute("herois", db.getHerois(null));
		return "/view/herois/listar.jsp";
	}

}
