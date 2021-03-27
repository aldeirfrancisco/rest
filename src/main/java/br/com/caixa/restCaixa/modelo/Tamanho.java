package br.com.caixa.restCaixa.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tamanho implements Serializable {
	 private static final long serialVersionUID = 1L;
	 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)	
  private Long id;
  private String tamanho;
 
  @OneToOne(cascade = CascadeType.ALL)
  private Preco preco;
    @JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
  private Produto produto;
  public Tamanho() {
  }

public Tamanho(Long id, String tamanho, Preco preco, Produto produto) {
	super();
	this.id = id;
	this.tamanho = tamanho;
	this.preco = preco;
	this.produto = produto;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTamanho() {
	return tamanho;
}

public void setTamanho(String tamanho) {
	this.tamanho = tamanho;
}

public Preco getPreco() {
	return preco;
}

public void setPreco(Preco preco) {
	this.preco = preco;
}
public Produto getProduto() {
	return produto;
}
public void setProduto(Produto produto) {
	this.produto = produto;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Tamanho other = (Tamanho) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

  		
}