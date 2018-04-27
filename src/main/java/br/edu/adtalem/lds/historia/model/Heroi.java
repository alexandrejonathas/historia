package br.edu.adtalem.lds.historia.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("HEROI")
public class Heroi extends Pessoa {

	private String habilidade;

	public String getHabilidade() {
		return habilidade;

	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}
}

