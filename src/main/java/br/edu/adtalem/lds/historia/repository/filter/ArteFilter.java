package br.edu.adtalem.lds.historia.repository.filter;

import java.io.Serializable;

public class ArteFilter implements Serializable {

	private static final long serialVersionUID = 9018365953110248417L;

	private String nome;
	private String autor;
	private Integer ano;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

}
