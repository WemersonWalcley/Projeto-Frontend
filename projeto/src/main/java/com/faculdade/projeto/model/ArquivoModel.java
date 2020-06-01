package com.faculdade.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

import com.faculdade.projeto.model.View;

@Getter
@Setter
@Entity
@Table(name="file_model")
public class ArquivoModel {

	@Id
	@GeneratedValue
    @Column(name = "id")
	@JsonView(View.FileInfo.class)
    private Long id;
	
    @Column(name = "nome")
    @JsonView(View.FileInfo.class)
	private String nome;
    
    @Column(name = "tipoArquivo")
	private String tipoArquivo;
	
	@Lob
    @Column(name="tamanho")
    private byte[] tamanho;
	
	public ArquivoModel(){}
	
	public ArquivoModel(String nome, String tipoArquivo, byte[] tamanho){
		this.nome = nome;
		this.tipoArquivo = tipoArquivo;
		this.tamanho = tamanho;
	}
}
