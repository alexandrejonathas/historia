package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Filosofo;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class AlterarFilosofo implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String idRequest = req.getParameter("id");
		
		Long id = Long.valueOf(idRequest);
		
		String nome = req.getParameter("nome");
		String conhecidoPor = req.getParameter("conhecidoPor");
		Integer nascimento = Integer.valueOf(req.getParameter("nascimento"));
		Integer morte = Integer.valueOf(req.getParameter("morte"));
		String caracteristica = req.getParameter("caracteristica");
				
		Filosofo filosofo = (Filosofo) db.getFilosofo(id);
		
		filosofo.setNome(nome);
		filosofo.setConhecidoPor(conhecidoPor);
		filosofo.setNascimento(nascimento);
		filosofo.setMorte(morte);
		filosofo.setCaracteristica(caracteristica);

		req.setAttribute("filosofo", filosofo);
		req.setAttribute("msg", "Operação realizada com sucesso!");
		return "/view/filosofos/editar.jsp";	
	}

}
