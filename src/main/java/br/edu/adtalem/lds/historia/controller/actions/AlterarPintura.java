package br.edu.adtalem.lds.historia.controller.actions;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Pintura;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class AlterarPintura implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String idRequest = req.getParameter("id");
		
		Long id = Long.valueOf(idRequest);
		
		String nome = req.getParameter("nome");
		String autor = req.getParameter("autor");
		Integer ano = Integer.valueOf(req.getParameter("ano"));

		String valor = req.getParameter("valor");		
		
		Pintura arte = (Pintura) db.getPintura(id);
		
		arte.setNome(nome);
		arte.setAutor(autor);
		arte.setAno(ano);

		arte.setValor(valor == null ? BigDecimal.ZERO : new BigDecimal(valor));		

		req.setAttribute("pintura", arte);
		req.setAttribute("msg", "Operação realizada com sucesso!");
		return "/view/pinturas/editar.jsp";
	}

}
