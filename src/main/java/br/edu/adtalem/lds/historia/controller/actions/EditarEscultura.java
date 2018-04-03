package br.edu.adtalem.lds.historia.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.model.Arte;
import br.edu.adtalem.lds.historia.model.Escultura;
import br.edu.adtalem.lds.historia.model.data.StaticDB;

public class EditarEscultura implements IAction {

	private StaticDB db = StaticDB.getInstance();
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String param = req.getParameter("id");
		Arte arte = null;
		String pagina = "";
		String msg = null;
		if(param != null) {
			arte = db.getEscultura(Long.valueOf(param));
			pagina = "editar.jsp";
		}
		else {
			arte = new Escultura();
			pagina = "cadastrar.jsp";
			msg = "Não foi possivel realizar a ação de edição, tente cadastrar um novo registro!";
		}
		req.setAttribute("escultura", arte);
		req.setAttribute("msg", msg);
		return "/view/esculturas/"+pagina;	
	}

}
