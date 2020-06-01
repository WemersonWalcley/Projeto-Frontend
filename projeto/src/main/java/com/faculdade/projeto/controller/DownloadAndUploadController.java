package com.faculdade.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.faculdade.projeto.model.ArquivoModel;
import com.faculdade.projeto.model.View;
import com.faculdade.projeto.repository.ArquivoRepository;

@RestController
public class DownloadAndUploadController {
	
	@Autowired
	ArquivoRepository arquivoRepository;

    @JsonView(View.FileInfo.class)
	@GetMapping("/api/file/all")
	public List<ArquivoModel> getListFiles() {
		return arquivoRepository.findAll();
	}
    
	@GetMapping("/api/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
		Optional<ArquivoModel> fileOptional = arquivoRepository.findById(id);
		
		if(fileOptional.isPresent()) {
			ArquivoModel file = fileOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getNome() + "\"")
					.body(file.getTamanho());	
		}
		
		return ResponseEntity.status(404).body(null);
	}
	
	@PostMapping("/api/file/upload")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file) {
    	try {
	    	ArquivoModel filemode = new ArquivoModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
	    	arquivoRepository.save(filemode);
	    	return "Upload concluído com sucesso!";
		} catch (	Exception e) {
			return "Erro ao fazer upload do arquivo, verifique se ele é maior que 500kb";
		}    
    }

}
