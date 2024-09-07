package com.bootjpa.example.Ctl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bootjpa.example.helper.fileuploadhelper;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class Fileupload {
	
	@Autowired
	private fileuploadhelper fileuploadhelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		
//		System.out.println(file.getName());
//		System.out.println(file.getContentType());
		try {
		
		if(file.isEmpty() ) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
		}
		if(!file.getContentType().equals("image/jpeg")) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg are allowed");

		}
		
		
	boolean f=	fileuploadhelper.uploadFile(file);
	if(f) {
		//return ResponseEntity.ok("file is successfuly uloded");
	
	
		return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
	}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong plzz try again");
		
		
	}
	
	

}
