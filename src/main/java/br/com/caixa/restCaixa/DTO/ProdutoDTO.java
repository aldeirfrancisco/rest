package br.com.caixa.restCaixa.DTO;

import br.com.caixa.restCaixa.Enum.Categoria;
import br.com.caixa.restCaixa.Enum.Tamanho;
import br.com.caixa.restCaixa.modelo.Preco;
import br.com.caixa.restCaixa.modelo.Produto;

public class ProdutoDTO {
    
	  
	  private Integer codigo;
	  private String nome;
	  private Preco preco;
	  private Categoria categoria;
	  private Tamanho tamanho;
	
	/**
	 * @param codigo
	 * @param nome
	 * @param preco
	 * @param categoria
	 */
	public ProdutoDTO(Produto pro) {
		super();
		this.codigo = pro.getCodigo();
		this.nome = pro.getNome();
		this.preco = pro.getPreco();
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
	public Preco getPreco() {
		return preco;
	}
	public void setPreco(Preco preco) {
		this.preco = preco;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
    public Tamanho getTamanho() {
		return tamanho;
	}
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}  
		
}
