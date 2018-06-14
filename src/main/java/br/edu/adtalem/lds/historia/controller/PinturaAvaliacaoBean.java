package br.edu.adtalem.lds.historia.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.adtalem.lds.historia.model.Pintura;
import br.edu.adtalem.lds.historia.repository.PinturaRepository;

@Named
@ViewScoped
public class PinturaAvaliacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PinturaRepository repository;

	private List<Pintura> pinturas;		
	
	@PostConstruct
	public void init() {
		pinturas = repository.listaOrdenadaPorMaiorValor();
	}

	public List<Pintura> getPinturas() {
		return pinturas;
	}	
	
}
