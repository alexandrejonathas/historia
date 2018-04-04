package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Filosofo;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class EditarFilosofo implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		Filosofo pessoa = null;
		String msg = null;
		boolean achou = true;
		if(id != null) {
			pessoa = (Filosofo) db.getFilosofo(Long.valueOf(id));
		}
		else {
			pessoa = new Filosofo();
			achou = false;
			msg = "Não foi possivel realizar a ação de edição, tente cadastrar um novo registro!";
		}
		req.setAttribute("achou", achou);
		req.setAttribute("filosofo", pessoa);
		req.setAttribute("msg", msg);
		return "/view/filosofos/editar.jsp";
	}

}
