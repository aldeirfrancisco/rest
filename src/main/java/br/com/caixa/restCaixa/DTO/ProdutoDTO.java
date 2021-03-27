package br.com.caixa.restCaixa.DTO;

import br.com.caixa.restCaixa.modelo.Produto;
import br.com.caixa.restCaixa.modelo.Tamanho;

import java.util.List;

import br.com.caixa.restCaixa.Enum.Categoria;


public class ProdutoDTO {
    
	  private Long id;
	  private Integer codigo;
	  private String nome;
	 
	
	  public ProdutoDTO() {
		  
	  }
	
	public ProdutoDTO(Produto pro) {
		
		this.id = pro.getId();
		this.codigo = pro.getCodigo();
		this.nome = pro.getNome();
		
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

		
}
