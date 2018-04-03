package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Escultura;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class AlterarEscultura implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		
		String idRequest = req.getParameter("id");
		
		Long id = null;
		
		if(idRequest != null && !idRequest.isEmpty())
			id = Long.valueOf(idRequest);
		
		String nome = req.getParameter("nome");
		String autor = req.getParameter("autor");
		Integer ano = Integer.valueOf(req.getParameter("ano"));

		String longitude = req.getParameter("longitude");
		String latitude = req.getParameter("latitude");
		
		Escultura arte = (Escultura) db.getEscultura(id);		
		
		arte.setNome(nome);
		arte.setAutor(autor);
		arte.setAno(ano);

		arte.setLongitude(longitude == null ? 0 : Double.valueOf(longitude));
		arte.setLatitude(latitude == null ? 0 : Double.valueOf(latitude));

		req.setAttribute("escultura", arte);
		req.setAttribute("msg", "Operação realizada com sucesso!");
		return "/view/esculturas/editar.jsp";
	}

}
