package br.com.caixa.restCaixa.Controle;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.caixa.restCaixa.DTO.NewProdutoDTO;
import br.com.caixa.restCaixa.DTO.ProdutoDTO;
import br.com.caixa.restCaixa.Service.ProdutoService;
import br.com.caixa.restCaixa.modelo.Produto;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRest {
	
	@Autowired
	ProdutoService pro_Service;
	
@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
 public ResponseEntity<?> buscaPorCodigo(@PathVariable Integer codigo) {
	
	List<Produto> list = pro_Service.buscarDTO(codigo);
	List<ProdutoDTO> prod = list.stream().map(pro -> new ProdutoDTO(pro)).collect(Collectors.toList());
	
	 return ResponseEntity.ok().body(prod);
 }
@RequestMapping(value = "/novo",method = RequestMethod.POST)
 public void cadastrarProduto(@RequestBody NewProdutoDTO prodDTO) {
	 Produto pro = pro_Service.salvarProdutoDTO(prodDTO);
	 pro_Service.inserir(pro);
 }
@RequestMapping(value = "/deletar/{id}",method = RequestMethod.DELETE)
public void teletarProduto(@PathVariable long id) {
	 pro_Service.deletar(id);
}
@RequestMapping(value = "/atualizar/{id}",method = RequestMethod.PUT)
public void atualizarProduto(@RequestBody ProdutoDTO prodDTO, @PathVariable long id) {
	prodDTO.setId(id);
	 Produto pro = pro_Service.fromDTO(prodDTO);
	 pro_Service.atualizar(pro);
}


}
