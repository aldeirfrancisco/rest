package br.com.caixa.restCaixa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.caixa.restCaixa.Enum.Categoria;
import br.com.caixa.restCaixa.modelo.Preco;
import br.com.caixa.restCaixa.modelo.Produto;
import br.com.caixa.restCaixa.modelo.Tamanho;
import br.com.caixa.restCaixa.repository.RepositoryPreco;
import br.com.caixa.restCaixa.repository.RepositoryProduto;
import br.com.caixa.restCaixa.repository.RepositoryTamanho;

@SpringBootApplication
public class RestCaixaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestCaixaApplication.class, args);
	}
@Autowired
RepositoryProduto repProduto;
@Autowired
RepositoryPreco repPreco;	
@Autowired
RepositoryTamanho repTamanho;

public void run(String... args) throws Exception {
	Preco preco = new Preco(null,34.89);
	Tamanho tamanho = new Tamanho(null, "Grande", preco);
	Produto produto = new Produto(null,"Calabresa",3, Categoria.PIZZA);
	 produto.getTamanho().add(tamanho);
	 tamanho.setPreco(preco);
	 repTamanho.save(tamanho);
	  repPreco.save(preco);
	  repProduto.save(produto);
	Preco prec = new Preco(null,10.50);
	Tamanho tamanh = new Tamanho(null, "Grande", prec);
	Produto prod = new Produto(null,"Coca", 4,Categoria.BEBIDA);
	prod.getTamanho().add(tamanh);
	repTamanho.save(tamanh);
	repPreco.save(prec);
	repProduto.save(prod);
	

}

}
