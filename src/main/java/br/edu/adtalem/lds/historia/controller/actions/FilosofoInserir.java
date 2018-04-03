package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.controller.Action;
import br.edu.adtalem.lds.historia.model.Filosofo;

public class FilosofoInserir  implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Filosofo f = new Filosofo();
		f.setNascimento(Integer.parseInt(request.getParameter("nascimento")));
	
		
		
		
		
		
		
		
		return null;
	}
		

}
