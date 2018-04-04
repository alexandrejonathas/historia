package br.edu.adtalem.lds.historia.controller.actions;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Pintura;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class CadastrarPintura implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
			
		String nome = req.getParameter("nome");
		String autor = req.getParameter("autor");
		Integer ano = Integer.valueOf(req.getParameter("ano"));
		String valor = req.getParameter("valor");		
		
		Pintura arte = new Pintura();
		
		arte.setNome(nome);
		arte.setAutor(autor);
		arte.setAno(ano);
		arte.setValor(valor == null ? BigDecimal.ZERO : new BigDecimal(valor));

		db.addPintura(arte);
		
		arte = new Pintura();
		req.setAttribute("pintura", arte);
		req.setAttribute("msg", "Operação realizada com sucesso!");
		return "/view/pinturas/cadastrar.jsp";	
	}

}
