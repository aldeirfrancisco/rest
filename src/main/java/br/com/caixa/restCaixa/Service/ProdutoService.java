package br.com.caixa.restCaixa.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.validator.constraints.Mod11Check.ProcessingDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caixa.restCaixa.DTO.NewProdutoDTO;
import br.com.caixa.restCaixa.DTO.ProdutoDTO;
import br.com.caixa.restCaixa.Enum.Categoria;
import br.com.caixa.restCaixa.excecao.ObjectoNotFoundException;
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
		prod.setId(null);
		prod = repProduto.save(prod);
		repTamanho.saveAll(prod.getTamanho());
	
	return  prod;
	}
	
	
	public List<Produto> buscarDTO(Integer codigo) {
		return repProduto.findByCodigo(codigo);
	}
	public  Produto buscarProduto(Long id)  {
		
		 Optional<Produto> pro = repProduto.findById(id);
			return pro.orElseThrow(() -> new ObjectoNotFoundException(
					"Objeto não encontrado! Id: " + id + ",tipo: "+ Produto.class));
		
	}
	public Produto fromDTO(ProdutoDTO pro) {
		return new Produto(pro.getId(),pro.getNome(),pro.getCodigo(),null);
	}

	public Produto salvarProdutoDTO(NewProdutoDTO prodDTO) {
		
		Produto produto = new Produto( null ,prodDTO.getNome(),prodDTO.getCodigo(),prodDTO.getCategoria());
		Preco preco = new Preco(null,prodDTO.getPreco());
		Tamanho tamanho = new Tamanho(null,prodDTO.getTamanho(), preco,produto);
		produto.getTamanho().add(tamanho);
		tamanho.setPreco(preco);
		
	 return produto;
	}
	public void deletar (Long id) {
	  repProduto.deleteById(id);
	}
	
	public void atualizar(Produto pro) {
		Produto prod = buscarProduto(pro.getId());
		atualizarDados(prod, pro);
		repProduto.save(prod);
		
	}
	public void atualizarDados(Produto pro, Produto prodDTO) {
		 pro.setCodigo(prodDTO.getCodigo());
		pro.setCodigo(prodDTO.getCodigo());
		pro.setNome(prodDTO.getNome());
		
		
	}

}
