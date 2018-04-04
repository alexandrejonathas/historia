package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Pintura;

public class NovaPintura implements IAction {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		Pintura arte = new Pintura();
		req.setAttribute("pintura", arte);
		return "/view/pinturas/cadastrar.jsp";
	}

}
