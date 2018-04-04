package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Heroi;

public class NovoHeroi implements IAction {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		Heroi pessoa = new Heroi();
		req.setAttribute("heroi", pessoa);
		return "/view/herois/cadastrar.jsp";	
	}

}
