package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Heroi;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class EditarHeroi implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		Heroi pessoa = null;
		String msg = null;
		boolean achou = true;
		if(id != null) {
			pessoa = (Heroi) db.getHeroi(Long.valueOf(id));
		}
		else {
			pessoa = new Heroi();
			achou = false;
			msg = "Não foi possivel realizar a ação de edição, tente cadastrar um novo registro!";
		}
		req.setAttribute("achou", achou);
		req.setAttribute("heroi", pessoa);
		req.setAttribute("msg", msg);
		return "/view/herois/editar.jsp";
	}

}
