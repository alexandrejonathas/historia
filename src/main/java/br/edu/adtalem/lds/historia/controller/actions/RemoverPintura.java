package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Arte;
import br.edu.adtalem.lds.historia.model.Pintura;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class RemoverPintura implements IAction {
	
	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String idRequest = req.getParameter("id");

		Long id = Long.valueOf(idRequest);
		Arte arte = (Pintura) db.getPintura(id);
		db.removePintura(arte);

		req.setAttribute("msg", "Operação realizada com sucesso!");		
		req.setAttribute("pinturas", db.getPinturas(null));
		return "/view/pinturas/listar.jsp";
		
	}

}
