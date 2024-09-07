package com.bootjpa.example.helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.hibernate.annotations.Comment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileuploadhelper {
	//public final String UPLOAD_DIR="D:\\spring boot pro\\bootrestbook\\src\\main\\resources\\static\\image";
	public final String UPLOAD_DIR= new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	
	public  fileuploadhelper() throws IOException{
		
	}

	public boolean uploadFile(MultipartFile mutlipart) {
		boolean f = false;
		
		try {
			
			
//		InputStream= mutlipart.getInputStream()	;
//		byte data[]= new byte [is.available()];
//		is.read(data);
//			
			Files.copy(mutlipart.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+mutlipart.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			
			f= true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return f;
		
	}
}
