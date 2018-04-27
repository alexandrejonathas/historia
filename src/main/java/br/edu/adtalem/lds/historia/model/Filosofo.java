package br.edu.adtalem.lds.historia.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FILOSOFO")
public class Filosofo extends Pessoa {

	private int nascimento;
	private int morte;

	public int getNascimento() {
		return nascimento;
	}

	public void setNascimento(int nascimento) {
		this.nascimento = nascimento;
	}

	public int getMorte() {
		return morte;
	}

	public void setMorte(int morte) {
		this.morte = morte;
	}

}
