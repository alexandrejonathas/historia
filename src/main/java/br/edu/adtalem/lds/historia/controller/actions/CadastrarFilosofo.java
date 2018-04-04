package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Filosofo;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class CadastrarFilosofo  implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp){
				
		String nome = req.getParameter("nome");
		String conhecidoPor = req.getParameter("conhecidoPor");
		Integer nascimento = Integer.valueOf(req.getParameter("nascimento"));
		Integer morte = Integer.valueOf(req.getParameter("morte"));
		String caracteristica = req.getParameter("caracteristica");
				
		Filosofo filosofo = new Filosofo();
		
		filosofo.setNome(nome);
		filosofo.setConhecidoPor(conhecidoPor);
		filosofo.setNascimento(nascimento);
		filosofo.setMorte(morte);
		filosofo.setCaracteristica(caracteristica);
		
		db.addFilosofo(filosofo);

		filosofo = new Filosofo();
		req.setAttribute("filosofo", filosofo);
		req.setAttribute("msg", "Operação realizada com sucesso!");
		return "/view/filosofos/cadastrar.jsp";	
	}
		

}
