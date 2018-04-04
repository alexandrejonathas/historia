package br.edu.adtalem.lds.historia.controller.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Pessoa;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class PesquisarFilosofo implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String nome  = req.getParameter("nome");
		List<Pessoa> filosofos = (List<Pessoa>) db.getFilosofos(nome);
		req.setAttribute("filosofos", filosofos);		
		
		return "/view/filosofos/listar.jsp";
	}

}
