package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Escultura;

public class NovaEscultura implements IAction {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		Escultura arte = new Escultura();
		req.setAttribute("escultura", arte);
		return "/view/esculturas/cadastrar.jsp";
	}

}
