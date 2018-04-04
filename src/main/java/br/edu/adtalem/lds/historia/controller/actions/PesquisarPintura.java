package br.edu.adtalem.lds.historia.controller.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Arte;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class PesquisarPintura implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String nome  = req.getParameter("nome");
		
		List<Arte> pinturas = db.getPinturas(nome);
		req.setAttribute("pinturas", pinturas);
		
		req.setAttribute("msg", "Pesquisa concluída!");		
		return "/view/pinturas/listar.jsp";
	}

}
