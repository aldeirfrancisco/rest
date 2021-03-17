package br.com.caixa.restCaixa.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import br.com.caixa.restCaixa.Enum.Categoria;

@Entity
public class Produto implements Serializable {
 
	private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue	
  private Long id;
  private Integer codigo;
  private String nome;
  @Enumerated(EnumType.STRING)
  private Categoria categoria;
  @ManyToMany
  @JoinTable(name = "PRODUTO_TAMANHO",
  joinColumns = @JoinColumn(name="produto_id"),
  inverseJoinColumns = @JoinColumn(name = "tamanho_id"))
  private List<Tamanho> tamanho = new ArrayList<>();

	
  public Produto() {
	  
  }

public Produto(Long id, String nome, Integer codigo, Categoria categoria) {
	this.id = id;
	this.codigo = codigo;
	this.nome = nome;
	this.categoria = categoria;
}
	

	public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public Integer getCodigo() {
	return codigo;
}


public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public List<Tamanho> getTamanho() {
	return tamanho;
}
public void setTamanho(List<Tamanho> tamanho) {
	this.tamanho = tamanho;
}


public Categoria getCategoria() {
	return categoria;
}


public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
  
   
 
}