package br.com.caixa.restCaixa.Controle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.caixa.restCaixa.DTO.ProdutoDTO;
import br.com.caixa.restCaixa.Service.ProdutoService;
import br.com.caixa.restCaixa.modelo.Produto;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoControle {
	
	@Autowired
	ProdutoService pro_Service;
	
@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
 public List<ProdutoDTO>  buscaPorCodigo(@PathVariable Integer codigo) {
	List<Produto> list = pro_Service.buscarDTO(codigo);
	List<ProdutoDTO> prod = list.stream().map(pro -> new ProdutoDTO(pro)).collect(Collectors.toList());
	
	 return prod;
 }

}
