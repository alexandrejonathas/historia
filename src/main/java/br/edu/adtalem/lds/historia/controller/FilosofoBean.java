package br.edu.adtalem.lds.historia.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.adtalem.lds.historia.model.Filosofo;
import br.edu.adtalem.lds.historia.repository.FilosofoRepository;
import br.edu.adtalem.lds.historia.repository.filter.PessoaFilter;
import br.edu.adtalem.lds.historia.util.jsf.FacesUtil;

@Named
@ViewScoped
public class FilosofoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Filosofo> filosofos;
	private Filosofo filosofo;
	private PessoaFilter filter;
	
	@Inject
	private FilosofoRepository repository;

	@PostConstruct
	public void init() {
		filosofo = new Filosofo();
		filter = new PessoaFilter();
		filosofos = repository.lista(filter);
	}
	
	public void salvar() {
		filosofo = repository.salvar(filosofo);
		boolean existe = false;
		for(Filosofo p : filosofos) {
			if(p.getId() == filosofo.getId()) {
				existe = true;
				break;
			}
		}
		if(!existe) {			
			filosofos.add(filosofo);
		}
		FacesUtil.addInfoMessage("Operação realizada com suceso!");
		filosofo = new Filosofo();
	}
	
	public void remover() {
		try {
			repository.remover(filosofo);
			filosofos.remove(filosofo);
			FacesUtil.addInfoMessage("Operação realizada com sucesso!");
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public List<Filosofo> getFilosofos() {
		return filosofos;
	}

	public void setFilosofos(List<Filosofo> filosofos) {
		this.filosofos = filosofos;
	}

	public Filosofo getFilosofo() {
		return filosofo;
	}

	public void setFilosofo(Filosofo filosofo) {
		this.filosofo = filosofo;
	}

	public PessoaFilter getFilter() {
		return filter;
	}

	public void setFilter(PessoaFilter filter) {
		this.filter = filter;
	}
	
}
