package br.com.caixa.restCaixa.DTO;

import br.com.caixa.restCaixa.modelo.Produto;
import br.com.caixa.restCaixa.modelo.Tamanho;

import java.util.List;

import br.com.caixa.restCaixa.Enum.Categoria;


public class ProdutoDTO {
    
	  
	  private Integer codigo;
	  private String nome;
	  private Categoria categoria;
	  private List<Tamanho> tamanho;
	
	  public ProdutoDTO() {
		  
	  }
	
	public ProdutoDTO(Produto pro) {
		super();
		this.codigo = pro.getCodigo();
		this.nome = pro.getNome();
		this.categoria = pro.getCategoria();
		this.tamanho = pro.getTamanho();
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
    public List<Tamanho> getTamanho() {
		return tamanho;
	}
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = (List<Tamanho>) tamanho;
	}  
		
}
