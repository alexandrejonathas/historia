package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Filosofo;

public class NovoFilosofo implements IAction {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		Filosofo pessoa = new Filosofo();
		req.setAttribute("filosofo", pessoa);
		return "/view/filosofos/cadastrar.jsp";	
	}

}
