package br.edu.adtalem.lds.historia.repository.filter;

public class PessoaFilter {
	private String nome;
	private String conhecidoPor;
	private String caracteristica;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getConhecidoPor() {
		return conhecidoPor;
	}

	public void setConhecidoPor(String conhecidoPor) {
		this.conhecidoPor = conhecidoPor;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

}
