package com.javasampleapproach.multipartfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.javasampleapproach.multipartfile.model.FileModel;

@Transactional
public interface FileRepository extends JpaRepository<FileModel, Long>{	
	public FileModel findByName(String name);
}