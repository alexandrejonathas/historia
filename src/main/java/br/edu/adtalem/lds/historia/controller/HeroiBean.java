package br.edu.adtalem.lds.historia.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.adtalem.lds.historia.model.Heroi;
import br.edu.adtalem.lds.historia.repository.HeroiRepository;
import br.edu.adtalem.lds.historia.repository.filter.PessoaFilter;
import br.edu.adtalem.lds.historia.util.jsf.FacesUtil;

@Named
@ViewScoped
public class HeroiBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Heroi> herois;
	private Heroi heroi;
	private PessoaFilter filter;
	
	@Inject
	private HeroiRepository repository;

	@PostConstruct
	public void init() {
		heroi = new Heroi();
		filter = new PessoaFilter();
		herois = repository.lista(filter);
	}
	
	public void salvar() {
		heroi = repository.salvar(heroi);
		boolean existe = false;
		for(Heroi p : herois) {
			if(p.getId() == heroi.getId()) {
				existe = true;
				break;
			}
		}
		if(!existe) {			
			herois.add(heroi);
		}
		FacesUtil.addInfoMessage("Operação realizada com suceso!");
		heroi = new Heroi();
	}
	
	public void remover() {
		try {
			repository.remover(heroi);
			herois.remove(heroi);
			FacesUtil.addInfoMessage("Operação realizada com sucesso!");
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public List<Heroi> getHerois() {
		return herois;
	}

	public void setHerois(List<Heroi> herois) {
		this.herois = herois;
	}

	public Heroi getHeroi() {
		return heroi;
	}

	public void setHeroi(Heroi heroi) {
		this.heroi = heroi;
	}

	public PessoaFilter getFilter() {
		return filter;
	}

	public void setFilter(PessoaFilter filter) {
		this.filter = filter;
	}
	
}
