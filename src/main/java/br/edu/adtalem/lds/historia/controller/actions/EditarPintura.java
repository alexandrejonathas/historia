package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Arte;
import br.edu.adtalem.lds.historia.model.Escultura;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class EditarPintura implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		Arte arte = null;
		String msg = null;
		boolean achou = true;
		if(id != null) {
			arte = db.getPintura(Long.valueOf(id));
		}
		else {
			arte = new Escultura();
			achou = false;
			msg = "Não foi possivel realizar a ação de edição, tente cadastrar um novo registro!";
		}
		req.setAttribute("achou", achou);
		req.setAttribute("pintura", arte);
		req.setAttribute("msg", msg);
		return "/view/pinturas/editar.jsp";	
	}

}
