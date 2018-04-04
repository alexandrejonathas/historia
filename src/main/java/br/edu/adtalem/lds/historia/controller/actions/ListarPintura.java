package br.edu.adtalem.lds.historia.controller.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Arte;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class ListarPintura implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
	
		List<Arte> pinturas = db.getPinturas(null);
		req.setAttribute("pinturas", pinturas);				

		return "/view/pinturas/listar.jsp";
	}

}
