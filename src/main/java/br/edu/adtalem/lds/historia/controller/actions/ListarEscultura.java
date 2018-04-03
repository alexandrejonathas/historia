package br.edu.adtalem.lds.historia.controller.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Arte;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class ListarEscultura implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		List<Arte> esculturas = db.getEsculturas();
		req.setAttribute("esculturas", esculturas);
		
		String msg = (String)req.getSession().getAttribute("msg");
		req.setAttribute("msg", msg);
		req.getSession().removeAttribute("msg");
		
		return "/view/esculturas/lista.jsp";
		
	}

}
