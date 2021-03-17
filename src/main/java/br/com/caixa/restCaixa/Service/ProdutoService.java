package br.com.caixa.restCaixa.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caixa.restCaixa.DTO.NewProdutoDTO;
import br.com.caixa.restCaixa.modelo.Preco;
import br.com.caixa.restCaixa.modelo.Produto;
import br.com.caixa.restCaixa.modelo.Tamanho;
import br.com.caixa.restCaixa.repository.RepositoryPreco;
import br.com.caixa.restCaixa.repository.RepositoryProduto;
import br.com.caixa.restCaixa.repository.RepositoryTamanho;
@Service
public class ProdutoService {
	@Autowired
	RepositoryProduto repProduto;
	@Autowired
	RepositoryPreco repPreco;	
	@Autowired
	RepositoryTamanho repTamanho;
	@Transactional
	public Produto inserir(Produto prod) {
		prod = repProduto.save(prod);
		repTamanho.saveAll(prod.getTamanho());
	
	return  prod;
	}
	
	
	public List<Produto> buscarDTO(Integer codigo) {
		return repProduto.findByCodigo(codigo);
	}
	
	public Produto salvarProdutoDTO(NewProdutoDTO prodDTO) {
		Preco preco = new Preco(null,prodDTO.getPreco());
		Tamanho tamanho = new Tamanho(null,prodDTO.getTamanho(), preco);
		Produto produto = new Produto(null,prodDTO.getNome(),prodDTO.getCodigo(),prodDTO.getCategoria());
		produto.getTamanho().add(tamanho);
		tamanho.setPreco(preco);
	 return produto;
	}
	
}
