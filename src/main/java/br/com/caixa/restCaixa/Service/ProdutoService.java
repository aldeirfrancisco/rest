package br.com.caixa.restCaixa.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caixa.restCaixa.DTO.NewProdutoDTO;
import br.com.caixa.restCaixa.DTO.ProdutoDTO;
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
	
	//public Categoria fromDTO(CategoriaDTO objDto) {
	//	return new Categoria(objDto.getId(), objDto.getNome());
	//}
	public Produto salvarProdutoDTO(NewProdutoDTO prodDTO) {
		
		Produto produto = new Produto((prodDTO.getId() !=0) ? null:  prodDTO.getId() ,prodDTO.getNome(),prodDTO.getCodigo(),prodDTO.getCategoria());
		Preco preco = new Preco(null,prodDTO.getPreco());
		Tamanho tamanho = new Tamanho(null,prodDTO.getTamanho(), preco,produto);
		produto.getTamanho().add(tamanho);
		tamanho.setPreco(preco);
		
	 return produto;
	}
	public void deletar (Long id) {
	  repProduto.deleteById(id);
	}
	
	public void atualizar(NewProdutoDTO prodDTO,long id) {
		Produto newObj = buscarProduto(id);
		 Produto pro = salvarProdutoDTO(prodDTO);
		 
		    if (newObj.getId().SIZE >0) {
		    	repProduto.delete(newObj);
		    	repProduto.save(pro);
		    }
	}
	public void atualizarDados(Produto newProd, Produto pro) {
		newProd.setCodigo(pro.getCodigo());
		newProd.setNome(pro.getNome());
		newProd.setCategoria(pro.getCategoria());
		newProd.setTamanho(pro.getTamanho());
	}

}
