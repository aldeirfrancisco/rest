package br.com.caixa.restCaixa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caixa.restCaixa.modelo.Tamanho;

@Repository
public interface RepositoryTamanho extends JpaRepository< Tamanho, Long>{



}

