package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Heroi;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class AlterarHeroi implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String idRequest = req.getParameter("id");
		
		Long id = Long.valueOf(idRequest);
		
		String nome = req.getParameter("nome");
		String conhecidoPor = req.getParameter("conhecidoPor");
		String habilidade = req.getParameter("habilidade");
		String caracteristica = req.getParameter("caracteristica");
				
		Heroi heroi = (Heroi) db.getHeroi(id);
		
		heroi.setNome(nome);
		heroi.setConhecidoPor(conhecidoPor);
		heroi.setHabilidade(habilidade);
		heroi.setCaracteristica(caracteristica);

		req.setAttribute("heroi", heroi);
		req.setAttribute("msg", "Operação realizada com sucesso!");	
		return "/view/herois/editar.jsp";
	}

}
