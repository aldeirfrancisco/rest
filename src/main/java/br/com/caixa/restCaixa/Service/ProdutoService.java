package br.com.caixa.restCaixa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caixa.restCaixa.modelo.Produto;
import br.com.caixa.restCaixa.repository.RepositoryProduto;
@Service
public class ProdutoService {
	@Autowired
	RepositoryProduto produtoRepository;
	
	
	
	public List<Produto> buscarDTO(Integer codigo) {
		return produtoRepository.findByCodigo(codigo);
	}
}
