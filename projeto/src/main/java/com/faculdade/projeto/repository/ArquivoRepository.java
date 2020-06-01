package com.faculdade.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.faculdade.projeto.model.ArquivoModel;

@Transactional
public interface ArquivoRepository extends JpaRepository<ArquivoModel, Long> {
	public ArquivoModel findByNome(String nome);
}
