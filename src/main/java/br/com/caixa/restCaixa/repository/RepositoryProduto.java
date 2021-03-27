package br.com.caixa.restCaixa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caixa.restCaixa.modelo.Produto;

@Repository
public interface RepositoryProduto extends JpaRepository< Produto, Long>{
	
	List< Produto >  findByCodigo (Integer codigo );
	
	
}