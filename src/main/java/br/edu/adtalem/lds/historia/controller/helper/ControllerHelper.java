package br.edu.adtalem.lds.historia.controller.helper;

import javax.servlet.http.HttpServletRequest;

import br.edu.adtalem.lds.historia.controller.actions.IAction;

public class ControllerHelper {

	private HttpServletRequest request;
	
	public ControllerHelper(HttpServletRequest request) {
		this.request = request;	
	}
	
	public IAction getAction() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		String cmd = request.getParameter("cmd");		
		cmd = cmd == null || cmd.equals("") ? "ListarEscultura" : cmd;
		
		String className = String.format("br.edu.adtalem.lds.historia.controller.actions.%s", cmd);
		
		Class<?> classe = Class.forName(className);
		
		IAction action = (IAction) classe.newInstance();
		
		return action;
	}
	
}
