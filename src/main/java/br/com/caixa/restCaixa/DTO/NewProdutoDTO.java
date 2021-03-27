package br.com.caixa.restCaixa.DTO;

import java.io.Serializable;

import br.com.caixa.restCaixa.Enum.Categoria;

public class NewProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	  private Long id;
	  private Integer codigo;
	  private String nome;
	  private Categoria  categoria;
	  private String tamanho;
	  private Double preco;
	
	public NewProdutoDTO() {
	
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

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	

}
