package br.edu.adtalem.lds.historia.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.adtalem.lds.historia.model.Pintura;
import br.edu.adtalem.lds.historia.repository.PinturaRepository;
import br.edu.adtalem.lds.historia.repository.filter.ArteFilter;
import br.edu.adtalem.lds.historia.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PinturaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Pintura> pinturas;
	private Pintura pintura;
	private ArteFilter filter;
	
	@Inject
	private PinturaRepository repository;

	@PostConstruct
	public void init() {
		pintura = new Pintura();
		filter = new ArteFilter();
		pinturas = repository.lista(filter);
	}
	
	public void salvar() {
		pintura = repository.salvar(pintura);
		boolean existe = false;
		for(Pintura p : pinturas) {
			if(p.getId() == pintura.getId()) {
				existe = true;
				break;
			}
		}
		if(!existe) {			
			pinturas.add(pintura);
		}
		FacesUtil.addInfoMessage("Operação realizada com suceso!");
		pintura = new Pintura();
	}
	
	public void remover() {
		try {
			repository.remover(pintura);
			pinturas.remove(pintura);
			FacesUtil.addInfoMessage("Operação realizada com sucesso!");
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public List<Pintura> getPinturas() {
		return pinturas;
	}

	public void setPinturas(List<Pintura> pinturas) {
		this.pinturas = pinturas;
	}

	public Pintura getPintura() {
		return pintura;
	}

	public void setPintura(Pintura pintura) {
		this.pintura = pintura;
	}

	public ArteFilter getFilter() {
		return filter;
	}

	public void setFilter(ArteFilter filter) {
		this.filter = filter;
	}
	
}
