package br.edu.adtalem.lds.historia.controller.helper;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import br.edu.adtalem.lds.historia.controller.actions.AlterarEscultura;
import br.edu.adtalem.lds.historia.controller.actions.CadastrarEscultura;
import br.edu.adtalem.lds.historia.controller.actions.EditarEscultura;
import br.edu.adtalem.lds.historia.controller.actions.IAction;
import br.edu.adtalem.lds.historia.controller.actions.ListarEscultura;
import br.edu.adtalem.lds.historia.controller.actions.NovaEscultura;
import br.edu.adtalem.lds.historia.controller.actions.RemoverEscultura;

public class Aplicacao {

	private Map<String, IAction> mapaComandos;
	private HttpServletRequest request;
	
	public Aplicacao(HttpServletRequest request) {
		
		this.request = request;
		
		mapaComandos = new HashMap<>();
		mapaComandos.put("ListarEscultura", new ListarEscultura());
		mapaComandos.put("NovaEscultura", new NovaEscultura());		
		mapaComandos.put("CadastrarEscultura", new CadastrarEscultura());
		mapaComandos.put("EditarEscultura", new EditarEscultura());
		mapaComandos.put("AlterarEscultura", new AlterarEscultura());
		mapaComandos.put("RemoverEscultura", new RemoverEscultura());		
	}
	
	public IAction getAction() {
		String action = request.getParameter("cmd");
		action = action == null || action.equals("") ? "ListarEscultura" : action;
		return mapaComandos.get(action);
	}
	
}
