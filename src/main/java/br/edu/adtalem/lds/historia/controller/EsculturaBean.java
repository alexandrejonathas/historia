package br.edu.adtalem.lds.historia.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.adtalem.lds.historia.model.Escultura;
import br.edu.adtalem.lds.historia.repository.EsculturaRepository;
import br.edu.adtalem.lds.historia.repository.filter.ArteFilter;
import br.edu.adtalem.lds.historia.util.jsf.FacesUtil;

@Named
@ViewScoped
public class EsculturaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Escultura> esculturas;
	private Escultura escultura;
	private ArteFilter filter;
	
	@Inject
	private EsculturaRepository repository;

	@PostConstruct
	public void init() {
		escultura = new Escultura();
		filter = new ArteFilter();
		esculturas = repository.lista(filter);
	}
	
	public void salvar() {
		escultura = repository.salvar(escultura);
		boolean existe = false;
		for(Escultura p : esculturas) {
			if(p.getId() == escultura.getId()) {
				existe = true;
				break;
			}
		}
		if(!existe) {			
			esculturas.add(escultura);
		}
		FacesUtil.addInfoMessage("Operação realizada com suceso!");
		escultura = new Escultura();
	}
	
	public void remover() {
		try {
			repository.remover(escultura);
			esculturas.remove(escultura);
			FacesUtil.addInfoMessage("Operação realizada com sucesso!");
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public List<Escultura> getEsculturas() {
		return esculturas;
	}

	public void setEsculturas(List<Escultura> esculturas) {
		this.esculturas = esculturas;
	}

	public Escultura getEscultura() {
		return escultura;
	}

	public void setEscultura(Escultura escultura) {
		this.escultura = escultura;
	}

	public ArteFilter getFilter() {
		return filter;
	}

	public void setFilter(ArteFilter filter) {
		this.filter = filter;
	}
	
}
