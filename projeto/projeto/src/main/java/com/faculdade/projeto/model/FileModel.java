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
public class FileModel {

	@Id
	@GeneratedValue
    @Column(name = "id")
	@JsonView(View.FileInfo.class)
    private Long id;
	
    @Column(name = "name")
    @JsonView(View.FileInfo.class)
	private String name;
    
    @Column(name = "mimetype")
	private String mimetype;
	
	@Lob
    @Column(name="pic")
    private byte[] pic;
	
	public FileModel(){}
	
	public FileModel(String name, String mimetype, byte[] pic){
		this.name = name;
		this.mimetype = mimetype;
		this.pic = pic;
	}
}
