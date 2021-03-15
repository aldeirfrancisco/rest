package br.com.caixa.restCaixa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.caixa.restCaixa.Enum.Categoria;
import br.com.caixa.restCaixa.Enum.Tamanho;
import br.com.caixa.restCaixa.modelo.Preco;
import br.com.caixa.restCaixa.modelo.Produto;
import br.com.caixa.restCaixa.repository.RepositoryPreco;
import br.com.caixa.restCaixa.repository.RepositoryProduto;

@SpringBootApplication
public class RestCaixaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestCaixaApplication.class, args);
	}
	@Autowired
RepositoryProduto repProduto;
	@Autowired
RepositoryPreco repPreco;
public void run(String... args) throws Exception {
	Preco preco = new Preco(34.89);
	  Produto produto = new Produto(3,"Calabresa",Tamanho.MEDIA, preco, Categoria.PIZZA);
	  //Integer codigo, String nome, Tamanho tamanho, Preco preco, Categoria categoria
	  repPreco.save(preco);
	  repProduto.save(produto);
	Preco prec = new Preco(10.50);
	Produto prod = new Produto(4,"Coca",Tamanho.GRANDE, prec, Categoria.BEBIDA);
	repPreco.save(prec);
	repProduto.save(prod);
	

}

}
