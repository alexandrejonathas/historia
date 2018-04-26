package br.edu.adtalem.lds.historia.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PINTURA")
public class Pintura extends Arte {

	private static final long serialVersionUID = 1812735513868525028L;
	
	private BigDecimal valor;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
